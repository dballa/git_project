package al.ikubinfo.academy.data.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the brand_sector database table.
 * 
 */
@Embeddable
public class BrandSectorEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int brandId;

	@Column(insertable=false, updatable=false)
	private int sectorId;

	public BrandSectorEntityPK() {
	}
	public int getBrandId() {
		return this.brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getSectorId() {
		return this.sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BrandSectorEntityPK)) {
			return false;
		}
		BrandSectorEntityPK castOther = (BrandSectorEntityPK)other;
		return 
			(this.brandId == castOther.brandId)
			&& (this.sectorId == castOther.sectorId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.brandId;
		hash = hash * prime + this.sectorId;
		
		return hash;
	}
}