package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sector database table.
 * 
 */
@Entity
@Table(name="sector")
@NamedQuery(name="SectorEntity.findAll", query="SELECT s FROM SectorEntity s")
public class SectorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int sectorId;

	private String sectorName;
	private String description;

	private byte validity;

	//bi-directional many-to-one association to BrandSectorEntity
	@OneToMany(mappedBy="sector")
	private List<BrandSectorEntity> brandSectors;

	//bi-directional many-to-one association to DepartmentEntity
	@ManyToOne
	@JoinColumn(name="DepartmentId")
	private DepartmentEntity department;

	//bi-directional many-to-one association to SectorProductEntity
	@OneToMany(mappedBy="sector")
	private List<SectorProductEntity> sectorProducts;

	//bi-directional many-to-one association to SectorStateEntity
	@OneToMany(mappedBy="sector")
	private List<SectorStateEntity> sectorStates;

	//bi-directional many-to-one association to ShopEntity
	@OneToMany(mappedBy="sector")
	private List<ShopEntity> shops;

	public SectorEntity() {
	}

	public int getSectorId() {
		return this.sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

	public String getSectorName() {
		return this.sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public List<BrandSectorEntity> getBrandSectors() {
		return this.brandSectors;
	}

	public void setBrandSectors(List<BrandSectorEntity> brandSectors) {
		this.brandSectors = brandSectors;
	}

	public BrandSectorEntity addBrandSector(BrandSectorEntity brandSector) {
		getBrandSectors().add(brandSector);
		brandSector.setSector(this);

		return brandSector;
	}

	public BrandSectorEntity removeBrandSector(BrandSectorEntity brandSector) {
		getBrandSectors().remove(brandSector);
		brandSector.setSector(null);

		return brandSector;
	}

	public DepartmentEntity getDepartment() {
		return this.department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public List<SectorProductEntity> getSectorProducts() {
		return this.sectorProducts;
	}

	public void setSectorProducts(List<SectorProductEntity> sectorProducts) {
		this.sectorProducts = sectorProducts;
	}

	public SectorProductEntity addSectorProduct(SectorProductEntity sectorProduct) {
		getSectorProducts().add(sectorProduct);
		sectorProduct.setSector(this);

		return sectorProduct;
	}

	public SectorProductEntity removeSectorProduct(SectorProductEntity sectorProduct) {
		getSectorProducts().remove(sectorProduct);
		sectorProduct.setSector(null);

		return sectorProduct;
	}

	public List<SectorStateEntity> getSectorStates() {
		return this.sectorStates;
	}

	public void setSectorStates(List<SectorStateEntity> sectorStates) {
		this.sectorStates = sectorStates;
	}

	public SectorStateEntity addSectorState(SectorStateEntity sectorState) {
		getSectorStates().add(sectorState);
		sectorState.setSector(this);

		return sectorState;
	}

	public SectorStateEntity removeSectorState(SectorStateEntity sectorState) {
		getSectorStates().remove(sectorState);
		sectorState.setSector(null);

		return sectorState;
	}

	public List<ShopEntity> getShops() {
		return this.shops;
	}

	public void setShops(List<ShopEntity> shops) {
		this.shops = shops;
	}

	public ShopEntity addShop(ShopEntity shop) {
		getShops().add(shop);
		shop.setSector(this);

		return shop;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ShopEntity removeShop(ShopEntity shop) {
		getShops().remove(shop);
		shop.setSector(null);

		return shop;
	}

}