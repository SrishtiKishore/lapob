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
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

   protected void chk_login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(user_table.class);
	  	SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
         
	  Query query=session.createQuery("from user_table where email=:username and password=:paswd");    
	  query.setParameter("username",request.getParameter("email"));
	  query.setParameter("paswd",request.getParameter("psw"));
	  List res=query.list(); 
      
	    if(res.isEmpty()){
	    	RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
	        rd.forward(request, response);
	    }
	    else
	    	{
	    	HttpSession sess=request.getSession();
	    	sess.setAttribute("uid",request.getParameter("email") );
	    	sess.setAttribute("logout", "n");
	    	RequestDispatcher rd=request.getRequestDispatcher("useracct.jsp");
	        rd.forward(request, response);
	    
	    	}
	   
   }
   

    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 chk_login(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
