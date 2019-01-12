/**
 * 
 */
package main.com.zc.services.domain.courses;

import java.util.List;

/**
 * @author Dakrory
 *
 */
public interface CourseRepository {

	public List<course> getAll();
	public List<course> getByIdCourse(int id);
	public course addCourse(course clo);
	public course getById(int id);
	public boolean delete(course so);
}
