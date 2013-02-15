package export2db;

import java.sql.Date;

import model.BaseHibernateDAO;
import model.HibernateSessionFactory;
import model.SecurityDetectItem;
import model.SecurityDetectService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import export2db.test;

import dao.SecurityDetectItemDAO;
import daoimpl.SecurityDetectItemDAOImpl;

public class Hu extends BaseHibernateDAO{

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	private static final Log log = LogFactory.getLog(Hu.class);
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		SecurityDetectItem user = new SecurityDetectItem();
		
		user.setId(0);
		user.setItemName("haha");
		user.setSecurityDetectService(null);
		
		session.save(user);
		
		session.getTransaction().commit();
		if(session.isOpen()){
			session.close();

	}*/
		
		//test t = new test();
		//t.sucess();
		
		TestItem t = new TestItem();
		
		t.success();
		
		/*SecurityDetectService s1 = new SecurityDetectService();
		SecurityDetectService s2 = new SecurityDetectService();
		SecurityDetectItem i1 = new SecurityDetectItem();
		SecurityDetectItem i2 = new SecurityDetectItem();
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();*/
		/*s1.setId(1);
		i1.setId(8);
		i1.setItemName("hhhh");
		i2.setItemName("hhhh2");
		s1.getSecurityDetectItems().add(i2);
		s1.getSecurityDetectItems().add(i1);
		
		session.save(s1);
		session.save(i1);
		session.save(i2);
		Query query =session.createQuery("from SecurityDetectItem where id=15");
		SecurityDetectItem stu=(SecurityDetectItem)query.uniqueResult();
		session.delete(stu);*/

		/*session.getTransaction().commit();
		if(session.isOpen()){
			session.close();

	}*/
	}}
