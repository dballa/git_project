package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-01T23:13:02.930+0100")
@StaticMetamodel(SectorEntity.class)
public class SectorEntity_ {
	public static volatile SingularAttribute<SectorEntity, Integer> sectorId;
	public static volatile SingularAttribute<SectorEntity, String> sectorName;
	public static volatile SingularAttribute<SectorEntity, String> description;
	public static volatile SingularAttribute<SectorEntity, Byte> validity;
	public static volatile ListAttribute<SectorEntity, BrandSectorEntity> brandSectors;
	public static volatile SingularAttribute<SectorEntity, DepartmentEntity> department;
	public static volatile ListAttribute<SectorEntity, SectorProductEntity> sectorProducts;
	public static volatile ListAttribute<SectorEntity, SectorStateEntity> sectorStates;
	public static volatile ListAttribute<SectorEntity, ShopEntity> shops;
}
