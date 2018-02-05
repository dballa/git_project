package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-31T14:22:23.850+0100")
@StaticMetamodel(SectorProductEntity.class)
public class SectorProductEntity_ {
	public static volatile SingularAttribute<SectorProductEntity, SectorProductEntityPK> id;
	public static volatile SingularAttribute<SectorProductEntity, Byte> validity;
	public static volatile SingularAttribute<SectorProductEntity, SectorEntity> sector;
	public static volatile SingularAttribute<SectorProductEntity, ProductEntity> product;
}
