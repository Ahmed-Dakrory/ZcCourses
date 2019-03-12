package main.com.zc;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import main.com.zc.loginNeeds.UserData;
import main.com.zc.loginNeeds.UserDataAppServiceImpl;
import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.course;



@ManagedBean(name = "mainHomeBean")
@SessionScoped
public class mainHomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8006657939592994747L;

	/**
	 * 
	 */
	private String homeSiteName;
	
	@ManagedProperty(value = "#{CourseFacadeImpl}")
	 private CourseAppServiceImpl courseFasade; 
	 private List<course> courses;
	

	@ManagedProperty(value = "#{UserDataFacadeImpl}")
	private UserDataAppServiceImpl userDataFacede; 
	private List<UserData> userdata;
	
	private String dataName;
	
	@PostConstruct
	public void init() {
		refreshPage();
		
	}
	
	public void refreshPage(){
		dataName="ahmed";
		homeSiteName="Zewail Courses";
		courses=courseFasade.getAll();
		userdata=userDataFacede.getAll();
	}
	
	public void run() {
		System.out.println("Data: "+dataName);
	}
	
	public String getHomeSiteName() {
		return homeSiteName;
	}
	public void setHomeSiteName(String homeSiteName) {
		this.homeSiteName = homeSiteName;
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

	public UserDataAppServiceImpl getUserDataFacede() {
		return userDataFacede;
	}

	public void setUserDataFacede(UserDataAppServiceImpl userDataFacede) {
		this.userDataFacede = userDataFacede;
	}

	
	public List<UserData> getUserdata() {
		return userdata;
	}

	public void setUserdata(List<UserData> userdata) {
		this.userdata = userdata;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	

	
	
}
