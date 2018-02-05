package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sector_state database table.
 * 
 */
@Entity
@Table(name="sector_state")
@NamedQuery(name="SectorStateEntity.findAll", query="SELECT s FROM SectorStateEntity s")
public class SectorStateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SectorStateEntityPK id;

	private byte validity;

	//bi-directional many-to-one association to SectorEntity
	@ManyToOne
	@JoinColumn(name="SectorId")
	private SectorEntity sector;

	//bi-directional many-to-one association to StateEntity
	@ManyToOne
	@JoinColumn(name="StateId")
	private StateEntity state;

	public SectorStateEntity() {
	}

	public SectorStateEntityPK getId() {
		return this.id;
	}

	public void setId(SectorStateEntityPK id) {
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

	public StateEntity getState() {
		return this.state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

}