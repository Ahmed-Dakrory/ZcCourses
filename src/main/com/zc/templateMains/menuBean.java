package main.com.zc.templateMains;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class menuBean {
	private String menu[];
	String menuLinks[]={
			"/pages/public/index.xhtml?faces-redirect=true",
			"/pages/public/about_us.xhtml?faces-redirect=true",
			"/pages/public/programs.xhtml?faces-redirect=true",
			"/pages/public/contact_us.xhtml?faces-redirect=true",
			"/pages/public/login.xhtml?faces-redirect=true",
			"/pages/public/registeration.xhtml?faces-redirect=true"
			
	};
	
	@PostConstruct
	public void init() {
		menu=new String[6];
		invertRemainMenus("0");
	}
	
	public String invertRemainMenus(String n){
		int index=Integer.valueOf(n);
		System.out.println(menuLinks[index]);
		for(int i=0;i<menu.length;i++){
			if(index==i){
				menu[i]="#7d818c";
			}else{
				menu[i]="none";
			}
		}
		return menuLinks[index];
	}

	
	
	public String[] getMenu() {
		return menu;
	}

	public void setMenu(String[] menu) {
		this.menu = menu;
	}

	
}
