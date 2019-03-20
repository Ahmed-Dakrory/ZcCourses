package main.com.zc.exam;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import main.com.zc.examChooseAnswers.examAnswersChoose;
import main.com.zc.examChooseQuestions.examQuestionChoose;
import main.com.zc.examChooseQuestions.examQuestionChooseAppServiceImpl;



@ManagedBean(name = "examBean")
@SessionScoped
public class examBean implements Serializable {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7171882406959312752L;



	
	
	
	@ManagedProperty(value = "#{examQuestionChooseFacadeImpl}")
	private examQuestionChooseAppServiceImpl chooseQuesFacede; 
	private List<examQuestionChoose> listOfVocQuestions;
	private List<examQuestionChoose> listOfGramQuestions;
	private List<examQuestionChoose> listOfListQuestions1;
	private List<examQuestionChoose> listOfListQuestions2;
	private List<examQuestionChoose> listOfReadQuestions1;
	private List<examQuestionChoose> listOfReadQuestions2;
	
	

	private List<examAnswersChoose> listOfVocAnswers;
	private List<examAnswersChoose> listOfGramAnswers;
	private List<examAnswersChoose> listOfListAnswers1;
	private List<examAnswersChoose> listOfListAnswers2;
	private List<examAnswersChoose> listOfReadAnswers1;
	private List<examAnswersChoose> listOfReadAnswers2;
	
	private int examNum;
	
	private int sizeOfVoc;
	private int sizeOfGram;
	private int sizeOfList1;
	private int sizeOfList2;
	private int sizeOfRead1;
	private int sizeOfRead2;

	private String paragraph1;
	private String paragraph2;
	
	@PostConstruct
	public void init() {
		examNum=1;
		refreshPage();
		
	}
	
	public void refreshPage(){
		listOfVocAnswers=new ArrayList<examAnswersChoose>();
		listOfGramAnswers=new ArrayList<examAnswersChoose>();
		listOfListAnswers1=new ArrayList<examAnswersChoose>();
		listOfListAnswers2=new ArrayList<examAnswersChoose>();
		listOfReadAnswers1=new ArrayList<examAnswersChoose>();
		listOfReadAnswers2=new ArrayList<examAnswersChoose>();
		
		
		
		listOfVocQuestions=chooseQuesFacede.getAllVocabSecNumb(examNum, 1);
		listOfGramQuestions=chooseQuesFacede.getAllGrammerSecNumb(examNum, 1);
		listOfListQuestions1=chooseQuesFacede.getAllListeningSecNumb(examNum, 1);
		listOfListQuestions2=chooseQuesFacede.getAllListeningSecNumb(examNum, 2);
		listOfReadQuestions1=chooseQuesFacede.getAllReadSecNumb(examNum, 1);
		listOfReadQuestions2=chooseQuesFacede.getAllReadSecNumb(examNum, 2);
		
		InitializeTheAnsList();

		paragraph1=listOfReadQuestions1.get(0).getReading_paragraph();
		paragraph2=listOfReadQuestions2.get(0).getReading_paragraph();
	}

	private void InitializeTheAnsList() {
		// TODO Auto-generated method stub
		sizeOfVoc=listOfVocQuestions.size();
		sizeOfGram=listOfGramQuestions.size();
		sizeOfList1=listOfListQuestions1.size();
		sizeOfList2=listOfListQuestions2.size();
		sizeOfRead1=listOfReadQuestions1.size();
		sizeOfRead2=listOfReadQuestions2.size();
		
		
		
		for(int i=0;i<sizeOfVoc;i++) {
			examAnswersChoose ansVoc=new examAnswersChoose();
			ansVoc.setAns(1);
			ansVoc.setQuestion(listOfVocQuestions.get(i));
			listOfVocAnswers.add(ansVoc);
		}

		for(int i=0;i<sizeOfGram;i++) {
			examAnswersChoose ansGram=new examAnswersChoose();
			ansGram.setAns(1);
			ansGram.setQuestion(listOfGramQuestions.get(i));
			listOfGramAnswers.add(ansGram);
		}
		
		for(int i=0;i<sizeOfList1;i++) {
			examAnswersChoose ansList1=new examAnswersChoose();
			ansList1.setAns(1);
			ansList1.setQuestion(listOfListQuestions1.get(i));
			listOfListAnswers1.add(ansList1);
		}
		
		for(int i=0;i<sizeOfList2;i++) {
			examAnswersChoose ansList2=new examAnswersChoose();
			ansList2.setAns(1);
			ansList2.setQuestion(listOfListQuestions2.get(i));
			listOfListAnswers2.add(ansList2);
		}
		
		for(int i=0;i<sizeOfRead1;i++) {
			examAnswersChoose ansRead1=new examAnswersChoose();
			ansRead1.setAns(1);
			ansRead1.setQuestion(listOfReadQuestions1.get(i));
			listOfReadAnswers1.add(ansRead1);
		}
		
		for(int i=0;i<sizeOfRead2;i++) {
			examAnswersChoose ansRead2=new examAnswersChoose();
			ansRead2.setAns(1);
			ansRead2.setQuestion(listOfReadQuestions2.get(i));
			listOfReadAnswers2.add(ansRead2);
		}
		
	}

	public void readAllAnswers() {
		for(int i=0;i<listOfVocAnswers.size();i++) {
			System.out.println("Answer Voc: "+String.valueOf(listOfVocAnswers.get(i).getAns()));
		}
		
		for(int i=0;i<listOfGramAnswers.size();i++) {
			System.out.println("Answer Gram: "+String.valueOf(listOfGramAnswers.get(i).getAns()));
		}
		
		for(int i=0;i<listOfListAnswers1.size();i++) {
			System.out.println("Answer Gram: "+String.valueOf(listOfListAnswers1.get(i).getAns()));
		}
		
		for(int i=0;i<listOfListAnswers2.size();i++) {
			System.out.println("Answer Gram: "+String.valueOf(listOfListAnswers2.get(i).getAns()));
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

	public List<examQuestionChoose> getListOfVocQuestions() {
		return listOfVocQuestions;
	}

	public void setListOfVocQuestions(List<examQuestionChoose> listOfVocQuestions) {
		this.listOfVocQuestions = listOfVocQuestions;
	}

	public List<examQuestionChoose> getListOfGramQuestions() {
		return listOfGramQuestions;
	}

	public void setListOfGramQuestions(List<examQuestionChoose> listOfGramQuestions) {
		this.listOfGramQuestions = listOfGramQuestions;
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

	public List<examAnswersChoose> getListOfVocAnswers() {
		return listOfVocAnswers;
	}

	public void setListOfVocAnswers(List<examAnswersChoose> listOfVocAnswers) {
		this.listOfVocAnswers = listOfVocAnswers;
	}

	public List<examAnswersChoose> getListOfGramAnswers() {
		return listOfGramAnswers;
	}

	public void setListOfGramAnswers(List<examAnswersChoose> listOfGramAnswers) {
		this.listOfGramAnswers = listOfGramAnswers;
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

	public int getSizeOfVoc() {
		return sizeOfVoc;
	}

	public void setSizeOfVoc(int sizeOfVoc) {
		this.sizeOfVoc = sizeOfVoc;
	}

	public int getSizeOfGram() {
		return sizeOfGram;
	}

	public void setSizeOfGram(int sizeOfGram) {
		this.sizeOfGram = sizeOfGram;
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

	
	
	
	
	
	
	
}
