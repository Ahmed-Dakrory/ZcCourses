package main.com.zc.admin.manageRegisterationCourses;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.PrimeFaces;
import org.primefaces.model.UploadedFile;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import main.com.zc.allRegisterations.courseReg;
import main.com.zc.allRegisterations.courseRegAppServiceImpl;
import main.com.zc.loginNeeds.UserData;
import main.com.zc.loginNeeds.loginBean;
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
	


	@ManagedProperty(value = "#{loginBean}")
	private loginBean loginBean;

	@ManagedProperty(value = "#{courseRegFacadeImpl}")
	private courseRegAppServiceImpl registerCourseFasade;
	
	private List<course> courses;

	private List<courseReg> specCourseRegisterations;
	private List<courseReg> listOfCourseRegisterations;
	
	private int selectedCourseId;
	
	private courseReg selectedRegisterationForm;

	private course uploadedListOfGradesCourse;
	private Integer courseIdSelected;

	private UploadedFile file;
	private String statusMessage;
	private boolean resultText;
	
	@PostConstruct
	public void init() {
		
		refreshPage();
		specCourseRegisterations=registerCourseFasade.getAll();
	}
	public void selectCourseForUploading() {
		uploadedListOfGradesCourse = courseFasade.getById(selectedCourseId);
	}
	public void refreshPage() {
		courses=courseFasade.getAll();
		if(selectedCourseId==0) {
			specCourseRegisterations=registerCourseFasade.getAll();
		}else {
			specCourseRegisterations=registerCourseFasade.getByIdCourse(selectedCourseId);
		}
		
	}
	
	
	public String parseFile()
	{
		System.out.println("Dakrory: New");
		if(file.getSize()!=0&&file!=null) {
		 InputStream inputStream = null;
		 try {
			inputStream=file.getInputstream();
			listOfCourseRegisterations=parseCertsFile(inputStream);
			System.out.println("Size : "+listOfCourseRegisterations.size());
			resultText=true;
			//courses=facade.saveCourses(list);
			//System.out.println("Added Courses size is "+courses.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 return "";
	}
	public void saveGrade()
	{
		for(int i=0;i<listOfCourseRegisterations.size();i++) {
			registerCourseFasade.addcourseReg(listOfCourseRegisterations.get(i));
		}
		if(listOfCourseRegisterations.size()!=0)
		{
				String listSize=String.valueOf(listOfCourseRegisterations.size());
	        PrimeFaces.current().executeScript("swal(\"Good job!\", \" "+listSize+" user(s) has(have) been saved Successfully\", \"success\");\r\n" + 
					"");
	        System.out.println("Added List size is "+listOfCourseRegisterations.size());

	        listOfCourseRegisterations=new ArrayList<courseReg>();
		}
	}
	
	 public String getTheValueFromCell(Cell cell) {
		 String returnedValue="";
		 switch (cell.getCellType()) {
		
		 case Cell.CELL_TYPE_BLANK:
        	 returnedValue = "";
             break;
         case Cell.CELL_TYPE_STRING:
        	 returnedValue = String.valueOf(cell.getStringCellValue());
             break;
         case Cell.CELL_TYPE_NUMERIC:
        	 Long number = (long) cell.getNumericCellValue();
        	 returnedValue = String.valueOf(number);
             break;
         case Cell.CELL_TYPE_BOOLEAN:
        	 returnedValue = String.valueOf(cell.getBooleanCellValue());
             break;
         
         default :

         }
		 return returnedValue;
	 }
	 
	public List<courseReg> parseCertsFile(InputStream input) {
		List<courseReg> dataList = new ArrayList<courseReg>();
		try {
			//inputStream = resource.getInputStream();
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(input);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one

			for(int i=1;i<sheet.getLastRowNum();i++) {
				Row row = sheet.getRow(i);
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				courseReg data=new courseReg();

				String emailOfStudent="";
				String nameOfStudent="";
				String phoneOfStudent="";
			UserData userStudent;
			
				int count = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					count++;
				
                  switch(count) {
                  case 1:
	                	try {
							nameOfStudent = getTheValueFromCell(cell);
							System.out.println("Dakrory: "+nameOfStudent);
						} catch (Exception ex) {
						}
	                	  break;
	                	  
                  case 2:
	                	try {
	                		phoneOfStudent = getTheValueFromCell(cell);
						} catch (Exception ex) {
						}
	                	  break;
	                	  
	                case 3:
	                	try {
	                		emailOfStudent = getTheValueFromCell(cell);
	                		userStudent = loginBean.getUserDataFacede().getByEmail(emailOfStudent);
	                		if(userStudent == null) {
	                			userStudent=new UserData();
	                			userStudent.setActive(1);
	                			userStudent.setEmail(emailOfStudent);
	                			userStudent.setMode(1);
	                			userStudent.setFullName(nameOfStudent);
								System.out.println("Dakrory2: "+nameOfStudent);
	                			userStudent.setWhereYknowAboutUs(1);
	                			userStudent.setPassword(new  Md5PasswordEncoder().encodePassword(emailOfStudent,emailOfStudent));
	                			userStudent.setMobile(phoneOfStudent);
	                			loginBean.getUserDataFacede().addUserData(userStudent);
	                			
	                		}
	                		data  = registerCourseFasade.getByIdStudentandCourseId(userStudent.getId(),uploadedListOfGradesCourse.getId());
	                		if(data == null) {
	                			data =new courseReg();
	                			data.setStudentId(userStudent);
	                			data.setDate(Calendar.getInstance());
	                			data.setCourseId(uploadedListOfGradesCourse);
	                		}
	                		
	                	} catch (Exception ex) {
						}
	                	  break;
					
					case 4:
						try {
							data.setGrade(getTheValueFromCell(cell));
						} catch (Exception ex) {
						}
						  break;
					
                  }
					
						
			
					
				
			
				}
				String unique = UUID.randomUUID().toString();
				data.setCertDate(Calendar.getInstance());
				data.setCertID(unique);
				data.setState(courseReg.finished_the_Course);
				dataList.add(data);
			}
			input.close();
		
		return dataList;
		 
	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
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

	public loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<courseReg> getListOfCourseRegisterations() {
		return listOfCourseRegisterations;
	}

	public void setListOfCourseRegisterations(List<courseReg> listOfCourseRegisterations) {
		this.listOfCourseRegisterations = listOfCourseRegisterations;
	}

	public course getUploadedListOfGradesCourse() {
		return uploadedListOfGradesCourse;
	}

	public void setUploadedListOfGradesCourse(course uploadedListOfGradesCourse) {
		this.uploadedListOfGradesCourse = uploadedListOfGradesCourse;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public boolean isResultText() {
		return resultText;
	}

	public void setResultText(boolean resultText) {
		this.resultText = resultText;
	}
	public Integer getCourseIdSelected() {
		return courseIdSelected;
	}
	public void setCourseIdSelected(Integer courseIdSelected) {
		this.courseIdSelected = courseIdSelected;
	}
	

	
	
}
