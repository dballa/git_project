package al.ikubinfo.academy.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ErrorLoginBean {

	
	 public String  tryAgain() {
		 
		 return "login";
		 
	 }
}
