/**
 * 
 */
package main.com.zc.allRegisterations;

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
public class courseRegRepositoryImpl implements courseRegRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public courseReg addcourseReg(courseReg so) {
		try{
			System.out.println("Ahmed OKKKKKKKKKKKKKK");
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.saveOrUpdate(so);
			tx1.commit();
			session.close(); 
			return so; 
			}
			catch(Exception ex)
			{
				System.out.println(">>>>>>>>>>");
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<courseReg> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("courseReg.getAll");

				 @SuppressWarnings("unchecked")
				List<courseReg> results=query.list();
				   return results;
	}
	
	@Override
	public List<courseReg> getByIdCourse(int idCourse) {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("courseReg.getBycourseId").setInteger("courseId", idCourse);

				 @SuppressWarnings("unchecked")
				List<courseReg> results=query.list();
				   return results;
	}

	
	@Override
	public boolean delete(courseReg note) {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.delete(note);
			tx1.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public courseReg getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("courseReg.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<courseReg> results=query.list();
		   return results.get(0);
	}

	@Override
	public List<courseReg> getByIdStudent(int id) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("courseReg.getBystudentId").setInteger("studentId", id);

		 @SuppressWarnings("unchecked")
		List<courseReg> results=query.list();
		   return results;
	}

	@Override
	public courseReg getByIdStudentandCourseId(int idstudent, int idcourse) {
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("courseReg.getBystudentAndCourseId").setInteger("studentId",idstudent).setInteger("courseId", idcourse);

				 @SuppressWarnings("unchecked")
				List<courseReg> results=query.list();
				if(results.size()==0){
					return null;
				}else{

					   return results.get(0);
				}
	}

}
