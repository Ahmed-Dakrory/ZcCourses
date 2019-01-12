package main.com.zc.allRegisterations;
/**
 * 
 */


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * @author dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="courseReg.getAll",
		     query="SELECT c FROM courseReg c"
		     )
	,
	@NamedQuery(name="courseReg.getById",
	query = "from courseReg d where d.id = :id"
			)
	,
	@NamedQuery(name="courseReg.getBystudentId",
	query = "from courseReg d where d.studentId = :studentId"
			)
	,
	@NamedQuery(name="courseReg.getBycourseId",
	query = "from courseReg d where d.courseId = :courseId"
			)
	
	,
	@NamedQuery(name="courseReg.getBystudentAndCourseId",
	query = "from courseReg d where d.studentId = :studentId and d.courseId = :courseId"
			)
	
})

@Entity
@Table(name = "coursereg")
public class courseReg {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "courseId")
	private Integer courseId;
	
	@Column(name = "studentId")
	private Integer studentId;
	
	@Column(name = "date")
	private Calendar date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	
}
