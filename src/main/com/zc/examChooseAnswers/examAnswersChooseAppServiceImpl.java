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






	
}
		
		

	
		
	


