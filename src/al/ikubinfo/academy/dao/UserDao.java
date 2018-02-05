package al.ikubinfo.academy.dao;

import org.hibernate.Session;

import al.ikubinfo.academy.entity.UserEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class UserDao {

	public void addUser(UserEntity user) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			user.setValidity((byte) 1);
			user.setType("user");
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		session.close();
	}

	public UserEntity findUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		UserEntity toReturn = session.find(UserEntity.class, id);
		session.close();
		return toReturn;
	}

}
