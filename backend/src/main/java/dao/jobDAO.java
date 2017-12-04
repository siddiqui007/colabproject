package dao;

import java.util.List;

import model.Job;

public interface jobDAO {

	public boolean saveJobs(Job job);

	public boolean deleteJobs(Job job);

	public boolean updateJobs(Job job);

	public Job getJobs(int jobId);

	public List<Job> getAllJobs();
}
