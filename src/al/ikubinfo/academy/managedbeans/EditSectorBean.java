package al.ikubinfo.academy.managedbeans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import al.ikubinfo.academy.dao.DepartmentDao;
import al.ikubinfo.academy.dao.SectorDao;
import al.ikubinfo.academy.entity.DepartmentEntity;
import al.ikubinfo.academy.entity.SectorEntity;
@ManagedBean
@ViewScoped
public class EditSectorBean {
private SectorDao sectorDao;
	private List<DepartmentEntity> departments;
	private SectorEntity toEdit;
	private DepartmentDao departmentDao;
	
	public EditSectorBean () {
		sectorDao=new SectorDao();
		departmentDao=new DepartmentDao();
	}

@PostConstruct
public void init() {

	String id= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
	
	int toEditId=Integer.parseInt(id);
	System.out.println(toEditId);
	
	toEdit=sectorDao.getSectorById(toEditId);
	
	departments = departmentDao.allDepartment();
	
	
}

public SectorEntity getToEdit() {
	return toEdit;
}

public void setToEdit(SectorEntity toEdit) {
	this.toEdit = toEdit;
}
	public void editSector() throws IOException {
		
		sectorDao.editSector(toEdit);
		System.out.println("done");
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/Sector.xhtml?i=1");
	}

	public List<DepartmentEntity> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentEntity> departments) {
		this.departments = departments;
	}
}
