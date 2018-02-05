package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-31T14:22:23.882+0100")
@StaticMetamodel(ShopProductEntity.class)
public class ShopProductEntity_ {
	public static volatile SingularAttribute<ShopProductEntity, ShopProductEntityPK> id;
	public static volatile SingularAttribute<ShopProductEntity, Byte> validity;
	public static volatile SingularAttribute<ShopProductEntity, ShopEntity> shop;
	public static volatile SingularAttribute<ShopProductEntity, ProductEntity> product;
}
