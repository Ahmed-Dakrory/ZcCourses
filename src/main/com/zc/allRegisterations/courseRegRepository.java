/**
 * 
 */
package main.com.zc.allRegisterations;

import java.util.List;

/**
 * @author Dakrory
 *
 */
public interface courseRegRepository {

	public List<courseReg> getAll();
	public List<courseReg> getByIdCourse(int id);
	public List<courseReg> getByIdStudent(int id);
	public courseReg getByIdStudentandCourseId(int idstudent,int idcourse);
	public courseReg addcourseReg(courseReg clo);
	public courseReg getById(int id);
	public courseReg getByMerchantOrderId(String marchantId);
	public boolean delete(courseReg so);
}
