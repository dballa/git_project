package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the state_product database table.
 * 
 */
@Embeddable
public class StateProductEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int stateId;

	@Column(insertable=false, updatable=false)
	private int productId;

	public StateProductEntityPK() {
	}
	public int getStateId() {
		return this.stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
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
		if (!(other instanceof StateProductEntityPK)) {
			return false;
		}
		StateProductEntityPK castOther = (StateProductEntityPK)other;
		return 
			(this.stateId == castOther.stateId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.stateId;
		hash = hash * prime + this.productId;
		
		return hash;
	}
}