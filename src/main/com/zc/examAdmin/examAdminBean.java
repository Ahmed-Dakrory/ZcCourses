package main.com.zc.examAdmin;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.com.zc.examChooseAnswers.examAnswersChoose;
import main.com.zc.examChooseAnswers.examAnswersChooseAppServiceImpl;



@ManagedBean(name = "examAdminBean")
@SessionScoped
public class examAdminBean implements Serializable {

	
	



	
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5520992390538471046L;

	
	@ManagedProperty(value = "#{examAnswersChooseFacadeImpl}")
	private examAnswersChooseAppServiceImpl ansFacede;
	
	
	private List<examAnswersChoose> listOfAnswersForExam;
	
	private List<examAnswersChoose> studentsWhoTakeTheExams;
	

	
	private int examNum;
	

	private List<examAnswersChoose> listOfChooseAnswers;
	private List<examAnswersChoose> listOfListAnswers1;
	private List<examAnswersChoose> listOfListAnswers2;
	private List<examAnswersChoose> listOfReadAnswers1;
	private List<examAnswersChoose> listOfReadAnswers2;
	private List<examAnswersChoose> listOfWritingAnswers;
	private List<examAnswersChoose> listOfSpeakingAnswers;


	private int totalChooseGrade;
	private int totalListGrade;
	private int totalReadGrade;
	private int totalWritingGrade;
	private int totalSpeakingGrade;
	
	
	private int selectedStudentId;
	
	@PostConstruct
	public void init() {
		
		
		
	}
	
	public void refreshPage(){
		
		examNum=1;
		
		
		
		studentsWhoTakeTheExams=ansFacede.getAllStudents(examNum);
		
		
		
		
	}
	
	
	public void openStudentCorrectionPage(int studentId) {
		selectedStudentId=studentId;
		listOfAnswersForExam=ansFacede.getAllstudentAnswerForExam(selectedStudentId, examNum);
		
		fillTheStudentAnsLists();
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/ZcCourses/pages/secured/admin/exam/examStudentGradeModify.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillTheStudentAnsLists() {
		// TODO Auto-generated method stub
		listOfChooseAnswers=ansFacede.getAllstudentAnswerForExamForChooseId(selectedStudentId, examNum, 1);
		listOfListAnswers1=ansFacede.getAllstudentAnswerForExamForListeningId(selectedStudentId, examNum, 1);
		listOfListAnswers2=ansFacede.getAllstudentAnswerForExamForListeningId(selectedStudentId, examNum, 2);
		listOfReadAnswers1=ansFacede.getAllstudentAnswerForExamForReadingId(selectedStudentId, examNum, 1);
		listOfReadAnswers2=ansFacede.getAllstudentAnswerForExamForReadingId(selectedStudentId, examNum, 2);
		listOfWritingAnswers=ansFacede.getAllstudentAnswerForExamForWritingId(selectedStudentId, examNum, 1);
		listOfSpeakingAnswers=ansFacede.getAllstudentAnswerForExamForSpeakingId(selectedStudentId, examNum, 1);
		
		getTheTotalGradesForEachPart();
	}

	private void getTheTotalGradesForEachPart() {
		// TODO Auto-generated method stub
		for(int i=0;i<listOfChooseAnswers.size();i++) {
			totalChooseGrade+=listOfChooseAnswers.get(i).getGrade();
		}
		
		for(int i=0;i<listOfListAnswers1.size();i++) {
			totalListGrade+=listOfListAnswers1.get(i).getGrade();
		}
		
		for(int i=0;i<listOfListAnswers2.size();i++) {
			totalListGrade+=listOfListAnswers2.get(i).getGrade();
		}
		
		for(int i=0;i<listOfReadAnswers1.size();i++) {
			totalReadGrade+=listOfReadAnswers1.get(i).getGrade();
		}
		
		for(int i=0;i<listOfReadAnswers2.size();i++) {
			totalReadGrade+=listOfReadAnswers2.get(i).getGrade();
		}
		
		if(listOfWritingAnswers.get(0).getGrade()!=null) {
			totalWritingGrade=listOfWritingAnswers.get(0).getGrade();
		}
		
		if(listOfSpeakingAnswers.get(0).getGrade()!=null) {
			totalSpeakingGrade=listOfSpeakingAnswers.get(0).getGrade();
		}
	}

	public examAnswersChooseAppServiceImpl getAnsFacede() {
		return ansFacede;
	}

	public void setAnsFacede(examAnswersChooseAppServiceImpl ansFacede) {
		this.ansFacede = ansFacede;
	}

	public List<examAnswersChoose> getListOfAnswersForExam() {
		return listOfAnswersForExam;
	}

	public void setListOfAnswersForExam(List<examAnswersChoose> listOfAnswersForExam) {
		this.listOfAnswersForExam = listOfAnswersForExam;
	}

	public List<examAnswersChoose> getStudentsWhoTakeTheExams() {
		return studentsWhoTakeTheExams;
	}

	public void setStudentsWhoTakeTheExams(List<examAnswersChoose> studentsWhoTakeTheExams) {
		this.studentsWhoTakeTheExams = studentsWhoTakeTheExams;
	}

	public int getExamNum() {
		return examNum;
	}

	public void setExamNum(int examNum) {
		this.examNum = examNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSelectedStudentId() {
		return selectedStudentId;
	}

	public void setSelectedStudentId(int selectedStudentId) {
		this.selectedStudentId = selectedStudentId;
	}

	public List<examAnswersChoose> getListOfChooseAnswers() {
		return listOfChooseAnswers;
	}

	public void setListOfChooseAnswers(List<examAnswersChoose> listOfChooseAnswers) {
		this.listOfChooseAnswers = listOfChooseAnswers;
	}

	public List<examAnswersChoose> getListOfListAnswers1() {
		return listOfListAnswers1;
	}

	public void setListOfListAnswers1(List<examAnswersChoose> listOfListAnswers1) {
		this.listOfListAnswers1 = listOfListAnswers1;
	}

	public List<examAnswersChoose> getListOfListAnswers2() {
		return listOfListAnswers2;
	}

	public void setListOfListAnswers2(List<examAnswersChoose> listOfListAnswers2) {
		this.listOfListAnswers2 = listOfListAnswers2;
	}

	public List<examAnswersChoose> getListOfReadAnswers1() {
		return listOfReadAnswers1;
	}

	public void setListOfReadAnswers1(List<examAnswersChoose> listOfReadAnswers1) {
		this.listOfReadAnswers1 = listOfReadAnswers1;
	}

	public List<examAnswersChoose> getListOfReadAnswers2() {
		return listOfReadAnswers2;
	}

	public void setListOfReadAnswers2(List<examAnswersChoose> listOfReadAnswers2) {
		this.listOfReadAnswers2 = listOfReadAnswers2;
	}

	public List<examAnswersChoose> getListOfWritingAnswers() {
		return listOfWritingAnswers;
	}

	public void setListOfWritingAnswers(List<examAnswersChoose> listOfWritingAnswers) {
		this.listOfWritingAnswers = listOfWritingAnswers;
	}

	public List<examAnswersChoose> getListOfSpeakingAnswers() {
		return listOfSpeakingAnswers;
	}

	public void setListOfSpeakingAnswers(List<examAnswersChoose> listOfSpeakingAnswers) {
		this.listOfSpeakingAnswers = listOfSpeakingAnswers;
	}

	public int getTotalChooseGrade() {
		return totalChooseGrade;
	}

	public void setTotalChooseGrade(int totalChooseGrade) {
		this.totalChooseGrade = totalChooseGrade;
	}

	public int getTotalListGrade() {
		return totalListGrade;
	}

	public void setTotalListGrade(int totalListGrade) {
		this.totalListGrade = totalListGrade;
	}

	public int getTotalReadGrade() {
		return totalReadGrade;
	}

	public void setTotalReadGrade(int totalReadGrade) {
		this.totalReadGrade = totalReadGrade;
	}

	public int getTotalWritingGrade() {
		return totalWritingGrade;
	}

	public void setTotalWritingGrade(int totalWritingGrade) {
		this.totalWritingGrade = totalWritingGrade;
	}

	public int getTotalSpeakingGrade() {
		return totalSpeakingGrade;
	}

	public void setTotalSpeakingGrade(int totalSpeakingGrade) {
		this.totalSpeakingGrade = totalSpeakingGrade;
	}

	
	
	
	
	
	
}
