package paraballo;


import java.io.File;
import java.io.FileInputStream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Blob;


public class mobget {
         
	
	    public mob mobilget()throws Exception {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(mob.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t=session.beginTransaction();
		mob obj=session.get(mob.class,1);
		 
		t.commit();
		session.close();
		factory.close();
		
		return obj;
	}
	    public void set()throws Exception{
	    	Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(mob.class);
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
		   String path="C:\\Users\\Ashutosh\\eclipse-workspace\\MYHUB\\src\\main\\webapp\\laptop\\";
			File imgpath=new File("C:\\Users\\Ashutosh\\eclipse-workspace\\MYHUB\\src\\main\\webapp\\laptop\\2.png");
			FileInputStream f=new FileInputStream(imgpath);
			byte[] img=new byte[(int)imgpath.length()];
			//Blob b=f.;
			f.read(img);
			f.close();
			
			imglaptop i=new imglaptop(path);
			session.save(i);

			//mob l=new mob(1,"lava","windows","intel","4gb","dos","new","16mbps","quad core","40",i);
			Transaction t=session.beginTransaction();
			//session.save(l);			 
			t.commit();
			
			session.close();
			factory.close();
	    	
	   
	    }
	   
	    
} 
