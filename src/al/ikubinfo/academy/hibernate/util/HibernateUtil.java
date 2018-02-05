package al.ikubinfo.academy.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import al.ikubinfo.academy.entity.BrandEntity;
import al.ikubinfo.academy.entity.BrandSectorEntity;
import al.ikubinfo.academy.entity.BrandSectorEntityPK;
import al.ikubinfo.academy.entity.CompanyEntity;
import al.ikubinfo.academy.entity.ContactEntity;
import al.ikubinfo.academy.entity.DepartmentBrandEntity;
import al.ikubinfo.academy.entity.DepartmentBrandEntityPK;
import al.ikubinfo.academy.entity.DepartmentEntity;
import al.ikubinfo.academy.entity.ProductEntity;
import al.ikubinfo.academy.entity.SectorEntity;
import al.ikubinfo.academy.entity.SectorProductEntity;
import al.ikubinfo.academy.entity.SectorProductEntityPK;
import al.ikubinfo.academy.entity.SectorStateEntity;
import al.ikubinfo.academy.entity.SectorStateEntityPK;
import al.ikubinfo.academy.entity.ShopEntity;
import al.ikubinfo.academy.entity.ShopProductEntity;
import al.ikubinfo.academy.entity.ShopProductEntityPK;
import al.ikubinfo.academy.entity.StateEntity;
import al.ikubinfo.academy.entity.StateProductEntity;
import al.ikubinfo.academy.entity.StateProductEntityPK;
import al.ikubinfo.academy.entity.UserEntity;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			// loads configuration and mappings
			Configuration configuration = new Configuration().configure().addAnnotatedClass(UserEntity.class)
					.addAnnotatedClass(BrandEntity.class).addAnnotatedClass(BrandSectorEntity.class)
					.addAnnotatedClass(BrandSectorEntityPK.class).addAnnotatedClass(CompanyEntity.class)
					.addAnnotatedClass(ContactEntity.class).addAnnotatedClass(DepartmentBrandEntity.class)
					.addAnnotatedClass(DepartmentBrandEntityPK.class).addAnnotatedClass(DepartmentEntity.class)
					.addAnnotatedClass(ProductEntity.class).addAnnotatedClass(SectorEntity.class)
					.addAnnotatedClass(SectorProductEntity.class).addAnnotatedClass(SectorProductEntityPK.class)
					.addAnnotatedClass(SectorStateEntity.class).addAnnotatedClass(SectorStateEntityPK.class)
					.addAnnotatedClass(SectorStateEntity.class).addAnnotatedClass(SectorStateEntityPK.class)
					.addAnnotatedClass(ShopEntity.class).addAnnotatedClass(ShopProductEntity.class)
					.addAnnotatedClass(ShopProductEntityPK.class).addAnnotatedClass(ShopEntity.class)
					.addAnnotatedClass(ShopProductEntity.class).addAnnotatedClass(ShopProductEntityPK.class)
					.addAnnotatedClass(StateEntity.class).addAnnotatedClass(StateProductEntity.class)
					.addAnnotatedClass(StateProductEntityPK.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}
}
