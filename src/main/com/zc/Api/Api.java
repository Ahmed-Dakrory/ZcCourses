package main.com.zc.Api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import flexjson.JSONSerializer;
import main.com.zc.allRegisterations.courseReg;
import main.com.zc.allRegisterations.courseRegAppServiceImpl;
import main.com.zc.allRegisterations.courseRegDao;
import main.com.zc.loginNeeds.UserData;
import main.com.zc.loginNeeds.UserDataAppServiceImpl;
import main.com.zc.loginNeeds.UserDataDao;
import main.com.zc.programs.ProgramDao;
import main.com.zc.programs.ProgramData;
import main.com.zc.programs.ProgramDataAppServiceImpl;
import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.CourseDao;
import main.com.zc.services.domain.courses.course;
import main.com.zc.tools.ConverterToEntity;
@RestController
@RequestMapping("/Api")
public class Api {
 

	@Inject
	private CourseAppServiceImpl courseFacade;
	

	@Inject
	private UserDataAppServiceImpl userFacade;
	

	@Inject
	private ProgramDataAppServiceImpl programFacade;
	
	@Inject
	private courseRegAppServiceImpl courseRegFacade;
	
    @RequestMapping(value = "/")
    public ResponseEntity<String> getLogin() {
      return new ResponseEntity<>("",HttpStatus.OK);
    }
 
    @RequestMapping(value = "/dologout")
    public ResponseEntity<String> getLogout1(@RequestParam(value="name",required = false)  String name) {
    	if(name==null) {

        	return new ResponseEntity<>(" ", HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<>(" Hi : "+name, HttpStatus.OK);
		
		
    }
    
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public ResponseEntity<String> getLogout(@RequestParam(value="name",required = false)  String name) {
    	if(name==null) {

        	return new ResponseEntity<>(" ", HttpStatus.OK);
    	}
    	return new ResponseEntity<>(" Hi : "+name, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/course",method = RequestMethod.POST)
    public ResponseEntity<String> getCourse(@RequestParam(value="id",required=false) Integer id) {
    	if(id==null) {

        	return new ResponseEntity<>(" ", HttpStatus.OK);
    	}
    	course course=courseFacade.getById(Integer.parseInt(String.valueOf(id)));
    	if(course==null) {

        	return new ResponseEntity<>(" ", HttpStatus.BAD_REQUEST);
    	}
    	CourseDao courseDao=ConverterToEntity.toDao(course);
    	JSONSerializer serializeJson=new JSONSerializer();
    	
    	return new ResponseEntity<>(serializeJson.serialize(courseDao), HttpStatus.CREATED); 
    }
    
    @RequestMapping(value = "/program",method = RequestMethod.POST)
    public ResponseEntity<String> getProgram(@RequestParam(value="id",required=false) Integer id) {
    	if(id==null) {

        	return new ResponseEntity<>(" ", HttpStatus.OK);
    	}
    	ProgramData program=programFacade.getById(Integer.parseInt(String.valueOf(id)));
    	if(program==null) {

        	return new ResponseEntity<>(" ", HttpStatus.BAD_REQUEST);
    	}
    	ProgramDao programDao=ConverterToEntity.toDao(program);
    	JSONSerializer serializeJson=new JSONSerializer();
    	
    	return new ResponseEntity<>(serializeJson.serialize(programDao), HttpStatus.CREATED); 
    }
    
    @RequestMapping(value = "/coursesbyProgramId",method = RequestMethod.POST)
    public ResponseEntity<String> getCourseByProgramId(@RequestParam(value="id",required=false) Integer id) {
    	if(id==null) {

        	return new ResponseEntity<>(" ", HttpStatus.OK);
    	}
    	List<course> courses=courseFacade.getByIdCourse(Integer.parseInt(String.valueOf(id)));
    	if(courses==null) {

        	return new ResponseEntity<>(" ", HttpStatus.BAD_REQUEST);
    	}
    	List<CourseDao> coursesDao=new ArrayList<CourseDao>();
    	for(int i=0;i<courses.size();i++) {

        	CourseDao courseDao=ConverterToEntity.toDao(courses.get(i));
        	coursesDao.add(courseDao);
        	
    	}
    	JSONSerializer serializeJson=new JSONSerializer();
    	
    	return new ResponseEntity<>(serializeJson.serialize(coursesDao), HttpStatus.CREATED); 
    }
    
    @RequestMapping(value = "/programs",method = RequestMethod.GET)
    public ResponseEntity<String> getPrograms() {
    	
    	List<ProgramData> programs=programFacade.getAll();
    	if(programs==null) {

        	return new ResponseEntity<>(" ", HttpStatus.BAD_REQUEST);
    	}
    	List<ProgramDao> programsDao=new ArrayList<ProgramDao>();
    	for(int i=0;i<programs.size();i++) {

    		ProgramDao dao=ConverterToEntity.toDao(programs.get(i));
        	programsDao.add(dao);
        	
    	}
    	
    	JSONSerializer serializeJson=new JSONSerializer();
    	
    	return new ResponseEntity<>(serializeJson.serialize(programsDao), HttpStatus.CREATED); 
    }
    
    @RequestMapping(value = "/userData",method = RequestMethod.POST)
    public ResponseEntity<String> getUserData(@RequestParam(value="email",required=false) String email,@RequestParam(value="password",required=false) String password) {
    	if(email==null||password==null) {
    		
        	return null;
    	}
    	
    	UserData userdata=userFacade.getByEmailAndPassword(email, password);
    	UserDataDao userDao=ConverterToEntity.toDao(userdata);
    	JSONSerializer serializeJson=new JSONSerializer();
    	
    	return new ResponseEntity<>(serializeJson.serialize(userDao), HttpStatus.CREATED); 
    }
    
    @RequestMapping(value = "/setcourseRegData",method = RequestMethod.POST)
    public ResponseEntity<String> setUserDataOfThisCourse(@RequestParam(value="idUser",required=false) Integer id,@RequestParam(value="idCourse",required=false) Integer idCourse) {
    	if(id==null||idCourse==null) {
    		
        	return null;
    	}
    	courseReg courseReg=new courseReg();
    	courseReg.setCourseId(idCourse);
    	courseReg.setDate(Calendar.getInstance());
    	courseReg.setStudentId(id);

    	courseRegFacade.addcourseReg(courseReg);
    	
    	return new ResponseEntity<>("{\"statue\":\"Ok\"}", HttpStatus.CREATED); 
    }
    
    @RequestMapping(value = "/courseRegData",method = RequestMethod.POST)
    public ResponseEntity<String> getUserDataOfThisCourse(@RequestParam(value="idUser",required=false) Integer id,@RequestParam(value="idCourse",required=false) Integer idCourse) {
    	if(id==null||idCourse==null) {
    		
        	return null;
    	}
    	courseReg courseReg=new courseReg();

    	courseReg=courseRegFacade.getByIdStudentandCourseId(id, idCourse);

    	courseRegDao courseRegDao=ConverterToEntity.toDao(courseReg);
    	JSONSerializer serializeJson=new JSONSerializer();
    	return new ResponseEntity<>(serializeJson.serialize(courseRegDao), HttpStatus.CREATED); 
    }

    
	public CourseAppServiceImpl getCourseFacade() {
		return courseFacade;
	}

	public void setCourseFacade(CourseAppServiceImpl courseFacade) {
		this.courseFacade = courseFacade;
	}

	
	public UserDataAppServiceImpl getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserDataAppServiceImpl userFacade) {
		this.userFacade = userFacade;
	}

	public ProgramDataAppServiceImpl getProgramFacade() {
		return programFacade;
	}

	public void setProgramFacade(ProgramDataAppServiceImpl programFacade) {
		this.programFacade = programFacade;
	}

	public courseRegAppServiceImpl getCourseRegFacade() {
		return courseRegFacade;
	}

	public void setCourseRegFacade(courseRegAppServiceImpl courseRegFacade) {
		this.courseRegFacade = courseRegFacade;
	}

	
    
}