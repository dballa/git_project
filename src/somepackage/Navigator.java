package somepackage;



import java.util.Random;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Navigator {

	private String[] resultPages= {"page1","page2"};
	
	public String choosePage() {
		
		return(RandomUtils.randomElement(resultPages));
	}
}
