package al.ikubinfo.academy.managedbeans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import al.ikubinfo.academy.dao.DepartmentDao;
import al.ikubinfo.academy.dao.SectorDao;
import al.ikubinfo.academy.dao.SectorSearchFilter;
import al.ikubinfo.academy.entity.DepartmentEntity;
import al.ikubinfo.academy.entity.SectorEntity;

@ManagedBean
@ViewScoped
public class SectorBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4613018495300833578L;
	
	private int toEditId;
	private SectorEntity sector;
	private SectorEntity toDelete;
	private SectorSearchFilter filter;
	private DepartmentDao departmentDao;
	
	
	private List<SectorEntity> sectors;
	private SectorDao sectorDao;
	private DepartmentEntity department;

	private List<DepartmentEntity> departments;

	public SectorBean() {
		sectorDao = new SectorDao();
		departmentDao=new DepartmentDao();
		sector = new SectorEntity();
		department = new DepartmentEntity();
		filter=new SectorSearchFilter();

	}



	@PostConstruct
	public void init() {

		sectors = sectorDao.searchSector(filter);
		departments = departmentDao.allDepartment();
	}



	public SectorEntity getSector() {
		return sector;
	}

	public void setSector(SectorEntity sector) {
		this.sector = sector;
	}

	public List<SectorEntity> getSectors() {
		return sectors;
	}

	public void setSectors(List<SectorEntity> sectors) {
		this.sectors = sectors;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public List<DepartmentEntity> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentEntity> departments) {
		this.departments = departments;
	}


	public int getToEditId() {
		return toEditId;
	}

	public void setToEditId(int toEditId) {
		this.toEditId = toEditId;
	}

	public void redirectToSector() throws IOException {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/Sector.xhtml");
		System.out.println("REDU");

	}





	public void findSectors() {

		sectors = sectorDao.findSectors(department.getDepartmentId());

	}
	public void addSector() {
		
		sectorDao.addSector(sector);
		sectors=sectorDao.allSectors();
	
	}
	public void removeSector() {
		toDelete.setValidity((byte) 0);
		sectorDao.removeSector(toDelete);
		sectors = sectorDao.allSectors();
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null,
				new FacesMessage("Sukses", "Sector " + toDelete.getSectorName() + " deleted"));
	}

	
	public void redirectToEdit() throws IOException {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/EditSector.xhtml?id="+toEditId);
		System.out.println("REDU"+toEditId);
	
	}
	
	public void searchSector() {
		sectors=sectorDao.searchSector(filter);
		
	}
	
	
	public SectorEntity getToDelete() {
		return toDelete;
	}

	public void setToDelete(SectorEntity toDelete) {
		this.toDelete = toDelete;
	}

	public SectorSearchFilter getFilter() {
		return filter;
	}

	public void setFilter(SectorSearchFilter filter) {
		this.filter = filter;
	}
	
		
	}

