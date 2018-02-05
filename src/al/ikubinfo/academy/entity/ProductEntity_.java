package al.ikubinfo.academy.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-31T14:22:23.835+0100")
@StaticMetamodel(ProductEntity.class)
public class ProductEntity_ {
	public static volatile SingularAttribute<ProductEntity, Integer> productId;
	public static volatile SingularAttribute<ProductEntity, String> description;
	public static volatile SingularAttribute<ProductEntity, Integer> price;
	public static volatile SingularAttribute<ProductEntity, String> productName;
	public static volatile SingularAttribute<ProductEntity, Integer> units;
	public static volatile SingularAttribute<ProductEntity, Byte> validity;
	public static volatile SingularAttribute<ProductEntity, BrandEntity> brand;
	public static volatile ListAttribute<ProductEntity, SectorProductEntity> sectorProducts;
	public static volatile ListAttribute<ProductEntity, ShopProductEntity> shopProducts;
	public static volatile ListAttribute<ProductEntity, StateProductEntity> stateProducts;
}
