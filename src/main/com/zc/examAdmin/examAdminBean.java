package main.com.zc.examAdmin;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import main.com.zc.examChooseAnswers.examAnswersChoose;
import main.com.zc.examChooseAnswers.examAnswersChooseAppServiceImpl;
import main.com.zc.loginNeeds.UserData;



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
	private String selectedStudentParagraphQues;
	private String selectedStudentParagraphAns;
	private String selectedStudentLink;
	private UserData selectedStudent;

	
	private int theTotalForThisStudent;
	private int theTotalCorrect;
	
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
		selectedStudent=listOfAnswersForExam.get(0).getStudent();
		fillTheStudentAnsLists();
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/exam/examStudentGradeModify.xhtml");
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
		selectedStudentParagraphAns=listOfWritingAnswers.get(0).getWriting_ans();
		selectedStudentParagraphQues=listOfWritingAnswers.get(0).getQuestion().getQuestion();
		selectedStudentLink=listOfSpeakingAnswers.get(0).getWriting_ans();
		getTheTotalGradesForEachPart();
	}

	public void submitAndGoBack() {
		examAnswersChoose ansWriting=listOfWritingAnswers.get(0);
		ansWriting.setGrade(totalWritingGrade);
		ansFacede.addExamAnswersChoose(ansWriting);
		examAnswersChoose ansSpeaking=listOfSpeakingAnswers.get(0);
		ansSpeaking.setGrade(totalSpeakingGrade);
		ansFacede.addExamAnswersChoose(ansSpeaking);
		fillTheStudentAnsLists();
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/exam/examStudentsDetails.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sendEmailToTheStudent(selectedStudent,theTotalForThisStudent,theTotalCorrect);
		
	}
	private void sendEmailToTheStudent(UserData userdata, int theTotalForThisStudent2, int theTotalCorrect2) {
		// TODO Auto-generated method stub
		 String from = "learningtechnologies@zewailcity.edu.eg";
	        String pass = "learningtechnologies@zc";
	        String[] to = { userdata.getEmail() }; // list of recipient email addresses
	        String subject = "English Exam Grade";
	        String htmlText = "<div style=width:700px;margin:0 auto;font:normal 13px/30px Segoe, Segoe UI, DejaVu Sans, Trebuchet MS, Verdana, sans-serif !important;>"
					+ "<ul style=margin:0;padding:0;>"
					+ "<li style=list-style:none;float:left;width:700px;margin:0;>"
					+ "	<ul style=margin:0;padding:0;width:700px;margin-top:18px;>"
					+ "<li style=list-style:none;float:left;width:260px;padding:0;><img src=\"http://outreach.zclt.info/javax.faces.resource/images/logoZc.png.xhtml\" style=\"width: 15%;\" alt=Zewail City of Science and Technology /></li>"
					+ "</ul>"
					+ "</li>"
					+ "<li style=list-style:none;float:left;width:700px;background:#f1f2f2;margin:15px 0 24px 0;padding:1px 0;>&nbsp;</li>"
					+ "<li style=list-style:none;float:left;width:700px;margin-bottom:24px;padding-left:24px;>"
					+ "<h2 style=margin:0;padding:0;color:#404040 !important;>Outreach and Engagment</h2>"
					+ "</li>"
					+ "<li style=list-style:none;float:left;width:700px;marin:0;background:#f2f0f0;>"
					+ "<div style=padding:24px 36px;color:#676767 !important;>"
					+ "<span style=color:#676767>Dear "
					+ userdata.getFullName()
					+ ",</span><br/><br/><br/>"
					+ "<span style=color:#676767>This is your grade in the English Exam "+theTotalForThisStudent2+" / "+theTotalCorrect2+"</span><br/><br/><br/>"
					+ "</span><br/><br/>"
					+ "<span style=color:#676767>Thank you, </span><br/><br/>"
					+ "<span style=color:#676767>Outreach and Engagment</span>"
					+ "</div>"
					+ "</li>"
					+ "<li style=list-style:none;float:left;width:700px;margin-bottom:4px;background:#ececec;>"
					+ "<ul style=margin:0;padding:0;>"
					+ "<li style=list-style:none;float:left;width:134px;margin:0;padding:18px 36px !important;color:#717070;>"
					+ "<a href=http://outreach.zclt.info title=Center for Learning Technologies><img src=\"http://outreach.zclt.info/javax.faces.resource/images/logoZc.png.xhtml\" style=\"width: 15%;\" alt=Center for Learning Technologies /></a><br/>"
					+ "<span style=color:#404040;font-size:11px;>Giving Fuel to Innovation</span>"
					+ "</li>"
					+ "<li style=list-style:none;float:right;width:59px;margin:0;padding:18px 36px !important;color:#717070;>"
					+ "<a href=http://outreach.zclt.info title=Zewail City of Science and Technology><img src=\"http://outreach.zclt.info/javax.faces.resource/images/logoZc.png.xhtml\" style=\"width: 15%;\" alt=Zewail City of Science and Technology /></a>"
					+ "</li>"
					+ "</ul>"
					+ "</li>"
					+ "<li style=list-style:none;float:left;width:700px;margin-bottom:12px;background:#ececec;>"
					+ "<div style=padding:8px 16px;color:#a1a0a0;font-size:11px;line-height:20px;>"
					+ " <br/><b><span style=color:#a1a0a0;font-size:11px;>Follow us:</sapn></b><a href=https://www.facebook.com/learning.technologies.zewailcity title=ZC LT Facebook><img src=\"http://zclt.info/ZCTestMail/facebook_square.png\"  alt=ZC LT Facebook style=vertical-align:middle;/></a>"
					+ "  <a href=https://www.youtube.com/channel/UCiajXXIv0rCpxVIgCDekm2A title=ZC LT Youtube><img src=\"http://zclt.info/ZCTestMail/youtube_square.png\"   alt=ZC LT Youtube style=vertical-align:middle;/></a>"
					+ "</div>" + "</li>" + "</ul>" + "</div>";

	        sendFromGMail(from, pass, to, subject, htmlText);
	        
	}

	 private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);

	    		message.setContent(body, "text/html; charset=ISO-8859-1");
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	    }
	 
	private void getTheTotalGradesForEachPart() {
		// TODO Auto-generated method stub
		totalChooseGrade=0;
		totalListGrade=0;
		totalReadGrade=0;
		totalWritingGrade=0;
		totalSpeakingGrade=0;
		
		
		theTotalForThisStudent=0;
		theTotalCorrect=0;
		
		for(int i=0;i<listOfChooseAnswers.size();i++) {
			totalChooseGrade+=listOfChooseAnswers.get(i).getGrade();
			theTotalCorrect+=1;
		}
		theTotalForThisStudent+=totalChooseGrade;
		
		
		
		
		
		
		
		
		for(int i=0;i<listOfListAnswers1.size();i++) {
			totalListGrade+=listOfListAnswers1.get(i).getGrade();
			theTotalCorrect+=1;
		}
		
		for(int i=0;i<listOfListAnswers2.size();i++) {
			totalListGrade+=listOfListAnswers2.get(i).getGrade();
			theTotalCorrect+=1;
		}
		theTotalForThisStudent+=totalListGrade;
		
		
		
		
		
		for(int i=0;i<listOfReadAnswers1.size();i++) {
			totalReadGrade+=listOfReadAnswers1.get(i).getGrade();
			theTotalCorrect+=1;
		}
		
		for(int i=0;i<listOfReadAnswers2.size();i++) {
			totalReadGrade+=listOfReadAnswers2.get(i).getGrade();
			theTotalCorrect+=1;
		}
		theTotalForThisStudent+=totalReadGrade;
		
		
		
		
		
		if(listOfWritingAnswers.get(0).getGrade()!=null) {
			totalWritingGrade=listOfWritingAnswers.get(0).getGrade();
			theTotalCorrect+=10;
		}
		theTotalForThisStudent+=totalWritingGrade;
		
		if(listOfSpeakingAnswers.get(0).getGrade()!=null) {
			totalSpeakingGrade=listOfSpeakingAnswers.get(0).getGrade();
			theTotalCorrect+=10;
		}
		theTotalForThisStudent+=totalSpeakingGrade;
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

	public String getSelectedStudentParagraphQues() {
		return selectedStudentParagraphQues;
	}

	public void setSelectedStudentParagraphQues(String selectedStudentParagraphQues) {
		this.selectedStudentParagraphQues = selectedStudentParagraphQues;
	}

	public String getSelectedStudentParagraphAns() {
		return selectedStudentParagraphAns;
	}

	public void setSelectedStudentParagraphAns(String selectedStudentParagraphAns) {
		this.selectedStudentParagraphAns = selectedStudentParagraphAns;
	}

	public String getSelectedStudentLink() {
		return selectedStudentLink;
	}

	public void setSelectedStudentLink(String selectedStudentLink) {
		this.selectedStudentLink = selectedStudentLink;
	}

	public UserData getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(UserData selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public int getTheTotalForThisStudent() {
		return theTotalForThisStudent;
	}

	public void setTheTotalForThisStudent(int theTotalForThisStudent) {
		this.theTotalForThisStudent = theTotalForThisStudent;
	}

	public int getTheTotalCorrect() {
		return theTotalCorrect;
	}

	public void setTheTotalCorrect(int theTotalCorrect) {
		this.theTotalCorrect = theTotalCorrect;
	}

	
	
	
	
	
	
}
