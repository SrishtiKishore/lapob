package paraballo;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class search_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public search_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public void ProcessRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		Configuration cfg = new Configuration();

    		String s=request.getParameter("search");
    		if(s.startsWith("lap")){

    			cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(lap.class);
    		  	SessionFactory factory = cfg.buildSessionFactory();
    			Session session = factory.openSession();
    	        Transaction t=session.beginTransaction();  
    		    List res=session.createQuery("from lap").list();    
    		    request.setAttribute("laptoplist", res);
    		   //res.get(index)
    		    t.commit();
    		    session.close();
    		    factory.close();
    		    RequestDispatcher rd=request.getRequestDispatcher("lap.jsp");
    		    rd.forward(request, response);  
    		}
    		if(s.startsWith("Mob")) {
    			cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(mob.class);
    		  	SessionFactory factory = cfg.buildSessionFactory();
    			Session session = factory.openSession();
    	        Transaction t=session.beginTransaction();  
    		    List res=session.createQuery("from mob").list();    
    		    request.setAttribute("moblist", res);
    		   //res.get(index)
    		    t.commit();
    		    session.close();
    		    factory.close();
    		    RequestDispatcher rd=request.getRequestDispatcher("mob.jsp");
    		    rd.forward(request, response); 
        		 
        		}
    	    else{
    		RequestDispatcher rd=request.getRequestDispatcher("notfound.jsp");
    		rd.forward(request, response);   
    		
    	}
    		/**<dependency>
    	    <groupId>jstl</groupId>
    	    <artifactId>jstl</artifactId>
    	    <version>1.2</version>
    	</dependency>**/
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request,response);
		
	}

}
