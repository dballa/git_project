package al.ikubinfo.academy.managedbeans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
@ManagedBean
@ViewScoped
public class LogoutBean implements java.io.Serializable{

	
		
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


