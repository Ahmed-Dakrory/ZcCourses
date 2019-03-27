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
	public List<examQuestionChoose> getAllChooseSecNumb(int examNum,int chooseId);
	public List<examQuestionChoose> getAllListeningSecNumb(int examNum,int listId);
	public List<examQuestionChoose> getAllReadSecNumb(int examNum,int readId);
	public List<examQuestionChoose> getAllWritingSecNumb(int examNum,int writingId);
	public List<examQuestionChoose> getAllSpeakingSecNumb(int examNum,int speakingId);
	public examQuestionChoose addExamQuestionChoose(examQuestionChoose data);
	public boolean delete(examQuestionChoose data);
}
