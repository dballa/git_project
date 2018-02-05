package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the state_product database table.
 * 
 */
@Entity
@Table(name="state_product")
@NamedQuery(name="StateProductEntity.findAll", query="SELECT s FROM StateProductEntity s")
public class StateProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StateProductEntityPK id;

	private int unitsAvailable;

	private byte validity;

	//bi-directional many-to-one association to ProductEntity
	@ManyToOne
	@JoinColumn(name="ProductId")
	private ProductEntity product;

	//bi-directional many-to-one association to StateEntity
	@ManyToOne
	@JoinColumn(name="StateId")
	private StateEntity state;

	public StateProductEntity() {
	}

	public StateProductEntityPK getId() {
		return this.id;
	}

	public void setId(StateProductEntityPK id) {
		this.id = id;
	}

	public int getUnitsAvailable() {
		return this.unitsAvailable;
	}

	public void setUnitsAvailable(int unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public StateEntity getState() {
		return this.state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

}