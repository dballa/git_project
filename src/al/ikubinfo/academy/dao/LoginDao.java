package al.ikubinfo.academy.dao;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.query.Query;

import al.ikubinfo.academy.entity.UserEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class LoginDao {


	
	public  UserEntity validate(UserEntity user) {


		

			Session session =HibernateUtil.getSessionFactory().openSession();
			Query<UserEntity> query = session.createQuery("from UserEntity where email=?1 and password=?2 and validity=1",UserEntity.class);
		
			query.setParameter(1, user.getEmail());
			query.setParameter(2,user.getPassword());
			UserEntity userFound = (UserEntity)query.uniqueResult();
			
			return userFound;
	
		

	}
}
