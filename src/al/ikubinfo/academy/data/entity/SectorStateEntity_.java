package al.ikubinfo.academy.data.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-26T13:37:09.357+0100")
@StaticMetamodel(SectorStateEntity.class)
public class SectorStateEntity_ {
	public static volatile SingularAttribute<SectorStateEntity, SectorStateEntityPK> id;
	public static volatile SingularAttribute<SectorStateEntity, Byte> validity;
	public static volatile SingularAttribute<SectorStateEntity, SectorEntity> sector;
	public static volatile SingularAttribute<SectorStateEntity, StateEntity> state;
}
