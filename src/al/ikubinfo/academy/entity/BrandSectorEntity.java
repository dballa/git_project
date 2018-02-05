package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the brand_sector database table.
 * 
 */
@Entity
@Table(name="brand_sector")
@NamedQuery(name="BrandSectorEntity.findAll", query="SELECT b FROM BrandSectorEntity b")
public class BrandSectorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BrandSectorEntityPK id;

	private byte validity;

	//bi-directional many-to-one association to SectorEntity
	@ManyToOne
	@JoinColumn(name="SectorId")
	private SectorEntity sector;

	//bi-directional many-to-one association to BrandEntity
	@ManyToOne
	@JoinColumn(name="BrandId")
	private BrandEntity brand;

	public BrandSectorEntity() {
	}

	public BrandSectorEntityPK getId() {
		return this.id;
	}

	public void setId(BrandSectorEntityPK id) {
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

	public BrandEntity getBrand() {
		return this.brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

}