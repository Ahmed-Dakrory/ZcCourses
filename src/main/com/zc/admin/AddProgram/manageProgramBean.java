package main.com.zc.admin.AddProgram;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;

import main.com.zc.programs.ProgramData;
import main.com.zc.programs.ProgramDataAppServiceImpl;
import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.course;


@SessionScoped
@ManagedBean(name="manageProgramBean")
public class manageProgramBean {
	

	private String imageOfProgram;
	private byte[] imageOfProgrambyte;
	private boolean imageUploaded;
	
	private List<ProgramData> programs;

	@ManagedProperty(value = "#{ProgramDataFacadeImpl}")
	private ProgramDataAppServiceImpl programDataFacede; 
	
	
	private ProgramData programNew;
	@ManagedProperty(value = "#{CourseFacadeImpl}")
	private CourseAppServiceImpl courseFasade; 
	private List<course> courses;
	
	@PostConstruct
	public void init() {
		programNew=new ProgramData();
		imageUploaded=false;
		refreshPage();
	}
	
	public void refreshPage() {

		System.out.println("Dakrory New ...........................");
		
		programs=programDataFacede.getAll();
		System.out.println("All list = "+programs.size());
	}
	
	
	public void previewImage(FileUploadEvent event) {
		/* FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		*/
		this.imageOfProgrambyte = event.getFile().getContents();
//Set The image to the object
		programNew.setImg(imageOfProgrambyte);
		
		imageUploaded=true;
		setImageDependOnRegisterationImageState();
		System.out.println("File Uploaded");
		
	}
	
	void setImageDependOnRegisterationImageState(){
		if(imageUploaded){
			imageOfProgram=programNew.getphoto();
		}else{
			
			imageOfProgram="images/comment-img3.jpg";
		}
	}
	
	public void addNewProgram() {

		PrimeFaces.current().executeScript("openPopUpDialog();");
		System.out.println("Add New Program with id: NewNEw");	
		
		
		
		programs=programDataFacede.getAll();
	}
	
	public void deleteProgram(int programId) {
		System.out.println("Delete Program with id: "+programId);
		
		
		programs=programDataFacede.getAll();
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
	public String getImageOfProgram() {
		return imageOfProgram;
	}

	public void setImageOfProgram(String imageOfProgram) {
		this.imageOfProgram = imageOfProgram;
	}

	public byte[] getImageOfProgrambyte() {
		return imageOfProgrambyte;
	}

	public void setImageOfProgrambyte(byte[] imageOfProgrambyte) {
		this.imageOfProgrambyte = imageOfProgrambyte;
	}

	public boolean isImageUploaded() {
		return imageUploaded;
	}

	public void setImageUploaded(boolean imageUploaded) {
		this.imageUploaded = imageUploaded;
	}

	public List<ProgramData> getPrograms() {
		return programs;
	}

	public void setPrograms(List<ProgramData> programs) {
		this.programs = programs;
	}

	public ProgramDataAppServiceImpl getProgramDataFacede() {
		return programDataFacede;
	}

	public void setProgramDataFacede(ProgramDataAppServiceImpl programDataFacede) {
		this.programDataFacede = programDataFacede;
	}

	public ProgramData getProgramNew() {
		return programNew;
	}

	public void setProgramNew(ProgramData programNew) {
		this.programNew = programNew;
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
