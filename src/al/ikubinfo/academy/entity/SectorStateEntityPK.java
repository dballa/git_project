package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sector_state database table.
 * 
 */
@Embeddable
public class SectorStateEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int sectorId;

	@Column(insertable=false, updatable=false)
	private int stateId;

	public SectorStateEntityPK() {
	}
	public int getSectorId() {
		return this.sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
	public int getStateId() {
		return this.stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SectorStateEntityPK)) {
			return false;
		}
		SectorStateEntityPK castOther = (SectorStateEntityPK)other;
		return 
			(this.sectorId == castOther.sectorId)
			&& (this.stateId == castOther.stateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sectorId;
		hash = hash * prime + this.stateId;
		
		return hash;
	}
}