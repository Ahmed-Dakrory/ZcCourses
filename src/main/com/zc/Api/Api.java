package main.com.zc.Api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import flexjson.JSONSerializer;
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
    public ResponseEntity<String> getUserData(@RequestParam(value="id",required=false) Integer id) {
    	if(id==null) {
    		
        	return null;
    	}
    	
    	UserData userdata=userFacade.getById(Integer.parseInt(String.valueOf(id)));
    	UserDataDao userDao=ConverterToEntity.toDao(userdata);
    	JSONSerializer serializeJson=new JSONSerializer();
    	
    	return new ResponseEntity<>(serializeJson.serialize(userDao), HttpStatus.CREATED); 
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

	
    
}