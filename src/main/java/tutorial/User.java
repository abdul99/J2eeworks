package tutorial;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr") // @Table is optional, but "user" is a keyword in many SQL variants 
@NamedQueries({
@NamedQuery(name = "User123.findByName", query = "select u from User u ")
})
public class User {
	 @Id // @Id indicates that this it a unique primary key
	   // @GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValue indicates that value is automatically generated by the server
	   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="judgements_id_seq")
	   
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UserC1_id_seq")
	    @SequenceGenerator(name="UserC1_id_seq", sequenceName="UserC1_id_seq", allocationSize=1)
	    private Long id;

	    @Column(length = 32, unique = true)
	    // the optional @Column allows us makes sure that the name is limited to a suitable size and is unique
	    private String name;

	    // note that no setter for ID is provided, Hibernate will generate the ID for us

	    public long getId() {
	        return id;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

		@ManyToMany
		  private  Set<Role> roles = new HashSet<Role>();

	    public boolean addRole(Role role) {
	        return roles.add(role);
	    }

	    public Set<Role> getRoles() {
	        return roles;
	    }
}