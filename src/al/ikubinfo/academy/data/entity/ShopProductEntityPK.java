package al.ikubinfo.academy.data.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the shop_product database table.
 * 
 */
@Embeddable
public class ShopProductEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int shopId;

	@Column(insertable=false, updatable=false)
	private int productId;

	public ShopProductEntityPK() {
	}
	public int getShopId() {
		return this.shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
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
		if (!(other instanceof ShopProductEntityPK)) {
			return false;
		}
		ShopProductEntityPK castOther = (ShopProductEntityPK)other;
		return 
			(this.shopId == castOther.shopId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.shopId;
		hash = hash * prime + this.productId;
		
		return hash;
	}
}