package paraballo;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class add_cart
 */
public class add_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_cart() {
        super();
    }

	public void add(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
		
		HttpSession sess=req.getSession();
		
		if((String)sess.getAttribute("uid")==null)
		{ RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		  rd.forward(req, res);
			
		}
		else {
		
			String email=(String)sess.getAttribute("uid");
	         int id=Integer.parseInt(req.getParameter("item_id"));
	         int type=Integer.parseInt(req.getParameter("type"));
	         	
			
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(cart_tab.class);
        SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
         
         /**Query query=session.createQuery("from cart_tab where email=:e and id=:itemid");    
		  query.setParameter("e",email); 
		  query.setParameter("itemid",id);  
         List r=query.list();
    	 
         RequestDispatcher rd= req.getRequestDispatcher("detail.jsp");

         if(r.size()<=0) {
		     PrintWriter out = res.getWriter();  
		     res.setContentType("text/html");  
		     out.println("<script type=\"text/javascript\">");  
		     out.println("alert('Product already in cart');");  
		     out.println("</script>");
		     rd.include(req, res);

         }
         else {**/
		//String o="n";
         cart_tab item=new cart_tab(email,id,type);
         Transaction t=session.beginTransaction();

         session.save(item);
         t.commit();
         session.close();
         factory.close();
         
         if(type==11)
          req.getRequestDispatcher("detail_lap.jsp?item="+id).forward(req,res);
		 if(type==12)
	          req.getRequestDispatcher("detail.jsp?item="+id).forward(req,res);
 
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
