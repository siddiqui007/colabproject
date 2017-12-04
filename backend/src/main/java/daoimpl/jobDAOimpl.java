package daoimpl;

import java.util.List;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.jobDAO;
import model.Job;

@Repository("jobDAO")
@Transactional

public class jobDAOimpl implements jobDAO {

	SessionFactory sessionfactory;
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean saveJobs(Job jobs) {
		try {
			sessionFactory.getCurrentSession().save(jobs);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;

	}

	@Transactional
	@Override
	public boolean deleteJobs(Job jobs) {
		try {
			sessionFactory.getCurrentSession().delete(jobs);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;

	}

	@Transactional
	@Override
	public boolean updateJobs(Job jobs) {
		try {
			sessionFactory.getCurrentSession().update(jobs);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;

	}

	@Transactional
	@Override
	public Job getJobs(int jobId) {
		Session session = (Session) sessionFactory.openSession();
		Job jobs = (Job) ((org.hibernate.Session) session).get(Job.class, new Integer(jobId));
		return jobs;

	}

	@Transactional
	@Override
	public List<Job> getAllJobs() {
		return sessionFactory.getCurrentSession().createQuery("from Jobs").list();
	}

}
