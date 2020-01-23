
package paraballo;


import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class loginaction {
 public loginaction(){
	 
 }
	public  boolean verify(String e,String pswd) {
		
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(user_table.class);
		  	SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
              
		  Query query=session.createQuery("from user_table where email=:username and password=:paswd");    
		  query.setParameter("username",e); 
		  query.setParameter("paswd",pswd);  

		  List res=query.list(); 
		        
		    if(res.isEmpty()){
		    	return false;
		    }
		    else
		    	return true;
			
		
	}
	
	
}
