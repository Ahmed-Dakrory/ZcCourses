package main.com.zc.examChooseQuestions;
/**
 * 
 */


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
	
	
	@NamedQuery(name="examQuestionChoose.getAll",
		     query="SELECT c FROM examQuestionChoose c"
		     )
	,
	@NamedQuery(name="examQuestionChoose.getById",
	query = "from examQuestionChoose d where d.id = :id"
			)
	,
	@NamedQuery(name="examQuestionChoose.getAllExamQuestion",
	query = "from examQuestionChoose d where d.examNumb = :examNumb"
			)
	,
	
	@NamedQuery(name="examQuestionChoose.getAllChooseSecNumb",
	query = "from examQuestionChoose d where d.examNumb = :examNumb and d.id_choose = :id_choose"
			)
	
	,
	@NamedQuery(name="examQuestionChoose.getAllListeningSecNumb",
	query = "from examQuestionChoose d where d.examNumb = :examNumb and d.id_listening = :id_listening"
			)
	
	,
	@NamedQuery(name="examQuestionChoose.getAllReadSecNumb",
	query = "from examQuestionChoose d where d.examNumb = :examNumb and d.id_reading = :id_reading"
			)
	
	,
	@NamedQuery(name="examQuestionChoose.getAllWritingSecNumb",
	query = "from examQuestionChoose d where d.examNumb = :examNumb and d.id_writing = :id_writing"
			)
	,
	@NamedQuery(name="examQuestionChoose.getAllSpeakingSecNumb",
	query = "from examQuestionChoose d where d.examNumb = :examNumb and d.id_speaking = :id_speaking"
			)
	
	
})

@Entity
@Table(name = "exam_questions_choose")
public class examQuestionChoose {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "examNumb")
	private Integer examNumb;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "ans1")
	private String ans1;
	
	@Column(name = "ans2")
	private String ans2;
	
	@Column(name = "ans3")
	private String ans3;
	
	
	@Column(name = "exact_ans")
	private Integer exact_ans;
	
	@Column(name = "id_reading")
	private Integer id_reading;
	
	@Column(name = "id_listening")
	private Integer id_listening;
	
	@Column(name = "id_choose")
	private Integer id_choose;
	
	
	@Column(name = "id_writing")
	private Integer id_writing;
	
	@Column(name = "id_speaking")
	private Integer id_speaking;

	@Column(name = "reading_paragraph")
	private String reading_paragraph;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExamNumb() {
		return examNumb;
	}

	public void setExamNumb(Integer examNumb) {
		this.examNumb = examNumb;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public Integer getExact_ans() {
		return exact_ans;
	}

	public void setExact_ans(Integer exact_ans) {
		this.exact_ans = exact_ans;
	}

	public Integer getId_reading() {
		return id_reading;
	}

	public void setId_reading(Integer id_reading) {
		this.id_reading = id_reading;
	}

	public Integer getId_listening() {
		return id_listening;
	}

	public void setId_listening(Integer id_listening) {
		this.id_listening = id_listening;
	}

	
	public String getReading_paragraph() {
		return reading_paragraph;
	}

	public void setReading_paragraph(String reading_paragraph) {
		this.reading_paragraph = reading_paragraph;
	}

	public Integer getId_writing() {
		return id_writing;
	}

	public void setId_writing(Integer id_writing) {
		this.id_writing = id_writing;
	}

	public Integer getId_speaking() {
		return id_speaking;
	}

	public void setId_speaking(Integer id_speaking) {
		this.id_speaking = id_speaking;
	}

	public Integer getId_choose() {
		return id_choose;
	}

	public void setId_choose(Integer id_choose) {
		this.id_choose = id_choose;
	}
	
	
	
}
