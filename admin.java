package paraballo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public admin() {
        super();
    }
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uid=request.getParameter("uid");
    	String p=request.getParameter("pswd");
    	
    	Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(user_table.class);
	  	SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
          
	    Query query=session.createQuery("from user_table where email=:username and password=:password");    
	    query.setParameter("username",uid); 
	    query.setParameter("password",p);  
 
	  List res=query.list(); 
	  if(!res.isEmpty()) {
		 RequestDispatcher r= request.getRequestDispatcher("adminaction.jsp");
	     r.forward(request, response);
	  }
	  else {
		  
		  RequestDispatcher r= request.getRequestDispatcher("admin.jsp");
		     PrintWriter out = response.getWriter();  
		     response.setContentType("text/html");  
		     out.println("<script type=\"text/javascript\">");  
		     out.println("alert('Userid or Password invalid');");  
		     out.println("</script>");
		     r.include(request, response);

	  }
       
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        process(request,response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
		//doGet(request, response);
	}

}
