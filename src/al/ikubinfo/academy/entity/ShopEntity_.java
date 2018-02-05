package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-04T23:37:30.038+0100")
@StaticMetamodel(ShopEntity.class)
public class ShopEntity_ {
	public static volatile SingularAttribute<ShopEntity, Integer> shopId;
	public static volatile SingularAttribute<ShopEntity, String> shopName;
	public static volatile SingularAttribute<ShopEntity, Byte> validity;
	public static volatile SingularAttribute<ShopEntity, StateEntity> state;
	public static volatile SingularAttribute<ShopEntity, SectorEntity> sector;
	public static volatile ListAttribute<ShopEntity, ShopProductEntity> shopProducts;
	public static volatile SingularAttribute<ShopEntity, String> description;
}
