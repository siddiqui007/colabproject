package backend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.Forum;

public class forumTest {

	static dao.forumDAO forumDAO;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.socialnework");
		annotationConfigApplicationContext.refresh();
		forumDAO = (dao.forumDAO) annotationConfigApplicationContext.getBean("forumDAO");
	}

	@Ignore
	@Test
	public void addForum() {
		Forum forum = new Forum();
		forum.setForumContent("forum");
		forum.setForumId(123);
		forum.setForumName("forum");
		forum.setStatus("online");
		forum.setUserId(123);
		assertTrue("problem in adding CartItem", forumDAO.addForum(forum));
	}

	@Ignore
	@Test
	public void deleteForumTest() {
		Forum forum = (Forum) forumDAO.getForum(1);
		assertTrue("forum deleted", forumDAO.deleteForum(forum));
	}

	@Ignore
	@Test
	public void updateForumTest() {
		Forum forum = (Forum) forumDAO.getForum(2);
		forum.setForumContent("vanilla forum");
		forum.setForumName("vanilla name");
		assertTrue("forum is updated", forumDAO.updateForum(forum));
	}

	@Test
	public void getAllForumsTest() {
		List<Forum> forumList = (List<Forum>) forumDAO.getAllForums();
		assertNotNull("", forumList.get(0));
		for (Forum forum : forumList) {
			System.out.println(
					"forum name=" + forum.getForumName() + ":::" + "forum Contente::" + forum.getForumContent());

		}
	}

}
