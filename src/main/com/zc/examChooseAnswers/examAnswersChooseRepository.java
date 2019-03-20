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
	public examAnswersChoose getById(int id);
	public List<examAnswersChoose> getAllstudentAnswers(int id_Student);
	public List<examAnswersChoose> getAllstudentAnswerForExam(int id_Student,int examNum);
	public examAnswersChoose getstudentAnswerForExamWithQuestionId(int id_Student,int questionId);
	public examAnswersChoose addExamAnswersChoose(examAnswersChoose data);
	public boolean delete(examAnswersChoose data);
}
