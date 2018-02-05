package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-31T14:22:23.913+0100")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ {
	public static volatile SingularAttribute<UserEntity, Integer> userId;
	public static volatile SingularAttribute<UserEntity, String> email;
	public static volatile SingularAttribute<UserEntity, String> emri;
	public static volatile SingularAttribute<UserEntity, String> mbiemri;
	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, String> type;
	public static volatile SingularAttribute<UserEntity, Byte> validity;
}
