package paraballo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class cart_disp
 */
public class cart_disp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart_disp() {
        super();
        // TODO Auto-generated constructor stub
    } 

	protected void disp(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
		
		 int type=Integer.parseInt(req.getParameter("type"));
		 int id=Integer.parseInt(req.getParameter("id"));
		 if(type==11) {
			    Configuration cfg=new Configuration();
				cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(lap.class);
				SessionFactory fact=cfg.buildSessionFactory();
				Session sess=fact.openSession();
				Query q=sess.createQuery("from lap where id=:id1 ");
				q.setParameter("id1", id);
				List r=q.list();
				lap obj=(lap)r.get(0);
				req.setAttribute("obj",obj);
				sess.close();
				fact.close();
				
		 }
		 
		 if(type==12) {
			    Configuration cfg=new Configuration();
				cfg.addAnnotatedClass(imglaptop.class).addAnnotatedClass(mob.class);
				SessionFactory fact=cfg.buildSessionFactory();
				Session sess=fact.openSession();
				Query q=sess.createQuery("from mob where id=:id1 ");
				q.setParameter("id1", id);
				List r=q.list();
				mob obj=(mob)r.get(0);
				req.setAttribute("obj",obj);
				sess.close();
				fact.close();
				
		 }
		 				
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
