package tutorial;

 

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/* try {
			Context initCtx = new InitialContext();
			 javax.persistence.EntityManager entityManager = (javax.persistence.EntityManager) 
			            initCtx.lookup("java:/AbdulDS2");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/
		 
		EntityManager entityManager = Persistence.createEntityManagerFactory("tutorialPU").createEntityManager();

		entityManager.getTransaction().begin();

		UserC user = new UserC();

		user.setName(Long.toString(new Date().getTime()));

		entityManager.persist(user);

		entityManager.getTransaction().commit();

		// see that the ID of the user was set by Hibernate
		System.out.println("user=" + user + ", user.id=" + user.getId());

		UserC foundUser = entityManager.find(UserC.class, user.getId());

		// note that foundUser is the same instance as user and is a concrete
		// class (not a JDX proxy)
		System.out.println("foundUser=" + foundUser);

		//assertEquals(user.getName(), foundUser.getName());

		entityManager.close();
		
		

	}

}
