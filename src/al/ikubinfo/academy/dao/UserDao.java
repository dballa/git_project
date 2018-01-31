package al.ikubinfo.academy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import al.ikubinfo.academy.data.entity.UserEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class UserDao {
	// TODO SHIF BEJ CTE BESH (hiq  posht mos ti besh cdo her)
	public void addUser(UserEntity user) {
		System.out.println("METODA NE DAO ");
	//	Configuration conf = new Configuration().configure().addAnnotatedClass(UserEntity.class);

		//ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

	//	SessionFactory sf = conf.buildSessionFactory(sr);

	//	Session session = sf.openSession();
	//	Transaction tx = session.beginTransaction();

	//	session.save(user);
	//	tx.commit();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		
		System.out.println(user);
		
		

	}
}
