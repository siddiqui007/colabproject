package daoimpl;

import java.util.List;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.forumCommentDAO;
import model.ForumComments;

@Repository("forumCommentDAO")
@Transactional



public class forumCommentDAOimpl implements forumCommentDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean saveForumComments(ForumComments forumComments) {
		{
			try {
				sessionFactory.getCurrentSession().save(forumComments);
				return true;
			} catch (Exception e) {
				System.out.println("exception arised" + e);
			}
		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteForumComments(ForumComments forumComments) {
		try {
			sessionFactory.getCurrentSession().delete(forumComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	@Override
	public boolean updateForumComments(ForumComments forumComments) {
		try{
			sessionFactory.getCurrentSession().update(forumComments);
			return true;
		}catch(Exception e){
			System.out.println("exception arised"+e);

		}
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	@Override
	public ForumComments getForumComments(int fComments) {
		Session session = (Session) sessionFactory.openSession();
		ForumComments forumComments = (ForumComments) ((org.hibernate.Session) session).get(ForumComments.class, new Integer(fComments));
		return forumComments;
		
	}
	@Transactional
	@Override
	public List<ForumComments> getAllForumComments() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from ForumComments").list();
	}

}

