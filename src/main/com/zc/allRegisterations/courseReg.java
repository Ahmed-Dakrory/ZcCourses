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

	/*
	 * 0 register but not pay the first fees
	 * 1 pay the first fees
	 * 2 pay the final fees
	 * 3 take the course and finish
	 * 4 cancel the enrollment
	 */
	@Column(name = "state")
	private Integer state;
	
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getTheStatuesOfForm() {
		String statueString="";
		
		switch(state) {
		case 0:
			statueString="Registered but not pay";
			break;
			
		case 1:
			statueString="Pay the deposite fees";
			break;
			
		case 2:
			statueString="Pay the total Fees";
			break;
			
		case 3:
			statueString="Take the course and finish it";
			break;
			
		case 4:
			statueString="Cancel the enrollment";
			break;
			
		default:
			statueString="Registered but not pay";
			break;
				
		}
		return statueString;
		
	}
	
}
