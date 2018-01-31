package al.ikubinfo.academy.data.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the shop_product database table.
 * 
 */
@Entity
@Table(name="shop_product")
@NamedQuery(name="ShopProductEntity.findAll", query="SELECT s FROM ShopProductEntity s")
public class ShopProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShopProductEntityPK id;

	private byte validity;

	//bi-directional many-to-one association to ShopEntity
	@ManyToOne
	@JoinColumn(name="ShopId")
	private ShopEntity shop;

	//bi-directional many-to-one association to ProductEntity
	@ManyToOne
	@JoinColumn(name="ProductId")
	private ProductEntity product;

	public ShopProductEntity() {
	}

	public ShopProductEntityPK getId() {
		return this.id;
	}

	public void setId(ShopProductEntityPK id) {
		this.id = id;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public ShopEntity getShop() {
		return this.shop;
	}

	public void setShop(ShopEntity shop) {
		this.shop = shop;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}