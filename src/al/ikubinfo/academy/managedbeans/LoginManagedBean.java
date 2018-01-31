package al.ikubinfo.academy.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import al.ikubinfo.academy.dao.LoginDao;
import al.ikubinfo.academy.data.entity.UserEntity;

@ManagedBean
@SessionScoped
public class LoginManagedBean  implements java.io.Serializable {

	
	
private UserEntity user;
	

@PostConstruct
public void init() {
	
	user=new UserEntity();
}

	public String login() {

		LoginDao loginDao=new LoginDao();

		
		return loginDao.validate(user);
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	}

