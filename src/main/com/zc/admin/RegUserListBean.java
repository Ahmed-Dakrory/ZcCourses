package main.com.zc.admin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.PrimeFaces;
import org.primefaces.model.UploadedFile;

import main.com.zc.loginNeeds.UserData;
import main.com.zc.loginNeeds.UserDataAppServiceImpl;


@SessionScoped
@ManagedBean(name="RegUserListBean")
public class RegUserListBean {
	
	private UploadedFile file;
	private String statusMessage;
	private boolean resultText;
	private List<UserData> list;

	@ManagedProperty(value = "#{UserDataFacadeImpl}")
	private UserDataAppServiceImpl userDataFacede; 
	
	@PostConstruct
	public void init()
	{
		list=new ArrayList<UserData>();
		resultText=false;
		/*filteredStudentCourseLst=new ArrayList<StudentCourseDTO>();
		selectedstudentCourseLst=new StudentCourseDTO();*/
		
	}
	public String parseFile()
	{
		 InputStream inputStream = null;
		 try {
			inputStream=file.getInputstream();
			list=parseUsersFile(inputStream);
			
			System.out.println("Size : "+list.size());
			resultText=true;
			//courses=facade.saveCourses(list);
			//System.out.println("Added Courses size is "+courses.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "";
	}

	
	public List<UserData> parseUsersFile(InputStream input) {
		List<UserData> dataList = new ArrayList<UserData>();
		try {
			//inputStream = resource.getInputStream();
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(input);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				UserData data=new UserData();
				
				int count = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					count++;
				
                  switch(count) {
	                case 1:
	                	try {
							data.setFullName(cell.getStringCellValue());
						} catch (Exception ex) {
						}
	                	  break;
	                	  
	                case 2:
	                	try {
							data.setEmail(cell.getStringCellValue());
						} catch (Exception ex) {
						}
	                	  break;
					case 3:
						try {
							String prefix=cell.getStringCellValue();
							System.out.println("Type: "+prefix);
							int g=0;
							if(prefix.equalsIgnoreCase("dr")) {
								g=3;
							}else if(prefix.equalsIgnoreCase("ms")){
								g=1;
							}else if(prefix.equalsIgnoreCase("eng")){
								g=2;
							}else if(prefix.equalsIgnoreCase("mr")){
								g=0;
							}else {
								g=4;
							}
							data.setPrefix(g);
						} catch (Exception ex) {
						}
						  break;
					case 4:
						try {
							data.setMobile(String.valueOf((int)cell.getNumericCellValue()));
						} catch (Exception ex) {
						}
						  break;
					case 5:
						try {
							data.setAge(String.valueOf((int)cell.getNumericCellValue()));
						} catch (Exception ex) {
						}
						  break;
					case 6:
						try {
							data.setNationalId(String.valueOf((int)cell.getNumericCellValue()));
						} catch (Exception ex) {
						}
						  break;
					case 7:
						try {
							data.setResidenceGovernorate(cell.getStringCellValue());
						} catch (Exception ex) {
						}
						  break;
					case 8:
						try {
							String gender=cell.getStringCellValue();
							int g=0;
							if(gender.equalsIgnoreCase("female")) {
								g=1;
							}else if(gender.equalsIgnoreCase("male")){
								g=0;
							}else {
								g=2;
							}
							data.setGender(g);
						} catch (Exception ex) {
						}
						  break;
					case 9:
						try {
							data.setHomeGovernorate(cell.getStringCellValue());
						} catch (Exception ex) {
						}
						  break;
						  
					case 10:
						try {
							String YN=cell.getStringCellValue();
							int yn=1;
							if(YN.equalsIgnoreCase("yes")) {
								yn=0;
							}else {
								yn=1;
							}
							data.setZewailianeOrNot(yn);
						} catch (Exception ex) {
						}
						  break;
					case 11:
						try {
							
							data.setUniversity(cell.getStringCellValue());
						} catch (Exception ex) {
						}
						  break;
					case 12:
						try {
							
							data.setFaculty(cell.getStringCellValue());
						} catch (Exception ex) {
						}
						  break;
					case 13:
						try {
							
							data.setMajor(cell.getStringCellValue());
						} catch (Exception ex) {
						}
						  break;
					case 14:
						try {
							int year = (int)cell.getNumericCellValue();
							data.setStudy_year(String.valueOf((year+1)));
						} catch (Exception ex) {
						}
						  break;
					case 15:
						try {
							data.setWork(cell.getStringCellValue());
						} catch (Exception ex) {
						}
						  break;
					
					case 16:
						try {
							data.setGraduation_experiences((int)cell.getNumericCellValue());
						} catch (Exception ex) {
						}
						  break;
					case 17:
						try {
							String where=cell.getStringCellValue();
							int g=0;
							if(where.equalsIgnoreCase("email")) {
								g=0;
							}else if(where.equalsIgnoreCase("facebook")) {
								g=1;
							}else if(where.equalsIgnoreCase("linkedin")) {
								g=2;
							}else if(where.equalsIgnoreCase("friends")) {
								g=3;
							}else if(where.equalsIgnoreCase("newsletter")) {
								g=4;
							}else {
								g=5;
							}
							data.setWhereYknowAboutUs(g);
						} catch (Exception ex) {
						}
						  break;
						
                  }
					
						
			
					
				
			
				}
				data.setActive(1);
				data.setPassword(data.getEmail());
				dataList.add(data);
			}
			input.close();
		 dataList.remove(0);
		
		return dataList;
		 
	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveCourse()
	{
		for(int i=0;i<list.size();i++) {
			userDataFacede.addUserData(list.get(i));
		}
		if(list.size()!=0)
		{

			 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", list.size()+" user(s) has(have) been saved Successfully");
	         
		        PrimeFaces.current().dialog().showMessageDynamic(message);
				System.out.println("Added List size is "+list.size());

				list=new ArrayList<UserData>();
		}
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


	public List<UserData> getList() {
		return list;
	}


	public void setList(List<UserData> list) {
		this.list = list;
	}


	public UserDataAppServiceImpl getUserDataFacede() {
		return userDataFacede;
	}


	public void setUserDataFacede(UserDataAppServiceImpl userDataFacede) {
		this.userDataFacede = userDataFacede;
	}


	
}
