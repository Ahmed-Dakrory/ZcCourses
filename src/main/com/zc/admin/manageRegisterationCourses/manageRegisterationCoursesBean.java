package main.com.zc.admin.manageRegisterationCourses;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import main.com.zc.allRegisterations.courseReg;
import main.com.zc.allRegisterations.courseRegAppServiceImpl;
import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.course;


@SessionScoped
@ManagedBean(name="manageRegisterationCoursesBean")
public class manageRegisterationCoursesBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8318867545685108254L;




	
	
	
	@ManagedProperty(value = "#{CourseFacadeImpl}")
	private CourseAppServiceImpl courseFasade; 
	
	

	@ManagedProperty(value = "#{courseRegFacadeImpl}")
	private courseRegAppServiceImpl registerCourseFasade;
	
	private List<course> courses;
	
	private List<courseReg> specCourseRegisterations;
	
	private int selectedCourseId;
	
	private courseReg selectedRegisterationForm;
	
	@PostConstruct
	public void init() {
		
		refreshPage();
		specCourseRegisterations=registerCourseFasade.getAll();
	}
	
	public void refreshPage() {
		courses=courseFasade.getAll();
		if(selectedCourseId==0) {
			specCourseRegisterations=registerCourseFasade.getAll();
		}else {
			specCourseRegisterations=registerCourseFasade.getByIdCourse(selectedCourseId);
		}
		
	}
	
	
	public void submitTheFormData() {
		registerCourseFasade.addcourseReg(selectedRegisterationForm);
	}
	
	public void filterRegisterationsToCourse() {

		System.out.println("Ahmed Dakrroy: "+selectedCourseId);
		if(selectedCourseId==0) {
			specCourseRegisterations=registerCourseFasade.getAll();
		}else {
			specCourseRegisterations=registerCourseFasade.getByIdCourse(selectedCourseId);
		}
		
		try {
			reload();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void reload() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
	
	public String getTheStatueOfImageMenu(){
		if(selectedRegisterationForm.getStudentId().getImage()==null){
			return "inherit";
		}else {
			return "none";
		}
	}
	
	public String getTheStatueOfImageLoginMenu(){
		if(selectedRegisterationForm.getStudentId().getImage()==null){
			return "none";
		}else {
			return "inherit";
		}
	}
	
	
	public void openStudentRegisterationPage(int id) {
		selectedRegisterationForm=registerCourseFasade.getById(id);
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/registeredCoursesStudentDetails.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CourseAppServiceImpl getCourseFasade() {
		return courseFasade;
	}

	public void setCourseFasade(CourseAppServiceImpl courseFasade) {
		this.courseFasade = courseFasade;
	}

	public courseRegAppServiceImpl getRegisterCourseFasade() {
		return registerCourseFasade;
	}

	public void setRegisterCourseFasade(courseRegAppServiceImpl registerCourseFasade) {
		this.registerCourseFasade = registerCourseFasade;
	}

	public List<course> getCourses() {
		return courses;
	}

	public void setCourses(List<course> courses) {
		this.courses = courses;
	}

	public List<courseReg> getSpecCourseRegisterations() {
		return specCourseRegisterations;
	}

	public void setSpecCourseRegisterations(List<courseReg> specCourseRegisterations) {
		this.specCourseRegisterations = specCourseRegisterations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSelectedCourseId() {
		return selectedCourseId;
	}

	public void setSelectedCourseId(int selectedCourseId) {
		this.selectedCourseId = selectedCourseId;
	}

	public courseReg getSelectedRegisterationForm() {
		return selectedRegisterationForm;
	}

	public void setSelectedRegisterationForm(courseReg selectedRegisterationForm) {
		this.selectedRegisterationForm = selectedRegisterationForm;
	}
	

	
	
}
