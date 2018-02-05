package al.ikubinfo.academy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import al.ikubinfo.academy.entity.DepartmentEntity;
import al.ikubinfo.academy.entity.SectorEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class SectorDao {

	public List<SectorEntity> allSectors() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			List<SectorEntity> sectors = session.createQuery("from SectorEntity where validity=1 order by sectorId desc", SectorEntity.class)
					.list();

			return sectors;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			session.close();
		}

	}

	
	public List<SectorEntity> findSectors(int departmentId) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			List<SectorEntity> sectors = session
					.createQuery("from SectorEntity where validity=1 and departmentId=?1", SectorEntity.class)
					.setParameter(1, departmentId).getResultList();

			return sectors;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			session.close();
		}

	}

	
	public void addSector(SectorEntity sector) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			
			sector.setValidity((byte) 1);
			System.out.println(sector.getDepartment().getDepartmentName());
			
			session.save(sector);
			session.getTransaction().commit();

			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

		finally {
			session.close();
		}

	}
	
	public void removeSector(SectorEntity sector) {
		System.out.println(sector);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(sector);
	
		session.getTransaction().commit();
		
		
	}
	
	
	public SectorEntity getSectorById(int toEditId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		return 	session.find(SectorEntity.class, toEditId);
		
	
	}
	public void editSector(SectorEntity sector) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			session.beginTransaction();
			
			session.merge(sector);
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

public List<SectorEntity> searchSector(SectorSearchFilter filter) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		

		String queryString = "from SectorEntity sec where sec.validity=1 ";

		if (filter.getName() != null && !filter.getName().equals("")) {

			queryString = queryString.concat(" and lower(sec.sectorName) like lower(?1) ");
		}

		if (filter.getDescription() != null && !filter.getDescription().equals("")) {

			queryString = queryString.concat(" and lower(sec.description) like lower (?2) ");
		
		}

		
		Query query= session.createQuery(queryString,SectorEntity.class);
		
		
		if (filter.getName() != null && !filter.getName().equals("")) {

			query.setParameter(1, "%"+filter.getName()+"%");
		}
		
		if (filter.getDescription() != null && !filter.getDescription().equals("")) {

		query.setParameter(2,"%"+ filter.getDescription()+"%");
		
		}
		
		
		return query.getResultList();
	}
	
	
}
