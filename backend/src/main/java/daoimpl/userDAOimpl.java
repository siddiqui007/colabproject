package daoimpl;

import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.userDAO;
import model.User;

@Repository("userDAO")
@Transactional

public class userDAOimpl implements userDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<User> getAllUser() {
		String hql = "from User";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		return ((org.hibernate.query.Query) query).list();
	}

	@Transactional
	public boolean saveUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;

		}
	}

	@Transactional
	@Override
	public User getByEmail(String email) {

		return (User) sessionFactory.getCurrentSession().get(User.class, email);
	}

}
