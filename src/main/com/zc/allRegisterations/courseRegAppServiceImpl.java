/**
 * 
 */
package main.com.zc.allRegisterations;





import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("courseRegFacadeImpl")
public class courseRegAppServiceImpl implements IcourseRegAppService{

	@Autowired
	courseRegRepository courseRegRepository;
	
	
	@Override
	public List<courseReg> getAll() {
		try{
			List<courseReg> course=courseRegRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	@Override
	public List<courseReg> getByIdCourse(int id) {
		try{
			List<courseReg> course=courseRegRepository.getByIdCourse(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public courseReg addcourseReg(courseReg so) {
		try{
			courseReg so2=courseRegRepository.addcourseReg(so);
			return so2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(courseReg so) {
		// TODO Auto-generated method stub
		try{
			courseRegRepository.delete(so);
			return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
	}

	@Override
	public courseReg getById(int id) {
		// TODO Auto-generated method stub
		try{
			courseReg so=courseRegRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<courseReg> getByIdStudent(int id) {
		try{
			List<courseReg> course=courseRegRepository.getByIdStudent(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public courseReg getByIdStudentandCourseId(int idstudent, int idcourse) {
		try{
			courseReg course=courseRegRepository.getByIdStudentandCourseId(idstudent, idcourse);				
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
}
		
		

	
		
	


