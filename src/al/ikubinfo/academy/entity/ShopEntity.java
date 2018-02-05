package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the shop database table.
 * 
 */
@Entity
@Table(name="shop")
@NamedQuery(name="ShopEntity.findAll", query="SELECT s FROM ShopEntity s")
public class ShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int shopId;

	private String shopName;
	
	private String description;

	private byte validity;

	//bi-directional many-to-one association to StateEntity
	@ManyToOne
	@JoinColumn(name="StateId")
	private StateEntity state;

	//bi-directional many-to-one association to SectorEntity
	@ManyToOne
	@JoinColumn(name="SectorId")
	private SectorEntity sector;

	//bi-directional many-to-one association to ShopProductEntity
	@OneToMany(mappedBy="shop")
	private List<ShopProductEntity> shopProducts;

	public ShopEntity() {
	}

	public int getShopId() {
		return this.shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public StateEntity getState() {
		return this.state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	public SectorEntity getSector() {
		return this.sector;
	}

	public void setSector(SectorEntity sector) {
		this.sector = sector;
	}

	public List<ShopProductEntity> getShopProducts() {
		return this.shopProducts;
	}

	public void setShopProducts(List<ShopProductEntity> shopProducts) {
		this.shopProducts = shopProducts;
	}

	public ShopProductEntity addShopProduct(ShopProductEntity shopProduct) {
		getShopProducts().add(shopProduct);
		shopProduct.setShop(this);

		return shopProduct;
	}

	public ShopProductEntity removeShopProduct(ShopProductEntity shopProduct) {
		getShopProducts().remove(shopProduct);
		shopProduct.setShop(null);

		return shopProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}