package al.ikubinfo.academy.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import al.ikubinfo.academy.dao.UserDao;
import al.ikubinfo.academy.entity.UserEntity;
@ManagedBean
@ViewScoped
public class UserManagedBean  implements java.io.Serializable {

	private UserEntity user;
	private UserDao userDao;
	
	public UserManagedBean() {
		user=new UserEntity();
		userDao=new UserDao();
	}
	
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	@PostConstruct
	public void init() {
		
	
		
	}
	
	public String redirectRegistration() {
		
		return "register";
	}
	
	public String addUser() {
		userDao.addUser(user);
		
FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly",  "User " + user.getEmail() + " added") );
        
        return "login.xhtml";
	}
	
}
