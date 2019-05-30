package main.com.zc.tools;

import main.com.zc.allRegisterations.courseReg;
import main.com.zc.allRegisterations.courseRegDao;
import main.com.zc.loginNeeds.UserData;
import main.com.zc.loginNeeds.UserDataDao;
import main.com.zc.programs.ProgramDao;
import main.com.zc.programs.ProgramData;
import main.com.zc.services.domain.courses.CourseDao;
import main.com.zc.services.domain.courses.course;

public class ConverterToEntity {

	public static UserDataDao toDao(UserData userdata) {
		UserDataDao dao=new UserDataDao();
		dao.setActive(userdata.getActive());
		dao.setAge(userdata.getAge());
		dao.setEmail(userdata.getEmail());
		dao.setFaculty(userdata.getFaculty());
		dao.setFullName(userdata.getFullName());
		dao.setGender(userdata.getGender());
		dao.setGraduation_experiences(userdata.getGraduation_experiences());
		dao.setHomeGovernorate(userdata.getHomeGovernorate());
		dao.setId(userdata.getId());
		dao.setImage(userdata.getphoto());
		dao.setMajor(userdata.getMajor());
		dao.setMobile(userdata.getMobile());
		dao.setNationalId(userdata.getNationalId());
		dao.setPassword(userdata.getPassword());
		dao.setPrefix(userdata.getPrefix());
		dao.setResidenceGovernorate(userdata.getResidenceGovernorate());
		dao.setStudy_year(userdata.getStudy_year());
		dao.setUniversity(userdata.getUniversity());
		dao.setWhereYknowAboutUs(userdata.getWhereYknowAboutUs());
		dao.setWork(userdata.getWork());
		dao.setZewailianeOrNot(userdata.getZewailianeOrNot());
		return dao;
		
	}

	public static CourseDao toDao(course course) {
		CourseDao dao=new CourseDao();
		dao.setId(course.getId());
		dao.setCategories(course.getCategories());
		dao.setDescription(course.getDescription());	
		dao.setIdProgram(course.getIdProgram());
		dao.setImage(course.getImage());
		dao.setName(course.getName());
		dao.setPrice(course.getPrice());
		
		return dao;
	}

	public static ProgramDao toDao(ProgramData program) {
		ProgramDao dao=new ProgramDao();
		dao.setId(program.getId());
		dao.setDescription(program.getDescription());
		dao.setImage(program.getImg());
		dao.setName(program.getName());
		return dao;
	}
	
	public static courseRegDao toDao(courseReg courseReg) {
		courseRegDao dao=new courseRegDao();
		dao.setId(courseReg.getId());
		dao.setCourseId(courseReg.getCourseId().getId());
		dao.setDate(String.valueOf(courseReg.getDate().getTimeInMillis()));
		dao.setStudentId(courseReg.getStudentId().getId());
		return dao;
	}
}
