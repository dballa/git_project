package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the department_brand database table.
 * 
 */
@Embeddable
public class DepartmentBrandEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int departmentId;

	@Column(insertable=false, updatable=false)
	private int brandId;

	public DepartmentBrandEntityPK() {
	}
	public int getDepartmentId() {
		return this.departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getBrandId() {
		return this.brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DepartmentBrandEntityPK)) {
			return false;
		}
		DepartmentBrandEntityPK castOther = (DepartmentBrandEntityPK)other;
		return 
			(this.departmentId == castOther.departmentId)
			&& (this.brandId == castOther.brandId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.departmentId;
		hash = hash * prime + this.brandId;
		
		return hash;
	}
}