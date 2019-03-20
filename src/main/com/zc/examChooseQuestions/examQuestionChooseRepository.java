/**
 * 
 */
package main.com.zc.examChooseQuestions;

import java.util.List;

/**
 * @author Dakrory
 *
 */
public interface examQuestionChooseRepository {

	public List<examQuestionChoose> getAll();
	public examQuestionChoose getById(int id);
	public List<examQuestionChoose> getAllExamQuestion(int examNum);
	public List<examQuestionChoose> getAllVocabSecNumb(int examNum,int vocId);
	public List<examQuestionChoose> getAllGrammerSecNumb(int examNum,int gramId);
	public List<examQuestionChoose> getAllListeningSecNumb(int examNum,int listId);
	public List<examQuestionChoose> getAllReadSecNumb(int examNum,int readId);
	public examQuestionChoose addExamQuestionChoose(examQuestionChoose data);
	public boolean delete(examQuestionChoose data);
}
