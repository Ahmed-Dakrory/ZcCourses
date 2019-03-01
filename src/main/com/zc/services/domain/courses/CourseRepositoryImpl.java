/**
 * 
 */
package main.com.zc.services.domain.courses;

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
public class CourseRepositoryImpl implements CourseRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public course addCourse(course so) {
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
	public List<course> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("course.getAll");

				 @SuppressWarnings("unchecked")
				List<course> results=query.list();
				   return results;
	}
	
	@Override
	public List<course> getByIdProgram(int idprogram) {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("course.getByIdProgram").setInteger("idProgram", idprogram);

				 @SuppressWarnings("unchecked")
				List<course> results=query.list();
				   return results;
	}

	
	@Override
	public boolean delete(course note) {
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
	public course getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("course.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<course> results=query.list();
		if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

}
