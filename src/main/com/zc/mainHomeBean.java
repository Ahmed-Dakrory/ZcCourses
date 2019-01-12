package main.com.zc;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.course;



@Named
@ApplicationScoped
public class mainHomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String homeSiteName;
	
	 @Inject
	 private CourseAppServiceImpl courseFasade; 
	 private List<course> courses;
	
	 
	@PostConstruct
	public void init() {
		refreshPage();
	}
	
	public void refreshPage(){
		
		homeSiteName="Zewail Courses";
		courses=courseFasade.getAll();
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

	

	
	
}
