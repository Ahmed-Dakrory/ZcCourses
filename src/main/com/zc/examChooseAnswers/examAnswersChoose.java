package main.com.zc.examChooseAnswers;
/**
 * 
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.zc.examChooseQuestions.examQuestionChoose;
import main.com.zc.loginNeeds.UserData;

/**
 * @author dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="examAnswersChoose.getAll",
		     query="SELECT c FROM examAnswersChoose c"
		     )
	,
	@NamedQuery(name="examAnswersChoose.getById",
	query = "from examAnswersChoose d where d.id = :id"
			)
	,
	@NamedQuery(name="examAnswersChoose.getAllstudentAnswers",
	query = "from examAnswersChoose d where d.student.id = :id_Student"
			)
	,
	
	@NamedQuery(name="examAnswersChoose.getAllstudentAnswerForExam",
	query = "from examAnswersChoose d where d.student.id = :id_Student and d.question.examNumb = :examNum"
			)
	,
	@NamedQuery(name="examAnswersChoose.getstudentAnswerForExamWithQuestionId",
	query = "from examAnswersChoose d where d.student.id = :id_Student and d.question.id = :questionId"
			)
	
})

@Entity
@Table(name = "exam_ans_choose")
public class examAnswersChoose {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_Student")
	private UserData student;
	
	@ManyToOne
	@JoinColumn(name = "questionId")
	private examQuestionChoose question;
	
	@Column(name = "grade")
	private Integer grade;
	
	
	@Column(name = "ans")
	private Integer ans;
	
	
	@Column(name = "writing_ans")
	private String writing_ans;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserData getStudent() {
		return student;
	}

	public void setStudent(UserData student) {
		this.student = student;
	}

	public examQuestionChoose getQuestion() {
		return question;
	}

	public void setQuestion(examQuestionChoose question) {
		this.question = question;
	}

	public Integer getAns() {
		return ans;
	}

	public void setAns(Integer ans) {
		this.ans = ans;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getWriting_ans() {
		return writing_ans;
	}

	public void setWriting_ans(String writing_ans) {
		this.writing_ans = writing_ans;
	}

	
	
	
}
