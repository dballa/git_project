package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-31T14:22:23.741+0100")
@StaticMetamodel(BrandEntity.class)
public class BrandEntity_ {
	public static volatile SingularAttribute<BrandEntity, Integer> brandId;
	public static volatile SingularAttribute<BrandEntity, String> brandName;
	public static volatile SingularAttribute<BrandEntity, Byte> validity;
	public static volatile ListAttribute<BrandEntity, BrandSectorEntity> brandSectors;
	public static volatile ListAttribute<BrandEntity, DepartmentBrandEntity> departmentBrands;
	public static volatile ListAttribute<BrandEntity, ProductEntity> products;
}
