/**
 * 
 */
package main.com.zc.examChooseAnswers;





import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.com.zc.examChooseAnswers.examAnswersChoose;

/**
 * @author Dakrory
 *
 */
@Service("examAnswersChooseFacadeImpl")
public class examAnswersChooseAppServiceImpl implements IExamAnswersChooseAppService{

	@Autowired
	examAnswersChooseRepository examAnswersChooseRepository;
	
	
	@Override
	public List<examAnswersChoose> getAll() {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAll();
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
	



	

	@Override
	public boolean delete(examAnswersChoose data) {
		// TODO Auto-generated method stub
				try{
					examAnswersChooseRepository.delete(data);
					return true;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return false;
					}
	}






	@Override
	public examAnswersChoose getById(int id) {
		try{
			examAnswersChoose data=examAnswersChooseRepository.getById(id);				
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}






	@Override
	public List<examAnswersChoose> getAllstudentAnswers(int id_Student) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllstudentAnswers(id_Student);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}






	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExam(int id_Student, int examNum) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllstudentAnswerForExam(id_Student, examNum);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}






	





	@Override
	public examAnswersChoose addExamAnswersChoose(examAnswersChoose data) {
		try{
			examAnswersChoose so2=examAnswersChooseRepository.addExamAnswersChoose(data);
			return so2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}








	@Override
	public examAnswersChoose getstudentAnswerForExamWithQuestionId(int id_Student, int questionId) {
		try{
			examAnswersChoose data=examAnswersChooseRepository.getstudentAnswerForExamWithQuestionId(id_Student, questionId);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}








	@Override
	public List<examAnswersChoose> getAllAnswersForExam(int examNum) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllAnswersForExam(examNum);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}








	@Override
	public List<examAnswersChoose> getAllStudents(int examNum) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllStudents(examNum);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}








	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForChooseId(int id_Student, int examNum, int id_choose) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllstudentAnswerForExamForChooseId(id_Student, examNum, id_choose);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}








	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForListeningId(int id_Student, int examNum,
			int id_listening) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllstudentAnswerForExamForListeningId(id_Student, examNum, id_listening);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}








	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForReadingId(int id_Student, int examNum, int id_reading) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllstudentAnswerForExamForReadingId(id_Student, examNum, id_reading);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}








	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForWritingId(int id_Student, int examNum, int id_writing) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllstudentAnswerForExamForWritingId(id_Student, examNum, id_writing);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}








	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForSpeakingId(int id_Student, int examNum,
			int id_speaking) {
		try{
			List<examAnswersChoose> data=examAnswersChooseRepository.getAllstudentAnswerForExamForSpeakingId(id_Student, examNum, id_speaking);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}






	
}
		
		

	
		
	


