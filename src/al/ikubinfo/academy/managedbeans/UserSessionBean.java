package al.ikubinfo.academy.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import al.ikubinfo.academy.dao.UserDao;
import al.ikubinfo.academy.entity.UserEntity;

@ManagedBean
@SessionScoped
public class UserSessionBean {

	private UserEntity user;
	private UserDao userDao;
	
	@PostConstruct
	public void init() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		String idFromSession =(String) context.getExternalContext().getSessionMap().get("userId"); 
		
		int id=Integer.parseInt(idFromSession);
		user=userDao.findUser(id);
		
		
		
	}
public UserSessionBean() {
	userDao=new UserDao();
}
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
