package al.ikubinfo.academy.data.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-26T13:37:08.086+0100")
@StaticMetamodel(BrandSectorEntity.class)
public class BrandSectorEntity_ {
	public static volatile SingularAttribute<BrandSectorEntity, BrandSectorEntityPK> id;
	public static volatile SingularAttribute<BrandSectorEntity, Byte> validity;
	public static volatile SingularAttribute<BrandSectorEntity, SectorEntity> sector;
	public static volatile SingularAttribute<BrandSectorEntity, BrandEntity> brand;
}
