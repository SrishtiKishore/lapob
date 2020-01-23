package paraballo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class user_save{

	public static void register(user_table u)throws Exception {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(user_table.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t=session.beginTransaction();
		session.save(u);
		t.commit();
		session.close();
		factory.close();
	}
	

}
