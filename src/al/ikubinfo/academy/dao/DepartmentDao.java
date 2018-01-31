package al.ikubinfo.academy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import al.ikubinfo.academy.data.entity.DepartmentEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class DepartmentDao {

	public List<DepartmentEntity> allDepartment() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			List<DepartmentEntity> departments = session
					.createQuery("from DepartmentEntity where validity=1", DepartmentEntity.class).list();

			return departments;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			session.close();
		}

	}

	public void addDepartment(DepartmentEntity department) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			department.setValidity((byte) 1);
			session.save(department);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		
		
		session.close(); 
	}

	public void removeDepartment(DepartmentEntity department) {
		System.out.println(department);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(department);
		session.getTransaction().commit();
	}

}
