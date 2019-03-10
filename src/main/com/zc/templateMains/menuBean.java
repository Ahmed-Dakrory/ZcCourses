package main.com.zc.templateMains;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class menuBean {
	private String menu[];
	private String menuLinks[]={
			"/ZcCourses",
			"/ZcCourses/pages/public/about.xhtml?faces-redirect=true",
			"/ZcCourses/pages/public/programs.xhtml?faces-redirect=true",
			"/ZcCourses/pages/public/contactUs.xhtml?faces-redirect=true",
			"/ZcCourses/pages/public/login.xhtml?faces-redirect=true",
			"/ZcCourses/pages/public/registeration.xhtml?faces-redirect=true",
			"/ZcCourses/pages/secured/admin/adminController.xhtml?faces-redirect=true"
			
	};
	
	@PostConstruct
	public void init() {
		menu=new String[7];
		//invertRemainMenus("0");
	}
	public void goToLink(int index) {
		System.out.println("Dakrory : Index ");
		for(int i=0;i<menu.length;i++){
			if(index==i){
				menu[i]="#7d818c";
			}else{
				menu[i]="none";
			}
		}
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect(menuLinks[index]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String[] getMenu() {
		return menu;
	}

	public void setMenu(String[] menu) {
		this.menu = menu;
	}
	public String[] getMenuLinks() {
		return menuLinks;
	}
	public void setMenuLinks(String[] menuLinks) {
		this.menuLinks = menuLinks;
	}

	
}
