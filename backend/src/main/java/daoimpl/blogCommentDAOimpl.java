package daoimpl;

import java.util.List;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.blogCommentDAO;
import model.BlogComments;

@Transactional
@Repository("blogCommentDAO")

public class blogCommentDAOimpl {

	public class BlogCommentsDaoImpl implements blogCommentDAO {
		@Autowired
		SessionFactory sessionFactory;

		@Transactional
		@Override
		public boolean saveBlogComments(BlogComments blogComments) {
			try {
				sessionFactory.getCurrentSession().save(blogComments);
				return true;
			} catch (Exception e) {
				System.out.println("exception arised" + e);
			}
			return false;
		}

		@Transactional
		@Override
		public boolean deleteBlogComments(BlogComments blogComments) {
			try {
				sessionFactory.getCurrentSession().delete(blogComments);
				return true;
			} catch (Exception e) {
				System.out.println("exception arised" + e);
			}
			return false;
		}

		@Transactional
		@Override
		public boolean updateBlogComments(BlogComments blogComments) {
			try {
				sessionFactory.getCurrentSession().update(blogComments);
				return true;
			} catch (Exception e) {
				System.out.println("exception arised" + e);
			}
			return false;
		}

		@Transactional
		@Override
		public BlogComments getBlogComments(int blogCommentsId) {

			Session session = (Session) sessionFactory.openSession();
			BlogComments blogComments = (BlogComments) ((org.hibernate.Session) session).get(BlogComments.class, new Integer(blogCommentsId));
			return blogComments;

		}

		@Transactional
		@Override
		public List<BlogComments> getAllBlogComments() {

			return sessionFactory.getCurrentSession().createQuery("from BlogComments").list();
		}

	}

}
