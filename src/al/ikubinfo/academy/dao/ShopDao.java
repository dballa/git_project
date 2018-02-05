package al.ikubinfo.academy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import al.ikubinfo.academy.entity.SectorEntity;
import al.ikubinfo.academy.entity.ShopEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class ShopDao {
	public List<ShopEntity> allShops() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			List<ShopEntity> shops = session
					.createQuery("from ShopEntity where validity=1 order by shopId desc", ShopEntity.class).list();

			return shops;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			session.close();
		}

	}

	public List<ShopEntity> findShops(int shopId) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			List<ShopEntity> shops = session
					.createQuery("from ShopEntity where validity=1 and shopId=?1", ShopEntity.class)
					.setParameter(1, shopId).getResultList();

			return shops;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			session.close();
		}

	}

	public void addShop(ShopEntity shop) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			shop.setValidity((byte) 1);

			session.save(shop);
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		finally {
			session.close();
		}

	}

	public void removeShop(ShopEntity shop) {
		System.out.println(shop);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(shop);

		session.getTransaction().commit();

	}

	public ShopEntity getShopById(int toEditId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		return session.find(ShopEntity.class, toEditId);

	}

	public void editShop(ShopEntity shop) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			session.beginTransaction();

			session.merge(shop);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		session.close();
	}

	public List<ShopEntity> searchShop(ShopSearchFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		String queryString = "from ShopEntity shp where shp.validity=1 ";

		if (filter.getName() != null && !filter.getName().equals("")) {

			queryString = queryString.concat(" and lower(shp.shopName) like lower(?1) ");
		}

		if (filter.getDescription() != null && !filter.getDescription().equals("")) {

			queryString = queryString.concat(" and lower(shp.description) like lower (?2) ");

		}

		Query query = session.createQuery(queryString, ShopEntity.class);

		if (filter.getName() != null && !filter.getName().equals("")) {

			query.setParameter(1, "%" + filter.getName() + "%");
		}

		if (filter.getDescription() != null && !filter.getDescription().equals("")) {

			query.setParameter(2, "%" + filter.getDescription() + "%");

		}
		List<ShopEntity> toReturn = query.getResultList();

		session.close();

		return toReturn;
	}
}
