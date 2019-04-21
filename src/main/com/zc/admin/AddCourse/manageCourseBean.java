package main.com.zc.admin.AddCourse;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;

import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.course;


@SessionScoped
@ManagedBean(name="manageCourseBean")
public class manageCourseBean implements Serializable{
	
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = -7409642722621101237L;
	/**
	 * 
	 */
	private String imageOfCourse;
	private byte[] imageOfCoursebyte;
	private boolean imageUploaded;
	
	private List<course> courses;
	private String[] coursesNames;

	private int numShownRows=2;
	private List<course> filteredcourses;
    
    private course selectedcourse;
	@ManagedProperty(value = "#{CourseFacadeImpl}")
	private CourseAppServiceImpl courseDataFacede; 
	
	
	private course courseNew;
	
	private course selectedCourse;
	private String imageOfCourseSelected;
	private byte[] imageOfCoursebyteSelected;
	private boolean imageUploadedSelected;
	
	
	@PostConstruct
	public void init() {
		courseNew=new course();
		selectedCourse=new course();
		imageUploaded=false;
		refreshPage();
	}
	
	public void refreshPage() {

		System.out.println("Dakrory New ...........................");
		
		courses=courseDataFacede.getAll();
		coursesNames = new String[courses.size()];
		for(int i=0;i<courses.size();i++) {
			coursesNames[i]=courses.get(i).getName();
		}
		System.out.println("All list = "+courses.size());
	}
	
	
	public void previewImage(FileUploadEvent event) {

		System.out.println("Dakrory    :File");
		/* FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		*/
		this.imageOfCoursebyte = event.getFile().getContents();
//Set The image to the object
		courseNew.setImage(imageOfCoursebyte);
		
		imageUploaded=true;
		setImageDependOnRegisterationImageState();
		System.out.println("File Uploaded");
		
	}
	
	public void previewImageSelected(FileUploadEvent event) {

		System.out.println("Dakrory    :File");
		/* FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		*/
		this.imageOfCoursebyteSelected = event.getFile().getContents();
//Set The image to the object
		selectedCourse.setImage(imageOfCoursebyteSelected);
		
		imageUploadedSelected=true;
		setImageDependOnRegisterationImageStateSelected();
		System.out.println("File Uploaded");
		
	}
	
	void setImageDependOnRegisterationImageState(){
		if(imageUploaded){
			imageOfCourse=courseNew.getphoto();
		}else{
			
			imageOfCourse="images/uploadButton.png";
		}
	}
	
	void setImageDependOnRegisterationImageStateSelected(){
		if(imageUploadedSelected){
			imageOfCourseSelected=selectedCourse.getphoto();
		}else{
			
			imageOfCourseSelected="images/uploadButton.png";
		}
	}
	
	
	
	public void closeDialog() {
		System.out.println("Dakrory: play with me");
		PrimeFaces.current().executeScript("dismissDialog();");
	}
public void savecourse() {
		
		if(courseNew.getIdProgram()!=0) {
			if(imageUploaded) {
					System.out.println("Dakrory: yes play with me");
					courseDataFacede.addCourse(courseNew);
					courses=courseDataFacede.getAll();
			
					FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("mainForm");
					PrimeFaces.current().executeScript("swal(\"Good job!\", \" "+courseNew.getName()+" has(have) been saved Successfully\", \"success\");\r\n" + 
							"");
					PrimeFaces.current().executeScript("dismissDialog();");
			}else {
				PrimeFaces.current().executeScript("swal({\r\n" + 
						"  title: \"You Don't Upload Image for the course\",\r\n" + 
						"  text: \"Please Make sure that you upload the correct course Image!\",\r\n" + 
						"  icon: \"warning\",\r\n" + 
						"})\r\n" + 
						";");
			}

		}else {
			PrimeFaces.current().executeScript("swal({\r\n" + 
					"  title: \"You Don't Select Program for the course\",\r\n" + 
					"  text: \"Please Make sure that you select the correct program !\",\r\n" + 
					"  icon: \"warning\",\r\n" + 
					"})\r\n" + 
					";");
		}
	}
	

public void updatecourse() {
	
	if(selectedCourse.getIdProgram()!=0) {
		if(imageUploadedSelected) {
				System.out.println("Dakrory: yes play with me");
				courseDataFacede.addCourse(selectedCourse);
				courses=courseDataFacede.getAll();
		
				FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("mainForm");
				PrimeFaces.current().executeScript("swal(\"Good job!\", \" "+selectedCourse.getName()+" has(have) been updated Successfully\", \"success\");\r\n" + 
						"");
				PrimeFaces.current().executeScript("dismissDialog();");
		}else {
			PrimeFaces.current().executeScript("swal({\r\n" + 
					"  title: \"You Don't Upload Image for the course\",\r\n" + 
					"  text: \"Please Make sure that you upload the correct course Image!\",\r\n" + 
					"  icon: \"warning\",\r\n" + 
					"})\r\n" + 
					";");
		}

	}else {
		PrimeFaces.current().executeScript("swal({\r\n" + 
				"  title: \"You Don't Select Program for the course\",\r\n" + 
				"  text: \"Please Make sure that you select the correct program !\",\r\n" + 
				"  icon: \"warning\",\r\n" + 
				"})\r\n" + 
				";");
	}
}


	public void addNewcourse() {

				courseNew=new course();
				imageUploaded=false;
				imageOfCourse=new String();
				FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("dialogForm");
				
				PrimeFaces.current().executeScript("$(\"#dialogOfSelectPhoto\").removeAttr(\"style\").show();");
				System.out.println("Add New course with id: NewNEw");	
				
				courses=courseDataFacede.getAll();
		
	}
	
	
	public void openCourseDetails(int courseId) {
		selectedCourse=courseDataFacede.getById(courseId);

		imageUploadedSelected=true;
		imageOfCourseSelected=new String();
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("dialogFormSelected");
		
		PrimeFaces.current().executeScript("$(\"#dialogOfSelectPhotoSelected\").removeAttr(\"style\").show();");
		System.out.println("Add New course with id: NewNEw");	
		setImageDependOnRegisterationImageStateSelected();
		courses=courseDataFacede.getAll();
		
	}
	public void deletecourse() {

		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params  = context.getExternalContext().getRequestParameterMap();
		int courseId = Integer.parseInt(params.get("id"));
		System.out.println("Delete course with id: "+courseId);
		course the_deleted_object=courseDataFacede.getById(courseId);
		
		courseDataFacede.delete(the_deleted_object);

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("mainForm");
		PrimeFaces.current().executeScript("swal(\"Good job!\", \" "+the_deleted_object.getName()+" has(have) been deleted Successfully\", \"success\");\r\n" + 
				"");
		
		courses=courseDataFacede.getAll();
	}

	
	public String imageUploadedVisibSelected(){
		if(imageUploadedSelected){
			return "block";
		}
		return "none";
	}
	
	public String imageUploadedVisibNotSelected(){
		if(!imageUploadedSelected){
			return "block";
		}
		return "none";
	}
	
	public String imageUploadedVisib(){
		if(imageUploaded){
			return "block";
		}
		return "none";
	}
	
	public String imageUploadedVisibNot(){
		if(!imageUploaded){
			return "block";
		}
		return "none";
	}

	public String getImageOfCourse() {
		return imageOfCourse;
	}

	public void setImageOfCourse(String imageOfCourse) {
		this.imageOfCourse = imageOfCourse;
	}

	public byte[] getImageOfCoursebyte() {
		return imageOfCoursebyte;
	}

	public void setImageOfCoursebyte(byte[] imageOfCoursebyte) {
		this.imageOfCoursebyte = imageOfCoursebyte;
	}

	public boolean isImageUploaded() {
		return imageUploaded;
	}

	public void setImageUploaded(boolean imageUploaded) {
		this.imageUploaded = imageUploaded;
	}

	public List<course> getCourses() {
		return courses;
	}

	public void setCourses(List<course> courses) {
		this.courses = courses;
	}

	public String[] getCoursesNames() {
		return coursesNames;
	}

	public void setCoursesNames(String[] coursesNames) {
		this.coursesNames = coursesNames;
	}

	public int getNumShownRows() {
		return numShownRows;
	}

	public void setNumShownRows(int numShownRows) {
		this.numShownRows = numShownRows;
	}

	public List<course> getFilteredcourses() {
		return filteredcourses;
	}

	public void setFilteredcourses(List<course> filteredcourses) {
		this.filteredcourses = filteredcourses;
	}

	public course getSelectedcourse() {
		return selectedcourse;
	}

	public void setSelectedcourse(course selectedcourse) {
		this.selectedcourse = selectedcourse;
	}

	public CourseAppServiceImpl getCourseDataFacede() {
		return courseDataFacede;
	}

	public void setCourseDataFacede(CourseAppServiceImpl courseDataFacede) {
		this.courseDataFacede = courseDataFacede;
	}

	public course getCourseNew() {
		return courseNew;
	}

	public void setCourseNew(course courseNew) {
		this.courseNew = courseNew;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public course getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public String getImageOfCourseSelected() {
		return imageOfCourseSelected;
	}

	public void setImageOfCourseSelected(String imageOfCourseSelected) {
		this.imageOfCourseSelected = imageOfCourseSelected;
	}

	public byte[] getImageOfCoursebyteSelected() {
		return imageOfCoursebyteSelected;
	}

	public void setImageOfCoursebyteSelected(byte[] imageOfCoursebyteSelected) {
		this.imageOfCoursebyteSelected = imageOfCoursebyteSelected;
	}

	public boolean isImageUploadedSelected() {
		return imageUploadedSelected;
	}

	public void setImageUploadedSelected(boolean imageUploadedSelected) {
		this.imageUploadedSelected = imageUploadedSelected;
	}

	
	
	
	
}
