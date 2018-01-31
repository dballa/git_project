package al.ikubinfo.academy.data.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-29T22:38:09.492+0100")
@StaticMetamodel(CompanyEntity.class)
public class CompanyEntity_ {
	public static volatile SingularAttribute<CompanyEntity, Integer> companyId;
	public static volatile SingularAttribute<CompanyEntity, String> companyName_varchar;
	public static volatile SingularAttribute<CompanyEntity, String> nipt_varchar;
	public static volatile SingularAttribute<CompanyEntity, Byte> validity;
	public static volatile SingularAttribute<CompanyEntity, ContactEntity> contact;
}
