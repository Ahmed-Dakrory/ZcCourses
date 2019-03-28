/**
 * 
 */
package main.com.zc.examChooseAnswers;

import java.util.List;

import main.com.zc.examChooseAnswers.examAnswersChoose;

/**
 * @author Dakrory
 *
 */
public interface examAnswersChooseRepository {

	public List<examAnswersChoose> getAll();
	public List<examAnswersChoose> getAllStudents(int examNum);
	public examAnswersChoose getById(int id);
	public List<examAnswersChoose> getAllstudentAnswers(int id_Student);
	public List<examAnswersChoose> getAllAnswersForExam(int examNum);
	public List<examAnswersChoose> getAllstudentAnswerForExam(int id_Student,int examNum);
	public examAnswersChoose getstudentAnswerForExamWithQuestionId(int id_Student,int questionId);
	public examAnswersChoose addExamAnswersChoose(examAnswersChoose data);
	public boolean delete(examAnswersChoose data);
	

	public List<examAnswersChoose> getAllstudentAnswerForExamForChooseId(int id_Student,int examNum,int id_choose);
	public List<examAnswersChoose> getAllstudentAnswerForExamForListeningId(int id_Student,int examNum,int id_listening);
	public List<examAnswersChoose> getAllstudentAnswerForExamForReadingId(int id_Student,int examNum,int id_reading);
	public List<examAnswersChoose> getAllstudentAnswerForExamForWritingId(int id_Student,int examNum,int id_writing);
	public List<examAnswersChoose> getAllstudentAnswerForExamForSpeakingId(int id_Student,int examNum,int id_speaking);
}
