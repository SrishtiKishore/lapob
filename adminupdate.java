package paraballo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Servlet implementation class adminupdate
 */
public class adminupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public adminupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected  void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(lap.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t=session.beginTransaction();
		
		String name=request.getParameter("name");
		String brand=request.getParameter("brand");
		String os=request.getParameter("os");
	       
			  Query query=session.createQuery("from laptoptab where name=:name and brand=:brand");    
			  query.setParameter("name",name); 
			  query.setParameter("brand",brand);  
			  
			  List l=query.list();
			  lap obj=(lap)l.get(1);
		      
		      t.commit();
	          factory.close();
	          session.close();
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 update(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
