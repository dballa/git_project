package al.ikubinfo.academy.data.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-26T13:37:08.170+0100")
@StaticMetamodel(DepartmentBrandEntity.class)
public class DepartmentBrandEntity_ {
	public static volatile SingularAttribute<DepartmentBrandEntity, DepartmentBrandEntityPK> id;
	public static volatile SingularAttribute<DepartmentBrandEntity, Byte> validity;
	public static volatile SingularAttribute<DepartmentBrandEntity, DepartmentEntity> department;
	public static volatile SingularAttribute<DepartmentBrandEntity, BrandEntity> brand;
}
