package com.neu.FinalDAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.neu.FinalBean.ApplicationDetails;
import com.neu.FinalBean.JobDetails;
import com.neu.FinalBean.Login;
import com.neu.FinalBean.UserProfileDetails;

public class HibernateConnectionDAO {
	private static SessionFactory factory;

	
	public String regUser(Login login){
	  // SessionFactory factory;
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(Login.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	    Transaction tx = null;
	    String userID = null;
	    try{
	       tx = (Transaction) session.beginTransaction();
	       userID =  (String)session.save(login); 
	       tx.commit();
	    }
	    catch (HibernateException e) 
	    {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace(); 
	    }
	    finally {
	       session.close(); 
	    }
	    return userID;
	 }
	
	public List<JobDetails> fetchAlljobs(){
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(JobDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
    Transaction tx = null;
    List<JobDetails> joblist = null;
    try{
       tx = (Transaction) session.beginTransaction();
       String hql = "FROM JobDetails";
       Query query = session.createQuery(hql);
       joblist = query.list();
       tx.commit();
    }
    catch (HibernateException e) 
    {
       if (tx!=null) tx.rollback();
       e.printStackTrace(); 
    }
    finally {
       session.close(); 
    }
    return joblist;
 }
	
	
	public int createJob(JobDetails jobDetails){
		//  SessionFactory factory;
			Session session = null;
			try {
				factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(JobDetails.class).buildSessionFactory();
				session = factory.openSession();

			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}
	    Transaction tx = null;
	    int jobId = 0 ;
	    try{
	       tx = (Transaction) session.beginTransaction();
	       jobId =  (Integer) session.save(jobDetails); 
	       tx.commit();
	    }
	    catch (HibernateException e) 
	    {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace(); 
	    }
	    finally {
	       session.close(); 
	    }
	    return jobId;
	 }
	
	public String findUser(String userName,String password){
	//	 SessionFactory factory;
			Session session = null;
			try {
				factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(Login.class).buildSessionFactory();
				session = factory.openSession();

			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		Transaction tx = null;
		List<Login> login = null;
		String username = "not Found";
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM Login L WHERE L.userName like:userName and L.password like:password";
			Query query = session.createQuery(hql);
			query.setParameter("userName",userName);
			query.setParameter("password",password);
			login = query.list();
			tx.commit();
			System.out.println(login.size());
			if(login.size() != 0){
				username = login.get(0).getRole();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return username;
	}
	public List listJobs(){
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(JobDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		List<JobDetails> jobsList = null;
		String username = "not Found";
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM JobDetails";
			Query query = session.createQuery(hql);
			jobsList = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobsList;
	}
	
	
	public JobDetails findJobDetails(int jobId){
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(JobDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		List<JobDetails> jobsList = null;
		JobDetails job =null;
		//String username = "not Found";
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM JobDetails WHERE jobID = :JOBID";
			Query query = session.createQuery(hql);
			query.setParameter("JOBID",jobId);
			jobsList = query.list();
			job = jobsList.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return job;
	}
	
	public String saveUserDetails(UserProfileDetails userDetails){
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(UserProfileDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		//List<JobDetails> jobsList = null;
		String userName =null;
		//String username = "not Found";
		try {
			 tx = (Transaction) session.beginTransaction();
			 userName =  (String) session.save(userDetails); 
		      tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userName;
	}
	
	public int createappDetails(ApplicationDetails appDetails){
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(ApplicationDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		//List<JobDetails> jobsList = null;
		int appId =0;
		//String username = "not Found";
		try {
			 tx = (Transaction) session.beginTransaction();
			 appId =  (Integer) session.save(appDetails); 
		      tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return appId;
	}
	
	public List<ApplicationDetails> viewApplication(String userName){
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(ApplicationDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		List<ApplicationDetails> appList = null;
		//String username = "not Found";
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM ApplicationDetails where postedBy like:userName";
			
			Query query = session.createQuery(hql);
			query.setParameter("userName",userName);
			appList = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return appList;
	}
	
	public List<ApplicationDetails> viewCandidateApplication(String userName){
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(ApplicationDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		List<ApplicationDetails> appList = null;
		//String username = "not Found";
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM ApplicationDetails where userName like:userName";
			
			Query query = session.createQuery(hql);
			query.setParameter("userName",userName);
			appList = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return appList;
	}
	
	public UserProfileDetails saveUserDetails(String userName){
	//	 SessionFactory factory;
			Session session = null;
			try {
				factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(UserProfileDetails.class).buildSessionFactory();
				session = factory.openSession();

			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		Transaction tx = null;
		List<UserProfileDetails> userList = null;
		UserProfileDetails userDetails = null;
		String username = "not Found";
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM UserProfileDetails  WHERE userName like:userName";
			Query query = session.createQuery(hql);
			query.setParameter("userName",userName);
			//query.setParameter("password",password);
			userList = query.list();
			tx.commit();
		//	System.out.println(login.size());
			if(userList.size() != 0){
				
				userDetails = userList.get(0);
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userDetails;
	}
	
	public int deleteJobs(String jobid){
		Session session = null;
		int jobId = Integer.parseInt(jobid);
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(JobDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		int result=0;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM JobDetails "  + 
		             "WHERE jobID = :job_id";
			//String hql = "FROM UserProfileDetails  WHERE userName like:userName";
			Query query = session.createQuery(hql);
			query.setParameter("job_id",jobId);
			result = query.executeUpdate();
			tx.commit();
		//	System.out.println(login.size());
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public ApplicationDetails findApplication(String appid){
		Session session = null;
		int appliId=Integer.parseInt(appid);
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(ApplicationDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		List<ApplicationDetails> appList = null;
		//String username = "not Found";
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM ApplicationDetails where applicationID = :appID";
			
			Query query = session.createQuery(hql);
			query.setParameter("appID",appliId);
			appList = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return appList.get(0);
	}
	public int upDateStatus(String appId,String Status){
		Session session = null;
		int appliId = Integer.parseInt(appId);
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(ApplicationDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Transaction tx = null;
		int result=0;
		try {
			tx = session.beginTransaction();
			String hql = "UPDATE ApplicationDetails set status = :status "  + 
		             "WHERE applicationID = :applicId";
			//String hql = "FROM UserProfileDetails  WHERE userName like:userName";
			Query query = session.createQuery(hql);
			query.setParameter("status",Status);
			query.setParameter("applicId",appliId);
			result = query.executeUpdate();
			tx.commit();
		//	System.out.println(login.size());
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public UserProfileDetails getUserDetails(String userName){
		Session session = null;
		try {
			factory = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(UserProfileDetails.class).buildSessionFactory();
			session = factory.openSession();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	Transaction tx = null;
	List<UserProfileDetails> userList = null;
	UserProfileDetails userDetails = null;
	String username = "not Found";
	try {
		tx = session.beginTransaction();
		
		String hql = "FROM UserProfileDetails  WHERE userName like:userName";
		Query query = session.createQuery(hql);
		query.setParameter("userName",userName);
		//query.setParameter("password",password);
		userList = query.list();
		tx.commit();
	//	System.out.println(login.size());
		if(userList.size() != 0){
			
			userDetails = userList.get(0);
		}
	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	return userDetails;
		
	}
	
	}






