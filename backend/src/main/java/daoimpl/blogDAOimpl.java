package daoimpl;

import java.util.List;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.blogDAO;
import model.Blog;

@Repository("blogDAO")
@Transactional
public class blogDAOimpl implements blogDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	@Override
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	@Override
	public Blog getBlog(int blogId) {
		Session session = (Session) sessionFactory.openSession();
		Blog blog = ((org.hibernate.Session) session).get(Blog.class, new Integer(blogId));
		return blog;
	}

	@Transactional
	@Override
	public List<Blog> getAllBlogs() 
	{

		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}
	@Transactional
	
	@Override
	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
