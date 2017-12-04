package dao;

import java.util.List;

import model.BlogComments;

public interface blogCommentDAO {
	
	public boolean saveBlogComments(BlogComments blogComments);

	public boolean deleteBlogComments(BlogComments blogComments);

	public boolean updateBlogComments(BlogComments blogComments);

	public BlogComments getBlogComments(int blogCommentsId);

	public List<BlogComments> getAllBlogComments();

}
