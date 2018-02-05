package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@Table(name="brand")
@NamedQuery(name="BrandEntity.findAll", query="SELECT b FROM BrandEntity b")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int brandId;

	private String brandName;

	private byte validity;

	//bi-directional many-to-one association to BrandSectorEntity
	@OneToMany(mappedBy="brand")
	private List<BrandSectorEntity> brandSectors;

	//bi-directional many-to-one association to DepartmentBrandEntity
	@OneToMany(mappedBy="brand")
	private List<DepartmentBrandEntity> departmentBrands;

	//bi-directional many-to-one association to ProductEntity
	@OneToMany(mappedBy="brand")
	private List<ProductEntity> products;

	public BrandEntity() {
	}

	public int getBrandId() {
		return this.brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
		brandSector.setBrand(this);

		return brandSector;
	}

	public BrandSectorEntity removeBrandSector(BrandSectorEntity brandSector) {
		getBrandSectors().remove(brandSector);
		brandSector.setBrand(null);

		return brandSector;
	}

	public List<DepartmentBrandEntity> getDepartmentBrands() {
		return this.departmentBrands;
	}

	public void setDepartmentBrands(List<DepartmentBrandEntity> departmentBrands) {
		this.departmentBrands = departmentBrands;
	}

	public DepartmentBrandEntity addDepartmentBrand(DepartmentBrandEntity departmentBrand) {
		getDepartmentBrands().add(departmentBrand);
		departmentBrand.setBrand(this);

		return departmentBrand;
	}

	public DepartmentBrandEntity removeDepartmentBrand(DepartmentBrandEntity departmentBrand) {
		getDepartmentBrands().remove(departmentBrand);
		departmentBrand.setBrand(null);

		return departmentBrand;
	}

	public List<ProductEntity> getProducts() {
		return this.products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public ProductEntity addProduct(ProductEntity product) {
		getProducts().add(product);
		product.setBrand(this);

		return product;
	}

	public ProductEntity removeProduct(ProductEntity product) {
		getProducts().remove(product);
		product.setBrand(null);

		return product;
	}

}