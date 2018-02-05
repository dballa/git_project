package al.ikubinfo.academy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import al.ikubinfo.academy.entity.DepartmentEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class DepartmentDao {

	public List<DepartmentEntity> allDepartment() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			List<DepartmentEntity> departments = session.createQuery(
					"from DepartmentEntity where validity=1 order by departmentId desc", DepartmentEntity.class).list();

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
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
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

	public List<DepartmentEntity> searchDepartments(DepartmentSearchFilter filter) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		

		String queryString = "from DepartmentEntity dept where dept.validity=1 ";

		if (filter.getName() != null && !filter.getName().equals("")) {

			queryString = queryString.concat(" and lower(dept.departmentName) like lower(?1) ");
		}

		if (filter.getDescription() != null && !filter.getDescription().equals("")) {

			queryString = queryString.concat(" and lower(dept.description) like lower (?2) ");
		
		}

		
		Query query= session.createQuery(queryString,DepartmentEntity.class);
		
		
		if (filter.getName() != null && !filter.getName().equals("")) {

			query.setParameter(1, "%"+filter.getName()+"%");
		}
		
		if (filter.getDescription() != null && !filter.getDescription().equals("")) {

		query.setParameter(2,"%"+ filter.getDescription()+"%");
		
		}
		
		List<DepartmentEntity> toReturn=query.getResultList();
		
		session.close();
		
		return toReturn;
	}

	public DepartmentEntity getDepartmentById(int toEditId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		return session.find(DepartmentEntity.class, toEditId);

	}

	public void editDepartment(DepartmentEntity department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			session.beginTransaction();

			session.merge(department);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		session.close();
	}
}
