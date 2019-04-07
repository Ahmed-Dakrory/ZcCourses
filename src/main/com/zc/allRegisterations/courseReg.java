package main.com.zc.allRegisterations;
/**
 * 
 */


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.zc.loginNeeds.UserData;
import main.com.zc.services.domain.courses.course;

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
	
	@ManyToOne
	@JoinColumn(name = "courseId")
	private course courseId;
	
	
	@ManyToOne
	@JoinColumn(name = "studentId")
	private UserData studentId;
	
	
	
	@Column(name = "date")
	private Calendar date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public course getCourseId() {
		return courseId;
	}

	public void setCourseId(course courseId) {
		this.courseId = courseId;
	}

	public UserData getStudentId() {
		return studentId;
	}

	public void setStudentId(UserData studentId) {
		this.studentId = studentId;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	
}
