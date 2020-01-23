package paraballo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	user_table u=new user_table();
    	
    	u.setEmail(request.getParameter("emailid"));
    	u.setName(request.getParameter("name"));
    	u.setPassword(request.getParameter("pswd"));
    	u.setMobile(request.getParameter("mobno"));
    	
    	SendEmail se=new SendEmail();
    	if(se.sendmail(request.getParameter("emailid"))) {
    	Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(user_table.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t=session.beginTransaction();
		session.save(u);
		t.commit();
		session.close();
		factory.close();
		request.getRequestDispatcher("login.jsp").forward(request, response);
             
    	}
    	else {
    		request.getRequestDispatcher("signup.jsp").forward(request, response);
    	}
	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    process(request,response);
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
