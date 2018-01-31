package al.ikubinfo.academy.data.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-26T13:37:09.429+0100")
@StaticMetamodel(StateEntity.class)
public class StateEntity_ {
	public static volatile SingularAttribute<StateEntity, Integer> stateId;
	public static volatile SingularAttribute<StateEntity, String> currencyType;
	public static volatile SingularAttribute<StateEntity, String> stateName;
	public static volatile SingularAttribute<StateEntity, Byte> validity;
	public static volatile ListAttribute<StateEntity, SectorStateEntity> sectorStates;
	public static volatile ListAttribute<StateEntity, ShopEntity> shops;
	public static volatile ListAttribute<StateEntity, StateProductEntity> stateProducts;
}
