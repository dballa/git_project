package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-31T14:22:23.804+0100")
@StaticMetamodel(CompanyEntity.class)
public class CompanyEntity_ {
	public static volatile SingularAttribute<CompanyEntity, Integer> companyId;
	public static volatile SingularAttribute<CompanyEntity, String> companyName_varchar;
	public static volatile SingularAttribute<CompanyEntity, String> nipt_varchar;
	public static volatile SingularAttribute<CompanyEntity, Byte> validity;
	public static volatile SingularAttribute<CompanyEntity, ContactEntity> contact;
}
