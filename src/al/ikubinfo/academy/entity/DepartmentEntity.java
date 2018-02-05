package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@Table(name = "department")
@NamedQuery(name = "DepartmentEntity.findAll", query = "SELECT d FROM DepartmentEntity d")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int departmentId;

	private String departmentName;

	private byte validity;
	private String description;

	// bi-directional many-to-one association to DepartmentBrandEntity
	@OneToMany(mappedBy = "department")
	private List<DepartmentBrandEntity> departmentBrands;

	// bi-directional many-to-one association to SectorEntity
	@OneToMany(mappedBy = "department")
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
				+ validity + ", description=" + description + "]";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentBrands == null) ? 0 : departmentBrands.hashCode());
		result = prime * result + departmentId;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((sectors == null) ? 0 : sectors.hashCode());
		result = prime * result + validity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentEntity other = (DepartmentEntity) obj;
		if (departmentBrands == null) {
			if (other.departmentBrands != null)
				return false;
		} else if (!departmentBrands.equals(other.departmentBrands))
			return false;
		if (departmentId != other.departmentId)
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (sectors == null) {
			if (other.sectors != null)
				return false;
		} else if (!sectors.equals(other.sectors))
			return false;
		if (validity != other.validity)
			return false;
		return true;
	}
}