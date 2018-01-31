package somepackage;

import javax.faces.bean.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


@ManagedBean
public class SomeBean {
  private String someProperty = "Blah, blah";

  public String getSomeProperty() {
    return(someProperty);
  }

  public void setSomeProperty(String someProperty) {
    this.someProperty = someProperty;
  }
  
  public String someActionControllerMethod() {
/*	  
	  User user=new User();

	    user.setName("Doland12tani");
	    user.setMbiemer("Balla");
	    user.setEmail("dolandb94@gmail.com");
	   
	    
	    Configuration conf = new Configuration().configure().addAnnotatedClass(User.class);


	  ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

	  

	  SessionFactory sf = conf.buildSessionFactory(sr);

	  Session session = sf.openSession();
	 Transaction tx= session.beginTransaction();
	  
	  //  session.save(user);  //ose persist
	 	user=(User)session.get(User.class, 7);
	 	user.setEmail("karzanxhiu");
	 	session.save(user);
	    tx.commit();
	    System.out.println(user);*/
	    
	  
    return("page-b");  // Means to go to page-b.xhtml (since condition is not mapped in faces-config.xml)
  }
  
  public String someOtherActionControllerMethod() {
    return("index");  // Means to go to index.xhtml (since condition is not mapped in faces-config.xml)
  }
  
}
