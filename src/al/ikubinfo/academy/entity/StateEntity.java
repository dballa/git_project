package al.ikubinfo.academy.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state database table.
 * 
 */
@Entity
@Table(name="state")
@NamedQuery(name="StateEntity.findAll", query="SELECT s FROM StateEntity s")
public class StateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int stateId;

	private String currencyType;

	private String stateName;

	private byte validity;

	//bi-directional many-to-one association to SectorStateEntity
	@OneToMany(mappedBy="state")
	private List<SectorStateEntity> sectorStates;

	//bi-directional many-to-one association to ShopEntity
	@OneToMany(mappedBy="state")
	private List<ShopEntity> shops;

	//bi-directional many-to-one association to StateProductEntity
	@OneToMany(mappedBy="state")
	private List<StateProductEntity> stateProducts;

	public StateEntity() {
	}

	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getCurrencyType() {
		return this.currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public List<SectorStateEntity> getSectorStates() {
		return this.sectorStates;
	}

	public void setSectorStates(List<SectorStateEntity> sectorStates) {
		this.sectorStates = sectorStates;
	}

	public SectorStateEntity addSectorState(SectorStateEntity sectorState) {
		getSectorStates().add(sectorState);
		sectorState.setState(this);

		return sectorState;
	}

	public SectorStateEntity removeSectorState(SectorStateEntity sectorState) {
		getSectorStates().remove(sectorState);
		sectorState.setState(null);

		return sectorState;
	}

	public List<ShopEntity> getShops() {
		return this.shops;
	}

	public void setShops(List<ShopEntity> shops) {
		this.shops = shops;
	}

	public ShopEntity addShop(ShopEntity shop) {
		getShops().add(shop);
		shop.setState(this);

		return shop;
	}

	public ShopEntity removeShop(ShopEntity shop) {
		getShops().remove(shop);
		shop.setState(null);

		return shop;
	}

	public List<StateProductEntity> getStateProducts() {
		return this.stateProducts;
	}

	public void setStateProducts(List<StateProductEntity> stateProducts) {
		this.stateProducts = stateProducts;
	}

	public StateProductEntity addStateProduct(StateProductEntity stateProduct) {
		getStateProducts().add(stateProduct);
		stateProduct.setState(this);

		return stateProduct;
	}

	public StateProductEntity removeStateProduct(StateProductEntity stateProduct) {
		getStateProducts().remove(stateProduct);
		stateProduct.setState(null);

		return stateProduct;
	}

}