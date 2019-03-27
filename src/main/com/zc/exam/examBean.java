package main.com.zc.exam;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.com.zc.examChooseAnswers.examAnswersChoose;
import main.com.zc.examChooseAnswers.examAnswersChooseAppServiceImpl;
import main.com.zc.examChooseQuestions.examQuestionChoose;
import main.com.zc.examChooseQuestions.examQuestionChooseAppServiceImpl;
import main.com.zc.loginNeeds.loginBean;



@ManagedBean(name = "examBean")
@SessionScoped
public class examBean implements Serializable {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7171882406959312752L;



	
	
	
	@ManagedProperty(value = "#{examQuestionChooseFacadeImpl}")
	private examQuestionChooseAppServiceImpl chooseQuesFacede;
	
	@ManagedProperty(value = "#{examAnswersChooseFacadeImpl}")
	private examAnswersChooseAppServiceImpl ansFacede;
	
	
	private List<examQuestionChoose> listOfChooseQuestions;
	private List<examQuestionChoose> listOfListQuestions1;
	private List<examQuestionChoose> listOfListQuestions2;
	private List<examQuestionChoose> listOfReadQuestions1;
	private List<examQuestionChoose> listOfReadQuestions2;
	private List<examQuestionChoose> listOfWritingQuestions;
	

	private List<examQuestionChoose> listOfSpeakingQuestions;
	
	

	private List<examAnswersChoose> listOfChooseAnswers;
	private List<examAnswersChoose> listOfListAnswers1;
	private List<examAnswersChoose> listOfListAnswers2;
	private List<examAnswersChoose> listOfReadAnswers1;
	private List<examAnswersChoose> listOfReadAnswers2;
	

	private List<examAnswersChoose> listOfWritingAnswers;
	

	private List<examAnswersChoose> listOfSpeakingAnswers;
	
	private int examNum;
	
	private int sizeOfChoose;
	
	private int sizeOfList1;
	private int sizeOfList2;
	
	private int sizeOfRead1;
	private int sizeOfRead2;
	
	

	private int sizeOfSpeaking;

	private String paragraph1;
	private String paragraph2;

	private int selectedParagraph;
	private String writingParagraphAns;
	private String speakingUrlAns;
	
	@ManagedProperty(value = "#{loginBean}")
	private loginBean loginBean;
	
	@PostConstruct
	public void init() {
		examNum=1;
		refreshPage();
		
	}
	
	public void refreshPage(){
		listOfChooseAnswers=new ArrayList<examAnswersChoose>();
		listOfListAnswers1=new ArrayList<examAnswersChoose>();
		listOfListAnswers2=new ArrayList<examAnswersChoose>();
		listOfReadAnswers1=new ArrayList<examAnswersChoose>();
		listOfReadAnswers2=new ArrayList<examAnswersChoose>();
		listOfWritingAnswers=new ArrayList<examAnswersChoose>();
		listOfSpeakingAnswers=new ArrayList<examAnswersChoose>();
		
		
		
		listOfChooseQuestions=chooseQuesFacede.getAllChooseSecNumb(examNum, 1);
		listOfListQuestions1=chooseQuesFacede.getAllListeningSecNumb(examNum, 1);
		listOfListQuestions2=chooseQuesFacede.getAllListeningSecNumb(examNum, 2);
		listOfReadQuestions1=chooseQuesFacede.getAllReadSecNumb(examNum, 1);
		listOfReadQuestions2=chooseQuesFacede.getAllReadSecNumb(examNum, 2);
		listOfWritingQuestions=chooseQuesFacede.getAllWritingSecNumb(examNum, 1);
		listOfSpeakingQuestions=chooseQuesFacede.getAllSpeakingSecNumb(examNum, 1);
		

		selectedParagraph=listOfWritingQuestions.get(0).getId();
		
		InitializeTheAnsList();

		paragraph1=listOfReadQuestions1.get(0).getReading_paragraph();
		paragraph2=listOfReadQuestions2.get(0).getReading_paragraph();
	}

	private void InitializeTheAnsList() {
		// TODO Auto-generated method stub
		sizeOfChoose=listOfChooseQuestions.size();
		sizeOfList1=listOfListQuestions1.size();
		sizeOfList2=listOfListQuestions2.size();
		sizeOfRead1=listOfReadQuestions1.size();
		sizeOfRead2=listOfReadQuestions2.size();
		

		sizeOfSpeaking=listOfSpeakingQuestions.size();
		
		
		
		for(int i=0;i<sizeOfChoose;i++) {
			examAnswersChoose ansChoose=new examAnswersChoose();
			ansChoose.setAns(1);
			ansChoose.setQuestion(listOfChooseQuestions.get(i));
			ansChoose.setStudent(loginBean.getTheUserOfThisAccount());
			listOfChooseAnswers.add(ansChoose);
		}

		
		for(int i=0;i<sizeOfList1;i++) {
			examAnswersChoose ansList1=new examAnswersChoose();
			ansList1.setAns(1);
			ansList1.setQuestion(listOfListQuestions1.get(i));
			ansList1.setStudent(loginBean.getTheUserOfThisAccount());
			listOfListAnswers1.add(ansList1);
		}
		
		for(int i=0;i<sizeOfList2;i++) {
			examAnswersChoose ansList2=new examAnswersChoose();
			ansList2.setAns(1);
			ansList2.setQuestion(listOfListQuestions2.get(i));
			ansList2.setStudent(loginBean.getTheUserOfThisAccount());
			listOfListAnswers2.add(ansList2);
		}
		
		for(int i=0;i<sizeOfRead1;i++) {
			examAnswersChoose ansRead1=new examAnswersChoose();
			ansRead1.setAns(1);
			ansRead1.setQuestion(listOfReadQuestions1.get(i));
			ansRead1.setStudent(loginBean.getTheUserOfThisAccount());
			listOfReadAnswers1.add(ansRead1);
		}
		
		for(int i=0;i<sizeOfRead2;i++) {
			examAnswersChoose ansRead2=new examAnswersChoose();
			ansRead2.setAns(1);
			ansRead2.setQuestion(listOfReadQuestions2.get(i));
			ansRead2.setStudent(loginBean.getTheUserOfThisAccount());
			listOfReadAnswers2.add(ansRead2);
		}
		
		
	
		
		
		for(int i=0;i<sizeOfSpeaking;i++) {
			examAnswersChoose ansSpeak=new examAnswersChoose();
			ansSpeak.setAns(1);
			ansSpeak.setQuestion(listOfSpeakingQuestions.get(i));
			ansSpeak.setStudent(loginBean.getTheUserOfThisAccount());
			listOfSpeakingAnswers.add(ansSpeak);
		}
		
	}

	public void submitChooseAndProceed() {
		//Grade the Choose list first
		grade(listOfChooseAnswers,listOfChooseQuestions);
		
		//Submit the list of chooses
		for(int i=0;i<listOfChooseAnswers.size();i++) {
			ansFacede.addExamAnswersChoose(listOfChooseAnswers.get(i));
		}
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/ZcCourses/pages/secured/user/exams/examListening.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void submitListAndProceed() {
		//Grade the Listening list first
				grade(listOfListAnswers1,listOfListQuestions1);
				grade(listOfListAnswers2,listOfListQuestions2);
					
				//Submit the list of listening
				for(int i=0;i<listOfListAnswers1.size();i++) {
					ansFacede.addExamAnswersChoose(listOfListAnswers1.get(i));
				}
				for(int i=0;i<listOfListAnswers2.size();i++) {
					ansFacede.addExamAnswersChoose(listOfListAnswers2.get(i));
				}
				
				try {
					FacesContext.getCurrentInstance()
					   .getExternalContext().redirect("/ZcCourses/pages/secured/user/exams/examReading.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		
	}
	
	public void submitReadAndProceed() {
		
		//Grade the Reading list first
		grade(listOfReadAnswers1,listOfReadQuestions1);
		grade(listOfReadAnswers2,listOfReadQuestions2);
				
		
		

		//Submit the list of Reading
		for(int i=0;i<listOfReadAnswers1.size();i++) {
			ansFacede.addExamAnswersChoose(listOfReadAnswers1.get(i));
		}
		for(int i=0;i<listOfReadAnswers2.size();i++) {
			ansFacede.addExamAnswersChoose(listOfReadAnswers2.get(i));
		}
		
					try {
						FacesContext.getCurrentInstance()
						   .getExternalContext().redirect("/ZcCourses/pages/secured/user/exams/examWriting.xhtml");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
			
		}
	
	public void submitWritingAndProceed() {
		
		//Submit the writing answer
				examAnswersChoose newansWriting = new examAnswersChoose();
				newansWriting.setWriting_ans(writingParagraphAns);
				newansWriting.setAns(1);
				newansWriting.setQuestion(chooseQuesFacede.getById(selectedParagraph));
				newansWriting.setStudent(loginBean.getTheUserOfThisAccount());
				ansFacede.addExamAnswersChoose(newansWriting);
				
		
					try {
						FacesContext.getCurrentInstance()
						   .getExternalContext().redirect("/ZcCourses/pages/secured/user/exams/examSpeaking.xhtml");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
			
		}
	
	public void endOfExam() {
		
		
		//Submit the speaking url 
		examAnswersChoose newansSpeaking = listOfSpeakingAnswers.get(0);
		newansSpeaking.setWriting_ans(speakingUrlAns);
		ansFacede.addExamAnswersChoose(newansSpeaking);
		
	}

	private void grade(List<examAnswersChoose> lcAns, List<examQuestionChoose> lcQues) {
		// TODO Auto-generated method stub
		for(int i=0;i<lcAns.size();i++) {
			if(lcAns.get(i).getAns()-lcQues.get(i).getExact_ans()==0) {
				examAnswersChoose newOne=new examAnswersChoose();
				newOne=lcAns.get(i);
				newOne.setGrade(1);
				lcAns.set(i, newOne);
			}else {
				examAnswersChoose newOne=new examAnswersChoose();
				newOne=lcAns.get(i);
				newOne.setGrade(0);
				lcAns.set(i, newOne);
			}
		}
	}

	/*
	 * @A7med Dakrory
	 * StartGetter and Setter
	 */

	
	
	
	public examQuestionChooseAppServiceImpl getChooseQuesFacede() {
		return chooseQuesFacede;
	}

	public void setChooseQuesFacede(examQuestionChooseAppServiceImpl chooseQuesFacede) {
		this.chooseQuesFacede = chooseQuesFacede;
	}

	

	public List<examQuestionChoose> getListOfListQuestions1() {
		return listOfListQuestions1;
	}

	public void setListOfListQuestions1(List<examQuestionChoose> listOfListQuestions1) {
		this.listOfListQuestions1 = listOfListQuestions1;
	}

	public List<examQuestionChoose> getListOfListQuestions2() {
		return listOfListQuestions2;
	}

	public void setListOfListQuestions2(List<examQuestionChoose> listOfListQuestions2) {
		this.listOfListQuestions2 = listOfListQuestions2;
	}

	public List<examQuestionChoose> getListOfReadQuestions1() {
		return listOfReadQuestions1;
	}

	public void setListOfReadQuestions1(List<examQuestionChoose> listOfReadQuestions1) {
		this.listOfReadQuestions1 = listOfReadQuestions1;
	}

	public List<examQuestionChoose> getListOfReadQuestions2() {
		return listOfReadQuestions2;
	}

	public void setListOfReadQuestions2(List<examQuestionChoose> listOfReadQuestions2) {
		this.listOfReadQuestions2 = listOfReadQuestions2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getExamNum() {
		return examNum;
	}

	public void setExamNum(int examNum) {
		this.examNum = examNum;
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

	
	public int getSizeOfList1() {
		return sizeOfList1;
	}

	public void setSizeOfList1(int sizeOfList1) {
		this.sizeOfList1 = sizeOfList1;
	}

	public int getSizeOfList2() {
		return sizeOfList2;
	}

	public void setSizeOfList2(int sizeOfList2) {
		this.sizeOfList2 = sizeOfList2;
	}

	public int getSizeOfRead1() {
		return sizeOfRead1;
	}

	public void setSizeOfRead1(int sizeOfRead1) {
		this.sizeOfRead1 = sizeOfRead1;
	}

	public int getSizeOfRead2() {
		return sizeOfRead2;
	}

	public void setSizeOfRead2(int sizeOfRead2) {
		this.sizeOfRead2 = sizeOfRead2;
	}

	public String getParagraph1() {
		return paragraph1;
	}

	public void setParagraph1(String paragraph1) {
		this.paragraph1 = paragraph1;
	}

	public String getParagraph2() {
		return paragraph2;
	}

	public void setParagraph2(String paragraph2) {
		this.paragraph2 = paragraph2;
	}

	

	public int getSelectedParagraph() {
		return selectedParagraph;
	}

	public void setSelectedParagraph(int selectedParagraph) {
		this.selectedParagraph = selectedParagraph;
	}

	public List<examQuestionChoose> getListOfSpeakingQuestions() {
		return listOfSpeakingQuestions;
	}

	public void setListOfSpeakingQuestions(List<examQuestionChoose> listOfSpeakingQuestions) {
		this.listOfSpeakingQuestions = listOfSpeakingQuestions;
	}

	public List<examAnswersChoose> getListOfSpeakingAnswers() {
		return listOfSpeakingAnswers;
	}

	public void setListOfSpeakingAnswers(List<examAnswersChoose> listOfSpeakingAnswers) {
		this.listOfSpeakingAnswers = listOfSpeakingAnswers;
	}

	public int getSizeOfSpeaking() {
		return sizeOfSpeaking;
	}

	public void setSizeOfSpeaking(int sizeOfSpeaking) {
		this.sizeOfSpeaking = sizeOfSpeaking;
	}

	public List<examQuestionChoose> getListOfChooseQuestions() {
		return listOfChooseQuestions;
	}

	public void setListOfChooseQuestions(List<examQuestionChoose> listOfChooseQuestions) {
		this.listOfChooseQuestions = listOfChooseQuestions;
	}

	public List<examAnswersChoose> getListOfChooseAnswers() {
		return listOfChooseAnswers;
	}

	public void setListOfChooseAnswers(List<examAnswersChoose> listOfChooseAnswers) {
		this.listOfChooseAnswers = listOfChooseAnswers;
	}

	public int getSizeOfChoose() {
		return sizeOfChoose;
	}

	public void setSizeOfChoose(int sizeOfChoose) {
		this.sizeOfChoose = sizeOfChoose;
	}

	public loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public examAnswersChooseAppServiceImpl getAnsFacede() {
		return ansFacede;
	}

	public void setAnsFacede(examAnswersChooseAppServiceImpl ansFacede) {
		this.ansFacede = ansFacede;
	}

	public String getWritingParagraphAns() {
		return writingParagraphAns;
	}

	public void setWritingParagraphAns(String writingParagraphAns) {
		this.writingParagraphAns = writingParagraphAns;
	}

	public String getSpeakingUrlAns() {
		return speakingUrlAns;
	}

	public void setSpeakingUrlAns(String speakingUrlAns) {
		this.speakingUrlAns = speakingUrlAns;
	}

	public List<examAnswersChoose> getListOfWritingAnswers() {
		return listOfWritingAnswers;
	}

	public void setListOfWritingAnswers(List<examAnswersChoose> listOfWritingAnswers) {
		this.listOfWritingAnswers = listOfWritingAnswers;
	}

	public List<examQuestionChoose> getListOfWritingQuestions() {
		return listOfWritingQuestions;
	}

	public void setListOfWritingQuestions(List<examQuestionChoose> listOfWritingQuestions) {
		this.listOfWritingQuestions = listOfWritingQuestions;
	}

	
	
	
	
	
	
}
