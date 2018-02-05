package al.ikubinfo.academy.managedbeans;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import al.ikubinfo.academy.dao.LoginDao;
import al.ikubinfo.academy.entity.UserEntity;

@ManagedBean
@RequestScoped
public class LoginManagedBean implements java.io.Serializable {

	private UserEntity user;

	@PostConstruct
	public void init() {

		user = new UserEntity();
	}

	public void login() throws IOException {

		LoginDao loginDao = new LoginDao();
		FacesContext context = FacesContext.getCurrentInstance();
		user = loginDao.validate(user);
		if (user == null) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error logging in", "Error logging in"));
		/*	context.getExternalContext().redirect("ErrorLogin.xhtml");*/

		} else if (user.getValidity() == 1) {

			context.getExternalContext().getSessionMap().put("userId", user.getUserId());
			context.getExternalContext().getSessionMap().put("type", user.getType());

			if (user.getType().equals("admin")) {
				context.getExternalContext().redirect("Admin.xhtml");

			} else if (user.getType().equals("user")) {

				context.getExternalContext().redirect("user.xhtml");

			}

		} else {
			context.getExternalContext().redirect("ErrorLogin.xhtml");
		}

	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String redirectToRegister() {
		return "Register";

	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
