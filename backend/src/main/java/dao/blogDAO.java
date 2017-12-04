package dao;

import java.util.List;

import model.Blog;

public interface blogDAO {

	public boolean addBlog(Blog blog);

	public boolean updateBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public Blog getBlog(int blogId);

	public List<Blog> getAllBlogs();

	public boolean approveBlog(Blog blog);
	

}
