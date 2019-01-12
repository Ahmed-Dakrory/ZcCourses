/**
 * 
 */
package main.com.zc.programs;

import java.util.List;

/**
 * @author Dakrory
 *
 */
public interface IProgramDataAppService {

	public List<ProgramData> getAll();
	public ProgramData addProgramData(ProgramData data);
	public ProgramData getById(int id);
	public boolean delete(ProgramData data);
}
