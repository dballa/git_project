package al.ikubinfo.academy.data.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-29T22:37:27.198+0100")
@StaticMetamodel(DepartmentEntity.class)
public class DepartmentEntity_ {
	public static volatile SingularAttribute<DepartmentEntity, Integer> departmentId;
	public static volatile SingularAttribute<DepartmentEntity, String> departmentName;
	public static volatile SingularAttribute<DepartmentEntity, Byte> validity;
	public static volatile ListAttribute<DepartmentEntity, DepartmentBrandEntity> departmentBrands;
	public static volatile ListAttribute<DepartmentEntity, SectorEntity> sectors;
}
