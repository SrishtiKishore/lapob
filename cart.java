package paraballo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }
  protected void process(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	  
	  HttpSession sess=req.getSession();
	  if(sess.getAttribute("logout")=="y") {
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
  		rd.include(req, res);  
  		
	  }
	  else {
		  
		  Configuration cfg= new Configuration();
			cfg.addAnnotatedClass(cart_tab.class);
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
	        Transaction t=session.beginTransaction(); 

	        Query qry=session.createQuery("from cart_tab where email=:e");    
		    qry.setParameter("e",sess.getAttribute("uid"));
		    List result=qry.list();
		    if(result!=null)
		    { 
		     req.setAttribute("cart_item", result);
		    }
		    session.close();
		    factory.close();
		   
		   
	  		
	  }
		  
  }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
