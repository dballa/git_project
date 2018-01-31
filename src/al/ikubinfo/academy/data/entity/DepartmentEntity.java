package al.ikubinfo.academy.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@Table(name="department")
@NamedQuery(name="DepartmentEntity.findAll", query="SELECT d FROM DepartmentEntity d")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int departmentId;

	private String departmentName;

	private byte validity;

	
	

	//bi-directional many-to-one association to DepartmentBrandEntity
	@OneToMany(mappedBy="department")
	private List<DepartmentBrandEntity> departmentBrands;

	//bi-directional many-to-one association to SectorEntity
	@OneToMany(mappedBy="department")
	private List<SectorEntity> sectors;

	public DepartmentEntity() {
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	

	@Override
	public String toString() {
		return "DepartmentEntity [departmentId=" + departmentId + ", departmentName=" + departmentName + ", validity="
				+ validity + "]";
	}

	public List<DepartmentBrandEntity> getDepartmentBrands() {
		return this.departmentBrands;
	}

	public void setDepartmentBrands(List<DepartmentBrandEntity> departmentBrands) {
		this.departmentBrands = departmentBrands;
	}

	public DepartmentBrandEntity addDepartmentBrand(DepartmentBrandEntity departmentBrand) {
		getDepartmentBrands().add(departmentBrand);
		departmentBrand.setDepartment(this);

		return departmentBrand;
	}

	public DepartmentBrandEntity removeDepartmentBrand(DepartmentBrandEntity departmentBrand) {
		getDepartmentBrands().remove(departmentBrand);
		departmentBrand.setDepartment(null);

		return departmentBrand;
	}

	public List<SectorEntity> getSectors() {
		return this.sectors;
	}

	public void setSectors(List<SectorEntity> sectors) {
		this.sectors = sectors;
	}

	public SectorEntity addSector(SectorEntity sector) {
		getSectors().add(sector);
		sector.setDepartment(this);

		return sector;
	}

	public SectorEntity removeSector(SectorEntity sector) {
		getSectors().remove(sector);
		sector.setDepartment(null);

		return sector;
	}

}