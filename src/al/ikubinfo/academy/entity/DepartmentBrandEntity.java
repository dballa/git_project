package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the department_brand database table.
 * 
 */
@Entity
@Table(name="department_brand")
@NamedQuery(name="DepartmentBrandEntity.findAll", query="SELECT d FROM DepartmentBrandEntity d")
public class DepartmentBrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DepartmentBrandEntityPK id;

	private byte validity;

	//bi-directional many-to-one association to DepartmentEntity
	@ManyToOne
	@JoinColumn(name="DepartmentId")
	private DepartmentEntity department;

	//bi-directional many-to-one association to BrandEntity
	@ManyToOne
	@JoinColumn(name="BrandId")
	private BrandEntity brand;

	public DepartmentBrandEntity() {
	}

	public DepartmentBrandEntityPK getId() {
		return this.id;
	}

	public void setId(DepartmentBrandEntityPK id) {
		this.id = id;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public DepartmentEntity getDepartment() {
		return this.department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public BrandEntity getBrand() {
		return this.brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

}