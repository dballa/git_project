package al.ikubinfo.academy.managedbeans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import al.ikubinfo.academy.dao.SectorDao;
import al.ikubinfo.academy.dao.ShopDao;
import al.ikubinfo.academy.dao.ShopSearchFilter;
import al.ikubinfo.academy.dao.StateDao;
import al.ikubinfo.academy.entity.SectorEntity;
import al.ikubinfo.academy.entity.ShopEntity;
import al.ikubinfo.academy.entity.StateEntity;

@ManagedBean
@ViewScoped
public class ShopBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List <ShopEntity> shops;
	private ShopEntity shop;
	private SectorDao sectorDao;
	private List<SectorEntity> sectors;
	private ShopSearchFilter filter;
	private ShopDao shopDao;
	private int toEditId;
	private ShopEntity toDelete;
	private SectorEntity sector;
	private List<StateEntity>states;
	private StateDao stateDao;
	public ShopBean() {
		shopDao=new ShopDao();
		shop=new ShopEntity();
		filter=new ShopSearchFilter();
		sectorDao=new SectorDao();
		stateDao=new StateDao();
		
	}
	@PostConstruct
	public void init() {
		shops=shopDao.searchShop(filter);
		sectors=sectorDao.allSectors();
		states=stateDao.allStates();
	}
	
	public void redirectToShop() throws IOException {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/Shop.xhtml");
		System.out.println("REDU");

	}
	public void findShop() {

		shops = shopDao.findShops(sector.getSectorId());

	}
public void addShop() {
		
		shopDao.addShop(shop);
		shops=shopDao.allShops();
	
	}
public void removeShop() {
	toDelete.setValidity((byte) 0);
	shopDao.removeShop(toDelete);
	shops = shopDao.allShops();
	FacesContext context = FacesContext.getCurrentInstance();

	context.addMessage(null,
			new FacesMessage("Sucsses", "Shop " + toDelete.getShopName() + " deleted"));
}
public void redirectToEdit() throws IOException {
	FacesContext fContext = FacesContext.getCurrentInstance();
	ExternalContext extContext = fContext.getExternalContext();
	extContext.redirect(extContext.getRequestContextPath() + "/EditShop.xhtml?id="+toEditId);
	System.out.println("REDU"+toEditId);

}
public void searchShop() {
	shops=shopDao.searchShop(filter);
	
}
	
	public List<ShopEntity> getShops() {
		return shops;
	}
	public void setShops(List<ShopEntity> shops) {
		this.shops = shops;
	}
	public ShopEntity getShop() {
		return shop;
	}
	public void setShop(ShopEntity shop) {
		this.shop = shop;
	}
	public List<SectorEntity> getSectors() {
		return sectors;
	}
	public void setSectors(List<SectorEntity> sectors) {
		this.sectors = sectors;
	}
	public ShopSearchFilter getFilter() {
		return filter;
	}
	public void setFilter(ShopSearchFilter filter) {
		this.filter = filter;
	}
	public int getToEditId() {
		return toEditId;
	}
	public void setToEditId(int toEditId) {
		this.toEditId = toEditId;
	}
	public ShopEntity getToDelete() {
		return toDelete;
	}
	public void setToDelete(ShopEntity toDelete) {
		this.toDelete = toDelete;
	}
	public SectorEntity getSector() {
		return sector;
	}
	public void setSector(SectorEntity sector) {
		this.sector = sector;
	}
	public List<StateEntity> getStates() {
		return states;
	}
	public void setStates(List<StateEntity> states) {
		this.states = states;
	}
	
}
