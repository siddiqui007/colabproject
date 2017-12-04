package backend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.blogDAO;
import model.Blog;

public class blogTest {

	{
		static blogDAO Blog;
	}
	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.socialnetwork");
		annotationConfigApplicationContext.refresh();
		Blog=(Blog) annotationConfigApplicationContext.getBean("blogDAO");
		}

	@Test
	public void addBlog() {
		Blog blog = new Blog();
		blog.setBlogContent("blog");
		blog.setBlogID(123);
		blog.setBlogName("blog");
		blog.setLikes(100);
		blog.setStatus("online");
		assertTrue("problem in adding CartItem",blogDAO.addBlog(blog));

	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(1);
		assertTrue("blog deleted",blogDAO.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(4);
		blog.setBlogContent("java");
		blog.setBlogName("vanilla java");
		assertTrue("blog updated",blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void getBlogTest()
	{
		Blog blog=blogDAO.getBlog(4);
		assertNotNull("",blog);
		System.out.println("blog name "+blog.getBlogName());
		System.out.println("blog content"+blog.getBlogContent());
	}
	@Ignore
	@Test
	public void getAllBlogsTest()
	{
		List<Blog>blogList=(List<Blog>)blogDAO.getAllBlogs();
		assertNotNull("blog is null",blogList.get(0));
		for(Blog blog:blogList)
		{
			System.out.println("blog is"+blog.getBlogID()+":::"+"blog name::"+blog.getBlogName()+"");
		}
	}

}
