package al.ikubinfo.academy.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="ProductEntity.findAll", query="SELECT p FROM ProductEntity p")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productId;

	private String description;

	private int price;

	private String productName;

	private int units;

	private byte validity;

	//bi-directional many-to-one association to BrandEntity
	@ManyToOne
	@JoinColumn(name="BrandId")
	private BrandEntity brand;

	//bi-directional many-to-one association to SectorProductEntity
	@OneToMany(mappedBy="product")
	private List<SectorProductEntity> sectorProducts;

	//bi-directional many-to-one association to ShopProductEntity
	@OneToMany(mappedBy="product")
	private List<ShopProductEntity> shopProducts;

	//bi-directional many-to-one association to StateProductEntity
	@OneToMany(mappedBy="product")
	private List<StateProductEntity> stateProducts;

	public ProductEntity() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUnits() {
		return this.units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public BrandEntity getBrand() {
		return this.brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public List<SectorProductEntity> getSectorProducts() {
		return this.sectorProducts;
	}

	public void setSectorProducts(List<SectorProductEntity> sectorProducts) {
		this.sectorProducts = sectorProducts;
	}

	public SectorProductEntity addSectorProduct(SectorProductEntity sectorProduct) {
		getSectorProducts().add(sectorProduct);
		sectorProduct.setProduct(this);

		return sectorProduct;
	}

	public SectorProductEntity removeSectorProduct(SectorProductEntity sectorProduct) {
		getSectorProducts().remove(sectorProduct);
		sectorProduct.setProduct(null);

		return sectorProduct;
	}

	public List<ShopProductEntity> getShopProducts() {
		return this.shopProducts;
	}

	public void setShopProducts(List<ShopProductEntity> shopProducts) {
		this.shopProducts = shopProducts;
	}

	public ShopProductEntity addShopProduct(ShopProductEntity shopProduct) {
		getShopProducts().add(shopProduct);
		shopProduct.setProduct(this);

		return shopProduct;
	}

	public ShopProductEntity removeShopProduct(ShopProductEntity shopProduct) {
		getShopProducts().remove(shopProduct);
		shopProduct.setProduct(null);

		return shopProduct;
	}

	public List<StateProductEntity> getStateProducts() {
		return this.stateProducts;
	}

	public void setStateProducts(List<StateProductEntity> stateProducts) {
		this.stateProducts = stateProducts;
	}

	public StateProductEntity addStateProduct(StateProductEntity stateProduct) {
		getStateProducts().add(stateProduct);
		stateProduct.setProduct(this);

		return stateProduct;
	}

	public StateProductEntity removeStateProduct(StateProductEntity stateProduct) {
		getStateProducts().remove(stateProduct);
		stateProduct.setProduct(null);

		return stateProduct;
	}

}