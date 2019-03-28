/**
 * 
 */
package main.com.zc.examChooseAnswers;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.zc.examChooseAnswers.examAnswersChoose;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class examAnswersChooseRepositoryImpl implements examAnswersChooseRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	

	

	

	@Override
	public examAnswersChoose getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<examAnswersChoose> results=query.list();
		   return results.get(0);
	}


	@Override
	public List<examAnswersChoose> getAllstudentAnswers(int id_Student) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getAllstudentAnswers").setInteger("id_Student", id_Student);

				 @SuppressWarnings("unchecked")
				List<examAnswersChoose> results=query.list();
				return results;
	}


	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExam(int id_Student, int examNum) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getAllstudentAnswerForExam").setInteger("id_Student",id_Student).setInteger("examNum", examNum);

				 @SuppressWarnings("unchecked")
				List<examAnswersChoose> results=query.list();
				return results;
	}


	@Override
	public examAnswersChoose getstudentAnswerForExamWithQuestionId(int id_Student, int questionId) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getstudentAnswerForExamWithQuestionId").setInteger("id_Student",id_Student).setInteger("questionId", questionId);

				 @SuppressWarnings("unchecked")
				List<examAnswersChoose> results=query.list();
				   return results.get(0);
	}


	@Override
	public examAnswersChoose addExamAnswersChoose(examAnswersChoose data) {
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
	public boolean delete(examAnswersChoose data) {
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


	@Override
	public List<examAnswersChoose> getAll() {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getAll");

		 @SuppressWarnings("unchecked")
		List<examAnswersChoose> results=query.list();
		return results;
	}


	@Override
	public List<examAnswersChoose> getAllAnswersForExam(int examNum) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getAllAnswerForExam").setInteger("examNum", examNum);

		 @SuppressWarnings("unchecked")
		List<examAnswersChoose> results=query.list();
		return results;
	}


	@Override
	public List<examAnswersChoose> getAllStudents(int examNum) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getAllstudent").setInteger("examNum", examNum);

				 @SuppressWarnings("unchecked")
				List<examAnswersChoose> results=query.list();
				return results;
	}


	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForChooseId(int id_Student, int examNum, int id_choose) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getstudentAnswerForExamWithChooseId").setInteger("id_choose", id_choose).setInteger("id_Student", id_Student).setInteger("examNum", examNum);

		 @SuppressWarnings("unchecked")
		List<examAnswersChoose> results=query.list();
		return results;
	}


	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForListeningId(int id_Student, int examNum,
			int id_listening) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getstudentAnswerForExamWithListId").setInteger("id_listening", id_listening).setInteger("id_Student", id_Student).setInteger("examNum", examNum);

		 @SuppressWarnings("unchecked")
		List<examAnswersChoose> results=query.list();
		return results;
	}


	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForReadingId(int id_Student, int examNum, int id_reading) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getstudentAnswerForExamWithReadId").setInteger("id_reading", id_reading).setInteger("id_Student", id_Student).setInteger("examNum", examNum);

		 @SuppressWarnings("unchecked")
		List<examAnswersChoose> results=query.list();
		return results;
	}


	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForWritingId(int id_Student, int examNum, int id_writing) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getstudentAnswerForExamWithWritingId").setInteger("id_writing", id_writing).setInteger("id_Student", id_Student).setInteger("examNum", examNum);

		 @SuppressWarnings("unchecked")
		List<examAnswersChoose> results=query.list();
		return results;
	}


	@Override
	public List<examAnswersChoose> getAllstudentAnswerForExamForSpeakingId(int id_Student, int examNum,
			int id_speaking) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("examAnswersChoose.getstudentAnswerForExamWithSpeakingId").setInteger("id_speaking", id_speaking).setInteger("id_Student", id_Student).setInteger("examNum", examNum);

		 @SuppressWarnings("unchecked")
		List<examAnswersChoose> results=query.list();
		return results;
	}

}
