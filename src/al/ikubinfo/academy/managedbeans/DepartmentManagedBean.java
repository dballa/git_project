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
import al.ikubinfo.academy.dao.DepartmentSearchFilter;
import al.ikubinfo.academy.entity.DepartmentEntity;

@ManagedBean
@ViewScoped
public class DepartmentManagedBean implements java.io.Serializable {

	private DepartmentEntity department;

	private DepartmentSearchFilter filter;
	
	private int toEditId;

	private DepartmentEntity toDelete;

	private List<DepartmentEntity> departments;

	private DepartmentDao departmentDao;

	public DepartmentManagedBean() {
		departmentDao = new DepartmentDao();
		department = new DepartmentEntity();
		toDelete = new DepartmentEntity();
		filter=new DepartmentSearchFilter();
	}

	@PostConstruct
	public void init() {

		departments = departmentDao.searchDepartments(filter);

	}

	public void search() {
		departments = departmentDao.searchDepartments(filter);
		
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
		departments = departmentDao.allDepartment();
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null,
				new FacesMessage("Succesfult", "Department " + department.getDepartmentName() + " added"));

	}

	public void redirectToEdit() throws IOException {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/edit.xhtml?id="+toEditId);
		System.out.println("REDU"+toEditId);

	}

	public void removeDepartment() {
		toDelete.setValidity((byte) 0);
		departmentDao.removeDepartment(toDelete);
		departments = departmentDao.allDepartment();
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null,
				new FacesMessage("Sukses", "Departamenti " + toDelete.getDepartmentName() + " u fshi"));
	}

	public DepartmentEntity getToDelete() {
		return toDelete;
	}

	public void setToDelete(DepartmentEntity toDelete) {
		this.toDelete = toDelete;
	}

	public int getToEditId() {
		return toEditId;
	}

	public void setToEditId(int toEditId) {
		this.toEditId = toEditId;
	}

	public DepartmentSearchFilter getFilter() {
		return filter;
	}

	public void setFilter(DepartmentSearchFilter filter) {
		this.filter = filter;
	}
}
