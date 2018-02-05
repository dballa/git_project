package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sector_product database table.
 * 
 */
@Embeddable
public class SectorProductEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int sectorId;

	@Column(insertable=false, updatable=false)
	private int productId;

	public SectorProductEntityPK() {
	}
	public int getSectorId() {
		return this.sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SectorProductEntityPK)) {
			return false;
		}
		SectorProductEntityPK castOther = (SectorProductEntityPK)other;
		return 
			(this.sectorId == castOther.sectorId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sectorId;
		hash = hash * prime + this.productId;
		
		return hash;
	}
}