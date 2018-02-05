package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-31T14:22:23.913+0100")
@StaticMetamodel(StateProductEntity.class)
public class StateProductEntity_ {
	public static volatile SingularAttribute<StateProductEntity, StateProductEntityPK> id;
	public static volatile SingularAttribute<StateProductEntity, Integer> unitsAvailable;
	public static volatile SingularAttribute<StateProductEntity, Byte> validity;
	public static volatile SingularAttribute<StateProductEntity, ProductEntity> product;
	public static volatile SingularAttribute<StateProductEntity, StateEntity> state;
}
