package dao;

import java.util.List;

import model.ForumComments;

public interface forumCommentDAO {
	public boolean saveForumComments(ForumComments forumComments);

	public boolean deleteForumComments(ForumComments forumComments);

	public boolean updateForumComments(ForumComments forumComments);

	public ForumComments getForumComments(int fComments);

	public List<ForumComments> getAllForumComments();

}
