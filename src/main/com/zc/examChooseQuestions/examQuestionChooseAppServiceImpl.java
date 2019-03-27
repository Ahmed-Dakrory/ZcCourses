/**
 * 
 */
package main.com.zc.examChooseQuestions;





import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("examQuestionChooseFacadeImpl")
public class examQuestionChooseAppServiceImpl implements IExamQuestionChooseAppService{

	@Autowired
	examQuestionChooseRepository examQuestionChooseRepository;
	
	
	@Override
	public List<examQuestionChoose> getAll() {
		try{
			List<examQuestionChoose> data=examQuestionChooseRepository.getAll();
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
	



	@Override
	public examQuestionChoose getById(int id) {
		try{
			examQuestionChoose data=examQuestionChooseRepository.getById(id);				
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<examQuestionChoose> getAllExamQuestion(int examNum) {
		try{
			List<examQuestionChoose> data=examQuestionChooseRepository.getAllExamQuestion(examNum);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public List<examQuestionChoose> getAllListeningSecNumb(int examNum, int listId) {
		try{
			List<examQuestionChoose> data=examQuestionChooseRepository.getAllListeningSecNumb(examNum, listId);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<examQuestionChoose> getAllReadSecNumb(int examNum, int readId) {
		try{
			List<examQuestionChoose> data=examQuestionChooseRepository.getAllReadSecNumb(examNum, readId);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public examQuestionChoose addExamQuestionChoose(examQuestionChoose data) {
		try{
			examQuestionChoose so2=examQuestionChooseRepository.addExamQuestionChoose(data);
			return so2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public boolean delete(examQuestionChoose data) {
		// TODO Auto-generated method stub
				try{
					examQuestionChooseRepository.delete(data);
					return true;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return false;
					}
	}






	@Override
	public List<examQuestionChoose> getAllWritingSecNumb(int examNum, int writingId) {
		try{
			List<examQuestionChoose> data=examQuestionChooseRepository.getAllWritingSecNumb(examNum, writingId);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}






	@Override
	public List<examQuestionChoose> getAllSpeakingSecNumb(int examNum, int speakingId) {
		try{
			List<examQuestionChoose> data=examQuestionChooseRepository.getAllSpeakingSecNumb(examNum, speakingId);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}






	@Override
	public List<examQuestionChoose> getAllChooseSecNumb(int examNum, int chooseId) {
		try{
			List<examQuestionChoose> data=examQuestionChooseRepository.getAllChooseSecNumb(examNum, chooseId);
			
			return data;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
}
		
		

	
		
	


