package al.ikubinfo.academy.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import al.ikubinfo.academy.data.entity.BrandEntity;
import al.ikubinfo.academy.data.entity.BrandSectorEntity;
import al.ikubinfo.academy.data.entity.BrandSectorEntityPK;
import al.ikubinfo.academy.data.entity.CompanyEntity;
import al.ikubinfo.academy.data.entity.ContactEntity;
import al.ikubinfo.academy.data.entity.DepartmentBrandEntity;
import al.ikubinfo.academy.data.entity.DepartmentBrandEntityPK;
import al.ikubinfo.academy.data.entity.DepartmentEntity;
import al.ikubinfo.academy.data.entity.ProductEntity;
import al.ikubinfo.academy.data.entity.SectorEntity;
import al.ikubinfo.academy.data.entity.SectorProductEntity;
import al.ikubinfo.academy.data.entity.SectorProductEntityPK;
import al.ikubinfo.academy.data.entity.SectorStateEntity;
import al.ikubinfo.academy.data.entity.SectorStateEntityPK;
import al.ikubinfo.academy.data.entity.ShopEntity;
import al.ikubinfo.academy.data.entity.ShopProductEntity;
import al.ikubinfo.academy.data.entity.ShopProductEntityPK;
import al.ikubinfo.academy.data.entity.StateEntity;
import al.ikubinfo.academy.data.entity.StateProductEntity;
import al.ikubinfo.academy.data.entity.StateProductEntityPK;
import al.ikubinfo.academy.data.entity.UserEntity;

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
