package daoimpl;

import java.util.List;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.forumDAO;
import model.Forum;

@Repository("forumDAO")

public class forumDAOimpl implements forumDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public Forum getForum(int forumId) {
		Session session = (Session) sessionFactory.openSession();
		Forum forum = (Forum) ((org.hibernate.Session) session).get(Forum.class, new Integer(forumId));
		return forum;

	}

	@Transactional
	public List<Forum> getAllForums() {

		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}

}
