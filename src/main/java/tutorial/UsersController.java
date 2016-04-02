package tutorial;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * @author: alexec (alex.e.c@gmail.com)
 */
@Controller
public class UsersController {

	/*@PersistenceUnit(unitName = "tutorialPU")
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping("/users")
    public String users(Model model) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        model.addAttribute("users", entityManager.createQuery("select u from User u").getResultList());

        return "users";
    }
*/
	 /*@PersistenceContext(unitName = "tutorialPU")
	  
	 
	 private EntityManager entityManager;

	    @PersistenceContext(unitName = "tutorialPU")
	    public void setEm(EntityManager entityManager)
	    {
	        this.entityManager = entityManager;
	    }
*/
	/*@PersistenceUnit(unitName = "tutorialPU")
	private EntityManagerFactory entityManagerFactory;*/
	
	
	
	@PersistenceContext(name = "PU_AbdulDS2")  
	 private EntityManager entityManager;
	
	    @RequestMapping("/users")
	    public String users(Model model) {

	      // model.addAttribute("users", entityManager.createQuery("select u from User u").getResultList());
       //User.findByName
	    	//EntityManager entityManager = entityManagerFactory.createEntityManager();
	    	if(entityManager==null){
	    		
	    		throw new NullPointerException("entitymanager is null");
	    	}
	    	if(entityManager!=null){ 
	    		System.out.println("emnull");
	    	
	        model.addAttribute("users", entityManager.createNamedQuery("User123.findByName",User.class)
	        		.getResultList());}   
	        return "users";
	    }
	    
	    
    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String createUser(Model model) {
        return "create-user";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    @Transactional
    public String createUser(Model model, String name) {

    	  User user = new User();
        user.setName(name);

       // entityManager.persist(user);

        return "redirect:/users.html";
    }
}
