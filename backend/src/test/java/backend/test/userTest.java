
package backend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.User;

public class userTest
{
static User userDAO;
	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		userDAO= (User) annotationConfigApplicationContext.getBean("userDAO");
		}
	@Test
	public void saveUser() {
		User user=new User();
		user.setEmail("user@gmail.com");
		user.setFirstname("Ha");
		user.setLastname("Sa");
		user.setPassword("1234");
		user.setPhone("1289");
		user.setUid(122);
		assertTrue("problem in adding CartItem",userDAO.saveUser(user));

	
	}

	
		
	}