package paraballo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class detail_mob
 */
public class detail_mob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detail_mob() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void disp(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		Configuration cfg= new Configuration();
		cfg.addAnnotatedClass(imglaptop .class).addAnnotatedClass(mob.class);
	  	SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
        Transaction t=session.beginTransaction(); 

        Query qry=session.createQuery("from mob where id=:id1");    
	    qry.setParameter("id1",Integer.parseInt(req.getParameter("prod_id")));
	    List result=qry.list();
	    if(result!=null)
	    { mob obj=(mob)result.get(0);
	     req.setAttribute("mobitem", obj);
	    }
	   //res.get(index)
	    t.commit();
	    session.close();
	    factory.close();
	    
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    disp(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
