package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-31T14:22:23.804+0100")
@StaticMetamodel(ContactEntity.class)
public class ContactEntity_ {
	public static volatile SingularAttribute<ContactEntity, Integer> contactId;
	public static volatile SingularAttribute<ContactEntity, String> address;
	public static volatile SingularAttribute<ContactEntity, Integer> contactNumber;
	public static volatile SingularAttribute<ContactEntity, Byte> validity;
	public static volatile ListAttribute<ContactEntity, CompanyEntity> companies;
}
