/**
 * 
 */
package main.com.zc.services.domain.courses;





import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("CourseFacadeImpl")
public class CourseAppServiceImpl implements IcourseAppService{

	@Autowired
	CourseRepository courseRepository;
	
	
	@Override
	public List<course> getAll() {
		try{
			List<course> course=courseRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	@Override
	public List<course> getByIdCourse(int id) {
		try{
			List<course> course=courseRepository.getByIdCourse(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public course addCourse(course so) {
		try{
			course so2=courseRepository.addCourse(so);
			return so2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(course so) {
		// TODO Auto-generated method stub
		try{
			courseRepository.delete(so);
			return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
	}

	@Override
	public course getById(int id) {
		// TODO Auto-generated method stub
		try{
			course so=courseRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
}
		
		

	
		
	


