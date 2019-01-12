/**
 * 
 */
package main.com.zc.programs;





import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("ProgramDataFacadeImpl")
public class ProgramDataAppServiceImpl implements IProgramDataAppService{

	@Autowired
	ProgramDataRepository programDataRepository;
	
	
	@Override
	public List<ProgramData> getAll() {
		try{
			List<ProgramData> course=programDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public ProgramData addProgramData(ProgramData data) {
		try{
			ProgramData data2=programDataRepository.addProgramData(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(ProgramData data) {
		// TODO Auto-generated method stub
		try{
			programDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
	}

	@Override
	public ProgramData getById(int id) {
		// TODO Auto-generated method stub
		try{
			ProgramData so=programDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	
	
}
		
		

	
		
	


