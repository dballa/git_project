package al.ikubinfo.academy.managedbeans;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import al.ikubinfo.academy.dao.DepartmentDao;
import al.ikubinfo.academy.entity.DepartmentEntity;
import al.ikubinfo.academy.hibernate.util.HibernateUtil;

@ManagedBean
@ViewScoped
public class EditDepartmentBean {

	private DepartmentDao departmentDao;
	
	private DepartmentEntity toEdit;
	
	
	public EditDepartmentBean() {
		departmentDao=new DepartmentDao();
		
	}

@PostConstruct
public void init() {

	String id= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
	
	int toEditId=Integer.parseInt(id);
	System.out.println(toEditId);
	
	toEdit=departmentDao.getDepartmentById(toEditId);
	
	
	
	
}

public DepartmentEntity getToEdit() {
	return toEdit;
}

public void setToEdit(DepartmentEntity toEdit) {
	this.toEdit = toEdit;
}
	public void editDepartment() throws IOException {
		
		departmentDao.editDepartment(toEdit);
		System.out.println("done");
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/Admin.xhtml");
	}
}
