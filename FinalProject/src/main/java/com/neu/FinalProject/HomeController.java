package com.neu.FinalProject;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.FinalBean.ApplicationDetails;
import com.neu.FinalBean.Credentials;
import com.neu.FinalBean.JobDetails;
import com.neu.FinalBean.Login;
import com.neu.FinalBean.UserProfileDetails;
import com.neu.FinalDAO.*;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);		
		return "Signin";
	}
	
	@RequestMapping(value = "/secured/action", method = RequestMethod.POST)
	public ModelAndView showForm(@RequestParam("Action") String name,Credentials credential,ModelMap model) {
		System.out.println("name" + name);
		if (name.equals("Login")) {
			String role = getUserData(credential);
			if(role.equals("Recruiter")){
				 model.addAttribute("userName", credential.getlUserName());
				return new ModelAndView("RecruiterDashboard", "Credentials", credential);
			}
			else if(role.equals("JobCandidate")){
				model.addAttribute("userName", credential.getlUserName());
				HibernateConnectionDAO dbq = new HibernateConnectionDAO();
				UserProfileDetails userDetail = dbq.getUserDetails(credential.getlUserName());
				if(userDetail != null){
					return new ModelAndView("CandidateFilled","user",userDetail);
				}
				else{
				return new ModelAndView("Candidate", "Credentials", credential);
				}
			}
			else if(role.equals("SysAdmin")){
			
				model.addAttribute("userName", credential.getlUserName());
				return new ModelAndView("AdminDashboard", "Credentials", credential);
				
				
			}
			else{
				//model.addAttribute("userName", credential.getlUserName());
				return new ModelAndView("ErrorSignin", "Credentials", credential);
			}
			
		} else {
			return new ModelAndView("Signup", "Login",new Login());
		}
	}
	
	@RequestMapping(value = "/secured/adminAction", method = RequestMethod.POST)
		public ModelAndView showForm(@RequestParam("Action") String name,ModelMap model) {
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		List<JobDetails> jobs = dbq.fetchAlljobs();
		return new ModelAndView("AdminDeleteJob","jobs",jobs);
		}
	
	@RequestMapping(value = "/secured/viewResume", method = RequestMethod.POST)
	public void onViewResume(HttpServletRequest request,HttpServletResponse response, Model model) throws IOException, ServletException {
		HttpSession session = request.getSession();
		System.out.println("calledAjax");
		String appid = request.getParameter("appid");
		System.out.println(appid);
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		ApplicationDetails appDet = dbq.findApplication(appid);
		String fileName = appDet.getResumeFileName();
		File pdfFile = new File(fileName);
		try{
			Desktop.getDesktop().open(pdfFile);
		}
		catch(Exception e){
			System.out.println(e);
		}
//		

		
	}
	
	@RequestMapping(value = "/secured/updateJobs", method = RequestMethod.POST)
	public void onUpdateJobs(HttpServletRequest request,HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();; 
		System.out.println("calledAjax");
		String jobid = request.getParameter("jobid");
		System.out.println(jobid);
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		int result = dbq.deleteJobs(jobid);
			try {
				response.getWriter().write(result > 0?"success":"failed");
			} catch (IOException e) {
				e.printStackTrace();
			}
//		//ManageUser mu = new ManageUser();
		
	}
	
	@RequestMapping(value = "/secured/updateUser", method = RequestMethod.POST)
	public void onDeleteUser(HttpServletRequest request,HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();; 
		System.out.println("calledAjax");
		String appid = request.getParameter("appid");
		String status = request.getParameter("Status");
		System.out.println(appid);
		System.out.println(status);
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		int result = dbq.upDateStatus(appid,status);
			try {
				response.getWriter().write(result > 0?"success":"failed");
			} catch (IOException e) {
				e.printStackTrace();
			}
//		//ManageUser mu = new ManageUser();
		
	}
	@RequestMapping(value = "/secured/adduser", method = RequestMethod.POST)
	public String submit(@ModelAttribute(value = "Login") Login login, BindingResult result, ModelMap model)
			throws ClassNotFoundException, SQLException, SecurityException, IllegalStateException, RollbackException,
			HeuristicMixedException, HeuristicRollbackException, SystemException {
		if (result.hasErrors()) {
			return "ErrorPage";
		}
		String reg = regUserProcess(login);
	
		if (reg!= null)
			return "RegisteredSuccessfully";
		else
			return "ErrorPage";
	}
	
	@RequestMapping(value = "/secured/recruiterAction", method = RequestMethod.POST)
	public ModelAndView directRecruiterAction(@RequestParam("Action") String Action,@RequestParam("userName") String userName,ModelMap model)
			throws ClassNotFoundException, ServletException, IOException, SQLException {
		//List<Movie> movies = processRequest(colname, keyword);
		//model.addAttribute("movie", movies);
		if(Action.equals("Create Job")){
			System.out.println(Action);
			model.addAttribute("postedBy",userName);
			return new ModelAndView("CreateJob", "JobDetails",new JobDetails());
		}
		else if(Action.equals("Accept")||Action.equals("Reject")){
			System.out.println(Action);
			HibernateConnectionDAO dbq = new HibernateConnectionDAO();
			List<ApplicationDetails> appdetail = dbq.viewApplication(userName);
			model.addAttribute("appdetails",appdetail);
			return new ModelAndView("RecruiterApplication", "appDetails",new ApplicationDetails());
		}
		else{
			HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		List<ApplicationDetails> appdetail = dbq.viewApplication(userName);
		if(appdetail.size()==0){
			return new ModelAndView("NoData", "appDetails",new ApplicationDetails());
		}
		else{
			model.addAttribute("appdetails",appdetail);
			return new ModelAndView("RecruiterApplication", "appDetails",new ApplicationDetails());
		}
			
		}
	}
	
	@RequestMapping(value = "/secured/canditateAction", method = RequestMethod.POST)
	public ModelAndView directCanditateAction(@RequestParam("Action") String Action,@RequestParam("userName") String name,ModelMap model,UserProfileDetails userDetails)
			throws ClassNotFoundException, ServletException, IOException, SQLException {
		if(Action.equals("View Jobs")){
			List<JobDetails> jobs = processRequest();
			model.addAttribute("jobs", jobs);
			//System.out.println(Action);
			//model.addAttribute("postedBy",userName);
		    model.addAttribute("userDetails",name);
			return new ModelAndView("ViewJobs","jobs",jobs);
		}
		else if(Action.equals("Save Profile")){
			System.out.println(Action);
		    String userId = createUserDetails(userDetails);
			if(userDetails!=null){
				return new ModelAndView("CandidateFilled","user",userDetails);
			}
			else{
				return new ModelAndView("ErrorPage","jobs",new JobDetails());
			}
			
		}
		else{
			
			HibernateConnectionDAO dbq = new HibernateConnectionDAO();
			List<ApplicationDetails> appdetail = dbq.viewCandidateApplication(name);
			if(appdetail.size()==0){
				return new ModelAndView("NoData", "appDetails",new ApplicationDetails());
			}
			else{
				model.addAttribute("appdetails",appdetail);
				return new ModelAndView("CandidateApplication","appDetails",new ApplicationDetails());
			}
			
		}
	}
	
	@RequestMapping(value = "/secured/viewAndApply", method = RequestMethod.POST)
	public String directCanditateviewJob(@RequestParam("Action") String Action,@RequestParam("userName") String name,ModelMap model)
			throws ClassNotFoundException, ServletException, IOException, SQLException {
		int jobId = Integer.parseInt(Action);
		JobDetails job=searchJobDetails(jobId);
		model.addAttribute("job",job);
		UserProfileDetails userinfo = searchUserDetails(name);
	    String resumeAnalyzerComment = getResumeAnalyzed(job,userinfo);
	    model.addAttribute("resumeComment",resumeAnalyzerComment);
		model.addAttribute("userDetails",userinfo);
		model.addAttribute("appDetails", new ApplicationDetails());
		return "jobdetails";
	}
	
	
	@RequestMapping(value = "/secured/applyforJob", method = RequestMethod.POST)
	public String CanditateAppliedForJob(@ModelAttribute(value = "appDetails") ApplicationDetails appDetails,ModelMap model)
			throws ClassNotFoundException, ServletException, IOException, SQLException {
		System.out.println(appDetails.getJobTitle());
		System.out.println(appDetails.getResumeFile());
		System.out.println("Entered method");
		saveFile(appDetails);
		
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		int appresult = dbq.createappDetails(appDetails);
		return "AppliedSuccessfully";
		
		
	}
	
	@RequestMapping(value = "/secured/createJob", method = RequestMethod.POST)
	public String createJobAction(@ModelAttribute(value = "JobDetails") JobDetails jobDetails,BindingResult result,ModelMap model)
			throws ClassNotFoundException, ServletException, IOException, SQLException {
		int create = createJobProcess(jobDetails);
		if (create != 0)
			return "JobCreationSuccess";
		else
			return "ErrorPage";
	}
	
	protected int createJobProcess(JobDetails jobDetails){
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		int result = dbq.createJob(jobDetails);
		return result;
	}
	
	protected List processRequest(){
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		List <JobDetails> joblist = dbq.listJobs();
		return joblist;
	}
	protected String regUserProcess(Login login){
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		String result = dbq.regUser(login);
		return result;
	}
	
	protected String getUserData(Credentials credential){
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		String role=dbq.findUser(credential.getlUserName(),credential.getlPassword());
		return role;
	}
	
	protected JobDetails searchJobDetails(int jobId){
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		JobDetails job = dbq.findJobDetails(jobId);
		return job;
	}
	
	protected String createUserDetails(UserProfileDetails userDetails){
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		String details = dbq.saveUserDetails(userDetails);
		return details;
	}
	
	protected UserProfileDetails searchUserDetails(String userName){
		HibernateConnectionDAO dbq = new HibernateConnectionDAO();
		UserProfileDetails details = dbq.saveUserDetails(userName);
		return details;
	}
	
	
	protected String getResumeAnalyzed(JobDetails job,UserProfileDetails userinfo){
		String jobReqSkills= job.getSkills();
		String userAcqSkills = userinfo.getSkills();
		
		List<String> jobSkills =Arrays.asList(jobReqSkills.split(","));
		
		List<String> userSkills =Arrays.asList(userAcqSkills.split(","));
		int jobSkillsCount = jobSkills.size();
		int countMatchSkills = 0;
		for(int i=0;i<userSkills.size();i++){
			for(int j=0;j<jobSkills.size();j++){
				if(userSkills.get(i).equals(jobSkills.get(j))){
					countMatchSkills++;
				}
			}
		}
		if(countMatchSkills==0){
			return "Job Profile doesn't match as per Job Requirement";
		}
		else if(jobSkillsCount-countMatchSkills<=2){
			return "Ideal Profile matched as per Requirement";
		}
		else if((jobSkillsCount-countMatchSkills>2||
				jobSkillsCount-countMatchSkills<=5)){
			return "Most Skills matched as per Requirement";
			}
		else{
			return "Average Profile matched as per Requirement";
		}
	
		
		
		
		
	}
	
	protected void saveFile(ApplicationDetails appDetails)throws IllegalStateException, IOException{
		File file;
		String path ="/Users/Abhishek/Documents/uploads";
				 //System.getProperty("catalina.home") + "\\uploads\\";  /Users/Abhishek/Documents
		if (appDetails.getResumeFile() != null) {

			String fileNameWithExt = System.currentTimeMillis() 
					+ appDetails.getResumeFile().getOriginalFilename();
			file = new File(path , fileNameWithExt);
			appDetails.getResumeFile().transferTo(file);
			appDetails.setResumeFileName(path +"/"+ fileNameWithExt);

		}
	}
	
}


