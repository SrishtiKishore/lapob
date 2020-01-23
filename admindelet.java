package paraballo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
import org.hibernate.query.Query;

/**
 * Servlet implementation class adminadd
 */
@MultipartConfig
public class admindelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
   public void processrequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
   { 
	    
	    Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(lap.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t=session.beginTransaction();

		  int id=Integer.parseInt(request.getParameter("id"));
		 /* String hql = "UPDATE laptoptab set available = :ans"  + 
		             "WHERE name = :name  and brand=:brand";
			Query query = session.createQuery(hql);

		query.setParameter("ans", "y");
		query.setParameter("name", n);
		query.setParameter("brand",brand );

		int result = query.executeUpdate();
		 */
		  lap l=(lap)session.get(lap.class, id);
		  l.setAvailable("n");
		  
		session.update(l);			 
		t.commit();    
		session.close();
		factory.close(); 
		RequestDispatcher rd=request.getRequestDispatcher("adminaction.jsp");
		rd.forward(request, response);
  
   }
  
   public admindelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	  processrequest(request,  response);
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
