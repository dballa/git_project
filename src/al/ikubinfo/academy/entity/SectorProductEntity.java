package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sector_product database table.
 * 
 */
@Entity
@Table(name="sector_product")
@NamedQuery(name="SectorProductEntity.findAll", query="SELECT s FROM SectorProductEntity s")
public class SectorProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SectorProductEntityPK id;

	private byte validity;

	//bi-directional many-to-one association to SectorEntity
	@ManyToOne
	@JoinColumn(name="SectorId")
	private SectorEntity sector;

	//bi-directional many-to-one association to ProductEntity
	@ManyToOne
	@JoinColumn(name="ProductId")
	private ProductEntity product;

	public SectorProductEntity() {
	}

	public SectorProductEntityPK getId() {
		return this.id;
	}

	public void setId(SectorProductEntityPK id) {
		this.id = id;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public SectorEntity getSector() {
		return this.sector;
	}

	public void setSector(SectorEntity sector) {
		this.sector = sector;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}