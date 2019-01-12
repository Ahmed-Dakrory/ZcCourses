package main.com.zc.Api;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import main.com.zc.allRegisterations.courseReg;
import main.com.zc.allRegisterations.courseRegAppServiceImpl;
import main.com.zc.allRegisterations.courseRegDao;
@RestController
@RequestMapping("/")
public class Api {
 

	@Inject
	private courseRegAppServiceImpl courseFacade;
	
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
    
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public ResponseEntity<String> getLogout2(@RequestParam(value="id",required=false) Integer id) {
    	if(id==null) {

        	return new ResponseEntity<>(" ", HttpStatus.OK);
    	}
    	courseReg dao=courseFacade.getById(Integer.parseInt(String.valueOf(id)));
    	courseRegDao dataNew=new courseRegDao();
    	dataNew.setId(dao.getId());
    	dataNew.setCourseId(dao.getCourseId());
    	dataNew.setStudentId(dao.getStudentId());
    	dataNew.setDate(String.valueOf(dao.getDate().getTimeInMillis()));
    	return new ResponseEntity<>(toJson(dataNew), HttpStatus.CREATED); 
    }

	public courseRegAppServiceImpl getCourseFacade() {
		return courseFacade;
	}

	public void setCourseFacade(courseRegAppServiceImpl courseFacade) {
		this.courseFacade = courseFacade;
	}

	public String toJson(courseRegDao bean) { 
		  return new JSONSerializer().transform(new DateTransformer("MM/dd/yyyy HH:mm:ss"),java.util.Date.class).serialize(bean);
		    }
    
    
}