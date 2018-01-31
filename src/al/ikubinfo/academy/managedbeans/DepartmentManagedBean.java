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
import al.ikubinfo.academy.data.entity.DepartmentEntity;

@ManagedBean
@ViewScoped
public class DepartmentManagedBean implements java.io.Serializable {

	private DepartmentEntity department;
	
	private DepartmentEntity toDelete;

	private List<DepartmentEntity> departments;

	private DepartmentDao departmentDao;

	public DepartmentManagedBean() {
		departmentDao = new DepartmentDao();
		department = new DepartmentEntity();
		toDelete=new DepartmentEntity();
	}

	@PostConstruct
	public void init() {

		departments = allDepartment();

	}

	public List<DepartmentEntity> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentEntity> departments) {
		this.departments = departments;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public List<DepartmentEntity> allDepartment() {

		List<DepartmentEntity> deparmtents = departmentDao.allDepartment();
		
		return deparmtents;

	}

	public void addDepartment() {
		departmentDao.addDepartment(department);
		departments=departmentDao.allDepartment();
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Sukses",  "Departamenti " + department.getDepartmentName() + " u shtua") );

	}
	
	public void redirectToEdit() throws IOException {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/edit.xhtml");
		System.out.println("REDU");
		
	}
	
	public void removeDepartment() {
		toDelete.setValidity((byte) 0);
		departmentDao.removeDepartment(toDelete);
		departments=departmentDao.allDepartment();
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Sukses",  "Departamenti " + toDelete.getDepartmentName() + " u fshi") );
	}

	public DepartmentEntity getToDelete() {
		return toDelete;
	}

	public void setToDelete(DepartmentEntity toDelete) {
		this.toDelete = toDelete;
	}
}
