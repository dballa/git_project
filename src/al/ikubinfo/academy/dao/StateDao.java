package al.ikubinfo.academy.dao;

import java.util.List;

import org.hibernate.Session;

import al.ikubinfo.academy.entity.SectorEntity;
import al.ikubinfo.academy.entity.StateEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

public class StateDao {

	public List<StateEntity> allStates(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			List<StateEntity> states= session.createQuery("from StateEntity where validity=1 order by stateId desc", StateEntity.class)
					.list();

			return states;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			session.close();
		}
		
	}
}
