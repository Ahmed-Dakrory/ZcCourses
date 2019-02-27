package main.com.zc.admin.AddProgram;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import main.com.zc.programs.ProgramData;
import main.com.zc.programs.ProgramDataAppServiceImpl;


@SessionScoped
@ManagedBean(name="manageProgramBean")
public class manageProgramBean {
	

	private String imageOfProgram;
	private byte[] imageOfProgrambyte;
	private boolean imageUploaded;
	
	private List<ProgramData> programs;

	@ManagedProperty(value = "#{ProgramDataFacadeImpl}")
	private ProgramDataAppServiceImpl programDataFacede; 
	
	
	@PostConstruct
	public void init() {

		imageUploaded=false;
		refreshPage();
	}
	
	public void refreshPage() {

		System.out.println("Dakrory New ...........................");
		
		programs=programDataFacede.getAll();
		System.out.println("All list = "+programs.size());
	}
	
	
	public void addNewProgram() {
		System.out.println("Add New Program with id: ");	
		
		
		
		programs=programDataFacede.getAll();
	}
	
	public void deleteProgram(int programId) {
		System.out.println("Delete Program with id: "+programId);
		
		
		programs=programDataFacede.getAll();
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
	
	
}
