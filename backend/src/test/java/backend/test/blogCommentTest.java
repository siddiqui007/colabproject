package backend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.blogCommentDAO;
import model.BlogComments;

public class blogCommentTest {
	
	static blogCommentDAO blogCommentsDAO;
	@BeforeClass
	public static void initialize(){
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
	annotationConfigApplicationContext.scan("com.socialnetwork");
	annotationConfigApplicationContext.refresh();
	blogCommentsDAO=(blogCommentDAO) annotationConfigApplicationContext.getBean("blogCommentsDAO");
	}
	@Ignore
	@Test
	public void saveBlogCommentstest() {
		BlogComments blogComments=new BlogComments();
		blogComments.setBlogCommentsId(101);
		blogComments.setBlogId(101);
		blogComments.setUsercomment("good");
		blogComments.setUserId(1);
		blogComments.setUsername("TESTING");
		
		assertTrue("problem occured",blogCommentsDAO.saveBlogComments(blogComments));
	}
	@Ignore
	@Test
	public void deleteBlogComments(){
		BlogComments blogComments=(BlogComments)blogCommentsDAO.getBlogComments(1);
		assertTrue("",blogCommentsDAO.deleteBlogComments(blogComments));
	}@Ignore
	@Test
	public void updateCommentsBlog()
	{
		BlogComments blogComments=(BlogComments)blogCommentsDAO.getBlogComments(2);
		blogComments.setUsercomment("nice");
		blogComments.setUserId(501);
		assertTrue("forum is updated",blogCommentsDAO.updateBlogComments(blogComments));
	}
	@Test
	public void getAllBlogComments(){
		List<BlogComments>blogCommentsList=(List<BlogComments>)blogCommentsDAO.getAllBlogComments();
		assertNotNull("",blogCommentsList.get(0));
		for(BlogComments blogComments:blogCommentsList)
		{
			System.out.println("blogcomment:::="+blogComments.getUsercomment());
	}
	}
	@Test
	public void getBlogComments(){
		BlogComments blogComments=(BlogComments)blogCommentsDAO.getBlogComments(2);
		assertNotNull("error",blogComments);
		System.out.println("jobs desc is "+blogComments.getBlogCommentsId());
		System.out.println("jobs profile"+blogComments.getUsercomment());
	}
}



