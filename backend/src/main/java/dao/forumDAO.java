package dao;

import java.util.List;

import model.Forum;

public interface forumDAO {

	public boolean addForum(Forum forum);

	public boolean updateForum(Forum forum);

	public boolean deleteForum(Forum forum);

	public Forum getForum(int forumId);

	public List<Forum> getAllForums();

}
