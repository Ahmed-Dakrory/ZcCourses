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
	@NamedQuery(name="courseReg.getByMerchantOrderId",
	query = "from courseReg d where d.merchant_Order_ID = :merchant_Order_ID"
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


	public static int Register_but_NotPay_the_Fees=0;
	public static int pay_the_First_Fees=1;
	public static int pay_the_Final_Fees=2;
	public static int Take_the_Course_And_Finish=3;
	public static int cancell_the_Enrollement=4;
	
	/*
	 * 0 register but not pay the first fees
	 * 1 pay the first fees
	 * 2 pay the final fees
	 * 3 take the course and finish
	 * 4 cancel the enrollment
	 */
	@Column(name = "state")
	private Integer state;
	
	@Column(name = "amount_cents")
	private Integer amount_cents;
	
	@Column(name = "merchant_Order_ID")
	private String merchant_Order_ID;
	
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
	
	
	
	public String getMerchant_Order_ID() {
		return merchant_Order_ID;
	}

	public void setMerchant_Order_ID(String merchant_Order_ID) {
		this.merchant_Order_ID = merchant_Order_ID;
	}

	public String getTheStatuesOfForm() {
		String statueString="";
		
		switch(state) {
		case 0:
			statueString="Registered but not pay";
			break;
			
		case 1:
			statueString="Payed the deposite fees";
			break;
			
		case 2:
			statueString="Payed the total Fees";
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

	public Integer getAmount_cents() {
		return amount_cents;
	}

	public void setAmount_cents(Integer amount_cents) {
		this.amount_cents = amount_cents;
	}
	
	
	
}
