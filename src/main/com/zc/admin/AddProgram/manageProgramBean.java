package main.com.zc.admin.AddProgram;

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

import main.com.zc.programs.ProgramData;
import main.com.zc.programs.ProgramDataAppServiceImpl;
import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.course;


@SessionScoped
@ManagedBean(name="manageProgramBean")
public class manageProgramBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9194523799512580592L;
	private String imageOfProgram;
	private byte[] imageOfProgrambyte;
	private boolean imageUploaded;
	
	private List<ProgramData> programs;
	private String[] programsNames;

	private int numShownRows=2;
	private List<ProgramData> filteredPrograms;
    
    private ProgramData selectedProgram;
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
		programsNames = new String[programs.size()];
		for(int i=0;i<programs.size();i++) {
			programsNames[i]=programs.get(i).getName();
		}
		System.out.println("All list = "+programs.size());
	}
	
	
	public void previewImage(FileUploadEvent event) {

		System.out.println("Dakrory    :File");
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
			
			imageOfProgram="images/uploadButton.png";
		}
	}
	
	
	
	public void closeDialog() {
		System.out.println("Dakrory: play with me");
		PrimeFaces.current().executeScript("dismissDialog();");
	}
	public void saveProgram() {
if(imageUploaded) {
		System.out.println("Dakrory: yes play with me");
		programDataFacede.addProgramData(programNew);
		programs=programDataFacede.getAll();

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("mainForm");
		PrimeFaces.current().executeScript("swal(\"Good job!\", \" "+programNew.getName()+" has(have) been saved Successfully\", \"success\");\r\n" + 
				"");
		PrimeFaces.current().executeScript("dismissDialog();");
}else {
	PrimeFaces.current().executeScript("swal({\r\n" + 
			"  title: \"You Don't Upload Image for the Program\",\r\n" + 
			"  text: \"Please Make sure that you upload the correct Program Image!\",\r\n" + 
			"  icon: \"warning\",\r\n" + 
			"})\r\n" + 
			";");
}
	}
	
	public void addNewProgram() {

		programNew=new ProgramData();
		imageUploaded=false;
		imageOfProgram=new String();
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("dialogForm");
		
		PrimeFaces.current().executeScript("openPopUpDialog();");
		System.out.println("Add New Program with id: NewNEw");	
		
		programs=programDataFacede.getAll();
	}
	
	
	
	public void deleteProgram() {

		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params  = context.getExternalContext().getRequestParameterMap();
		int programId = Integer.parseInt(params.get("id"));
		System.out.println("Delete Program with id: "+programId);
		ProgramData the_deleted_object=programDataFacede.getById(programId);
		List<course>list_of_courses_to_delete= courseFasade.getByIdProgram(the_deleted_object.getId());

		System.out.println("Delete : "+programId);
		for(int i=0;i<list_of_courses_to_delete.size();i++) {
			courseFasade.delete(list_of_courses_to_delete.get(i));
		}
		programDataFacede.delete(the_deleted_object);

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("mainForm");
		PrimeFaces.current().executeScript("swal(\"Good job!\", \" "+the_deleted_object.getName()+" has(have) been deleted Successfully\", \"success\");\r\n" + 
				"");
		
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

	public List<ProgramData> getFilteredPrograms() {
		return filteredPrograms;
	}

	public void setFilteredPrograms(List<ProgramData> filteredPrograms) {
		this.filteredPrograms = filteredPrograms;
	}

	public ProgramData getSelectedProgram() {
		return selectedProgram;
	}

	public void setSelectedProgram(ProgramData selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	public String[] getProgramsNames() {
		return programsNames;
	}

	public void setProgramsNames(String[] programsNames) {
		this.programsNames = programsNames;
	}

	public int getNumShownRows() {
		return numShownRows;
	}

	public void setNumShownRows(int numShownRows) {
		this.numShownRows = numShownRows;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
