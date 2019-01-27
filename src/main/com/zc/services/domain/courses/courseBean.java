package main.com.zc.services.domain.courses;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;

import main.com.zc.allRegisterations.courseReg;
import main.com.zc.allRegisterations.courseRegAppServiceImpl;
import main.com.zc.loginNeeds.loginBean;
import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.course;




@ManagedBean(name = "courseBean")
@SessionScoped
public class courseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7292135686409219607L;


	@ManagedProperty(value = "#{loginBean}")
	private loginBean loginBean;
	
	



	@ManagedProperty(value = "#{CourseFacadeImpl}")
	private CourseAppServiceImpl courseFasade; 
	private List<course> courses;

	private course thecourseSelected;
	private int selectedCourseId;
	 

	@ManagedProperty(value = "#{courseRegFacadeImpl}")
	private courseRegAppServiceImpl registerCourseFasade;
	 
	@PostConstruct
	public void init() {
		refreshPage();
		
	}
	
	public void dismissDialog(){

		PrimeFaces.current().executeScript("dismiss();");
	}
	
	public void enrollInCourse(int id){
		selectedCourseId=id;
		if(loginBean.isLoggedIn()){
			PrimeFaces.current().executeScript("opencomfirmPopUpBox();");
			
		}else{
			PrimeFaces.current().executeScript("openLoginPopUpBox();");
		}
	}
	
	public String getTheStateOfViewOfSelectedCourse(int courseId,int state){
		if(loginBean.isLoggedIn()){
			courseReg courseReg = registerCourseFasade.getByIdStudentandCourseId(loginBean.getTheUserOfThisAccount().getId(), courseId);
			if(state==0){
				if(courseReg!=null){
					//He is registered
					return "none";
				}else{
					return "block";
				}
			}else if(state == 1){
				if(courseReg!=null){
					//He is registered
					return "block";
				}else{
					return "none";
				}
			}else{
				return "block";
			}
		}else{
		
			if(state==0){
				
				return "block";
				
			}else if(state == 1){
				return "none";
				
			}else{
				return "block";
			}
		}
	}
	
	public void comfirmActionForEnrollment() {
		// TODO Auto-generated method stub
		courseReg courseReg=new courseReg();
		courseReg.setCourseId(selectedCourseId);
		courseReg.setStudentId(loginBean.getTheUserOfThisAccount().getId());
		courseReg.setDate(Calendar.getInstance());
		
		registerCourseFasade.addcourseReg(courseReg);
		System.out.println("enrolled");
		dismissDialog();
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("enrollmentPanel");
		
	}
	
	public void getCoursesRelatedToprogram(int idProgram){
		try {
	  		courses=courseFasade.getByIdCourse(idProgram);
	  	for(int i=0;i<courses.size();i++) {
	  		if(courses.get(i).getId()==thecourseSelected.getId()) {
	  			courses.remove(i);
	  		}
	  	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void refreshPage(){
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();
		
		try{
			Integer id=Integer.parseInt(origRequest.getParameterValues("id")[0]);
				if(id!=null){
					thecourseSelected=courseFasade.getById(id);
			  		selectedCourseId=thecourseSelected.getId();
			  		getCoursesRelatedToprogram(thecourseSelected.getIdProgram());
					
				}
			}
		catch(Exception ex){
			 
		}
	}

	
	
	public CourseAppServiceImpl getCourseFasade() {
		return courseFasade;
	}

	public void setCourseFasade(CourseAppServiceImpl courseFasade) {
		this.courseFasade = courseFasade;
	}

	public List<course> getCourses() {
		return courses;
	}

	public void setCourses(List<course> courses) {
		this.courses = courses;
	}

	

	public course getThecourseSelected() {
		return thecourseSelected;
	}

	public void setThecourseSelected(course thecourseSelected) {
		this.thecourseSelected = thecourseSelected;
	}

	public loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public courseRegAppServiceImpl getRegisterCourseFasade() {
		return registerCourseFasade;
	}

	public void setRegisterCourseFasade(courseRegAppServiceImpl registerCourseFasade) {
		this.registerCourseFasade = registerCourseFasade;
	}

	public int getSelectedCourseId() {
		return selectedCourseId;
	}

	public void setSelectedCourseId(int selectedCourseId) {
		this.selectedCourseId = selectedCourseId;
	}

	
	

	
	
	
}
