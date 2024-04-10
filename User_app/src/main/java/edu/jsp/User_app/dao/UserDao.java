package edu.jsp.User_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.User_app.User;

public class UserDao {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	static EntityManager em= emf.createEntityManager();
	static EntityTransaction et= em.getTransaction();
	 
	public void saveUser(User user) {
		
		et.begin();
		em.persist(user);
		et.commit();
		System.out.println("Data Insert"); 	 
	}
	
	public User getuserByIdUser(int id) {
		return em.find(User.class,id);	
	}
	
	public void deletUser(int id) {
		User u1 = em.find(User.class, id);
		if(u1!=null) {
			et.begin();
			em.remove(u1);;
			et.commit();
			System.out.println("delete success");
		}
	}
	
	public List<User> getAllUserDetails(){   	 
   	 EntityManager em = emf.createEntityManager();
   	 Query q= em.createQuery("select u from user u");
   	 return q.getResultList();
    }
	 
	public List<User> getAll(){
		Query q=em.createQuery("select u from User u");
		return q.getResultList() ;
		
	}
}


