/**
 * 
 */
package main.com.zc.examChooseQuestions;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class examQuestionChooseRepositoryImpl implements examQuestionChooseRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	

	@Override
	public List<examQuestionChoose> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examQuestionChoose.getAll");

				 @SuppressWarnings("unchecked")
				List<examQuestionChoose> results=query.list();
				   return results;
	}
	

	@Override
	public examQuestionChoose getById(int id) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examQuestionChoose.getById").setInteger("id",id);

				 @SuppressWarnings("unchecked")
				List<examQuestionChoose> results=query.list();
				   return results.get(0);
	}

	@Override
	public List<examQuestionChoose> getAllExamQuestion(int examNum) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examQuestionChoose.getAllVocabSecNumb").setInteger("examNumb",examNum);

				 @SuppressWarnings("unchecked")
				List<examQuestionChoose> results=query.list();
				return results;
	}

	@Override
	public List<examQuestionChoose> getAllVocabSecNumb(int examNum, int vocId) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examQuestionChoose.getAllVocabSecNumb").setInteger("examNumb",examNum).setInteger("id_vocab", vocId);

		 @SuppressWarnings("unchecked")
		List<examQuestionChoose> results=query.list();
		return results;
		
	}

	@Override
	public List<examQuestionChoose> getAllGrammerSecNumb(int examNum, int gramId) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examQuestionChoose.getAllGrammerSecNumb").setInteger("examNumb",examNum).setInteger("id_grammer", gramId);

				 @SuppressWarnings("unchecked")
				List<examQuestionChoose> results=query.list();
				return results;
	}

	@Override
	public List<examQuestionChoose> getAllListeningSecNumb(int examNum, int listId) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examQuestionChoose.getAllListeningSecNumb").setInteger("examNumb",examNum).setInteger("id_listening", listId);

				 @SuppressWarnings("unchecked")
				List<examQuestionChoose> results=query.list();
				return results;
	}

	@Override
	public List<examQuestionChoose> getAllReadSecNumb(int examNum, int readId) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examQuestionChoose.getAllReadSecNumb").setInteger("examNumb",examNum).setInteger("id_reading", readId);

				 @SuppressWarnings("unchecked")
				List<examQuestionChoose> results=query.list();
				return results;
	}

	@Override
	public examQuestionChoose addExamQuestionChoose(examQuestionChoose data) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Ahmed OKKKKKKKKKKKKKK");
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.saveOrUpdate(data);
			tx1.commit();
			session.close(); 
			return data; 
			}
			catch(Exception ex)
			{
				System.out.println(">>>>>>>>>>");
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public boolean delete(examQuestionChoose data) {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.delete(data);
			tx1.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
