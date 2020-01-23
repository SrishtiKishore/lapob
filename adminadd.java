package paraballo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.omg.CORBA_2_3.portable.OutputStream;

/**
 * Servlet implementation class adminadd
 */
@MultipartConfig
public class adminadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  public adminadd() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	
	public void lap(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		
		  
	    Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(lap.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		  String n=request.getParameter("name");
		  String o=request.getParameter("os");
		  String PROCESSOR=request.getParameter("processor");
		  String RAM=request.getParameter("ram");
		  String SYS_TYPE=request.getParameter("sys_type");
		  String BRAND=request.getParameter("brand");
		  String PROCESSING_SPEED=request.getParameter("processing_speed");
		  String architecture=request.getParameter("architecture");
		  String avl=request.getParameter("avail");
		  String processor_speed=request.getParameter("processor_speed");
		  
		  InputStream file=request.getPart("fileupload").getInputStream();
		  byte[] b=new byte[(int)request.getPart("fileupload").getSize()];
		 // System.out.print((int)request.getPart("fileupload").getSize());
		  file.read(b);
		  //C:\\Users\\Ashutosh\\eclipse-workspace\\MYHUB\\src\\main\\webapp\\laptop\\
		  //File fi=new File(""+n+"_"+BRAND);
		  String path = getServletContext().getRealPath("/")+"laptop'\'"+n+"_"+BRAND+".jpg";	        
		  FileOutputStream fl=new FileOutputStream(path);
		  fl.write(b);
		  fl.close();
		  
		//String s="\\MYHUB\\src\\main\\webapp\\laptop"+ n+"_"+BRAND+".jpg";
		imglaptop im=new imglaptop(path);
		lap l=new lap(n,o,PROCESSOR,RAM,SYS_TYPE,BRAND,PROCESSING_SPEED,architecture,processor_speed,im,avl);
    	Transaction t=session.beginTransaction();

		session.save(l);
		t.commit();    
		session.close();
		factory.close(); 
		
	}
	
	public void mob(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		
		 Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(mob.class);
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			  String n=request.getParameter("name");
			  String o=request.getParameter("os");
			  String PROCESSOR=request.getParameter("processor");
			  String RAM=request.getParameter("ram");
			  String SYS_TYPE=request.getParameter("sys_type");
			  String BRAND=request.getParameter("brand");
			  String PROCESSING_SPEED=request.getParameter("processing_speed");
			  String architecture=request.getParameter("architecture");
			  String avl=request.getParameter("avail");
			  String processor_speed=request.getParameter("processor_speed");
			  String price=request.getParameter("price");
			  InputStream file=request.getPart("fileupload").getInputStream();
			  byte[] b=new byte[(int)request.getPart("fileupload").getSize()];
			 // System.out.print((int)request.getPart("fileupload").getSize());
			  file.read(b);
			  //C:\\Users\\Ashutosh\\eclipse-workspace\\MYHUB\\src\\main\\webapp\\laptop\\
			  //File fi=new File(""+n+"_"+BRAND);
			  String path = getServletContext().getRealPath("/")+"laptop\\"+n+"_"+BRAND+".jpg";	        
			  FileOutputStream fl=new FileOutputStream(path);
			  fl.write(b);
			  fl.close();
			  
			//String s="\\MYHUB\\src\\main\\webapp\\laptop"+ n+"_"+BRAND+".jpg";
			imglaptop im=new imglaptop(path);
			mob m=new mob(n,o,PROCESSOR,RAM,SYS_TYPE,BRAND,PROCESSING_SPEED,architecture,processor_speed,price,im,avl);
	    	Transaction t=session.beginTransaction();

			session.save(m);
			t.commit();    
			session.close();
			factory.close(); 
			

		
		
		
	}
	
   public void processrequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
   { 
	    
	   
		  String product=request.getParameter("product");
		  
		  
		  if(product.equalsIgnoreCase("laptop"))
		  		lap(request,response);
		  else
			  mob(request,response);
		  
		  
		  
		  	
		RequestDispatcher rd=request.getRequestDispatcher("adminadd.jsp");
		rd.forward(request, response);  
		
		
   }
  
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processrequest( request,  response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processrequest( request,  response);
		//doGet(request, response);
	}

}
