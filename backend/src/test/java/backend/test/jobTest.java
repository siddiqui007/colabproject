package backend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.jobDAO;
import model.Job;

public class jobTest {

	static jobDAO jobsDAO;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.socialnetwork");
		annotationConfigApplicationContext.refresh();
		jobsDAO = (jobDAO) annotationConfigApplicationContext.getBean("jobDAO");
	}

	@Ignore
	@Test
	public void saveJobs() {
		Job jobs = new Job();
		jobs.setJobDesc("jobs");
		jobs.setJobId(123);
		jobs.setJobProfile("jobs");
		jobs.setQualification("jobs");
		jobs.setStatus("jobs");
		assertTrue("problem in adding CartItem", jobsDAO.saveJobs(jobs));

	}

	@Ignore
	@Test
	public void deleteJobs() {
		Job jobs = (Job) jobsDAO.getJobs(1);
		assertTrue("problem in deleting", jobsDAO.deleteJobs(jobs));
	}

	@Ignore
	@Test
	public void updateJobs() {
		Job jobs = (Job) jobsDAO.getJobs(2);
		jobs.setJobDesc("done");
		jobs.setJobProfile("hired");
		assertTrue("problem in updating", jobsDAO.updateJobs(jobs));
	}

	@Ignore
	@Test
	public void getAllJobs() {
		List<Job> jobsList = (List<Job>) jobsDAO.getAllJobs();
		assertNotNull("blog is null", jobsList.get(0));
		for (Job jobs : jobsList) {
			System.out.println("jobs is" + jobs.getJobDesc() + ":::" + "job name::" + jobs.getJobProfile() + "");
		}
	}

	@Test
	public void getJobs() {
		Job jobs = (Job) jobsDAO.getJobs(2);
		assertNotNull("error", jobs);
		System.out.println("jobs desc is " + jobs.getJobDesc());
		System.out.println("jobs profile" + jobs.getJobProfile());

	}

}
