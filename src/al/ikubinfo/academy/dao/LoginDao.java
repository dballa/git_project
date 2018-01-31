package al.ikubinfo.academy.dao;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.query.Query;

import al.ikubinfo.academy.data.entity.UserEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class LoginDao {


	
	public  String validate(UserEntity user) {


		

			Session session =HibernateUtil.getSessionFactory().openSession();
			Query<UserEntity> query = session.createQuery("from UserEntity where email=?1 and password=?2 and validity=1",UserEntity.class);
		
			query.setParameter(1, user.getEmail());
			query.setParameter(2,user.getPassword());
			UserEntity userFound = (UserEntity)query.uniqueResult();
			
			
			
			if(userFound.getType().equals("admin")&&userFound.getValidity()==1) {
			
				
				session.close();
				return "Admin";
				
			}
			
			
			if (userFound.getType().equals("user")&&userFound.getValidity()==1) {
				session.close();
				return "User";
			}
			
			else {
				session.close();
				return "Login";	
			}
		

	}
}
