package paraballo;

import paraballo.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Blob;


public class lapget {
        
	    public lap laptopget()throws Exception {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(lap.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t=session.beginTransaction();
		lap obj=session.get(lap.class,0);
		//byte imagebytes[]=obj.getImg().getImage();
		
		t.commit();
		session.close();
		factory.close();
		
		
		return obj;
	}
	    public void set()throws Exception{
	    	Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(lap.class);
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
		    String path="C:\\Users\\Ashutosh\\eclipse-workspace\\MYHUB\\src\\main\\webapp\\laptop\\";
			File imgpath=new File(path+"3.png");
			FileInputStream f=new FileInputStream(imgpath);
			byte[] img=new byte[(int)imgpath.length()];
			//Blob b=f.;
			f.read(img);
			
			f.close();
			
			imglaptop i=new imglaptop();
			//session.save(i);
			lap l=new lap("vostrio","windows","intel","4gb","dos","new","16mbps","quad core","41",i,"y");
			Transaction t=session.beginTransaction();
			session.save(l);			 
			t.commit();    
			session.close();
			factory.close();
	    	
	   
	    }
}
