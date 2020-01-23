package paraballo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.HibernateQuery;

public class add_order extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public add_order() {
        super();
    }

	protected void add(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		
		int id=Integer.parseInt(req.getParameter("item_id"));
		int type=Integer.parseInt(req.getParameter("type"));
		HttpSession s=req.getSession();
		String uid=(String)s.getAttribute("uid");
		if(uid==null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
		else {
			Configuration cfg=new Configuration();
			cfg.addAnnotatedClass(cart_tab.class);
			cfg.addAnnotatedClass(order.class);
			SessionFactory fact=cfg.buildSessionFactory();
			Session sess=fact.openSession();
		
			order obj=new order(uid,id,type);
			Query q=sess.createQuery("from cart_tab where id=:pid and type=:t and  email=:e");    
             q.setParameter("pid", id);
             q.setParameter("t", type);
             q.setParameter("e", uid);
             List r=q.list();
            /** if(r.isEmpty()) {
            	 
             sess.save(object)
             }
             cart_tab item=(cart_tab)q.list().get(0);**/
			Transaction t=sess.beginTransaction();
			sess.save(obj);
		   //sess.remove(item); 	    
		    t.commit();
		    sess.close();
			fact.close();
			req.setAttribute("item",obj);
			RequestDispatcher rd=req.getRequestDispatcher("order_adrs.jsp");
	      	rd.include(req, res);
			 
		}
		
	}
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 add(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
