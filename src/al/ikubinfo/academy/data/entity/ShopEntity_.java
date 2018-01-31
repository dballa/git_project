package al.ikubinfo.academy.data.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-26T13:37:09.380+0100")
@StaticMetamodel(ShopEntity.class)
public class ShopEntity_ {
	public static volatile SingularAttribute<ShopEntity, Integer> shopId;
	public static volatile SingularAttribute<ShopEntity, String> shopName;
	public static volatile SingularAttribute<ShopEntity, Byte> validity;
	public static volatile SingularAttribute<ShopEntity, StateEntity> state;
	public static volatile SingularAttribute<ShopEntity, SectorEntity> sector;
	public static volatile ListAttribute<ShopEntity, ShopProductEntity> shopProducts;
}
