package net.slipp.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.slipp.db.Database;

import org.junit.Test;

public class UserTest {
	
	//테스트코드 중복 제거
	public static User TEST_USER = new User("userId","password","name","javajigi@slipp.net");

	@Test
	public void matchPassword() {
		boolean result = TEST_USER.matchPassword("password");
		assertTrue(result);
	}
	
	@Test
	public void notmatchPassword() {
		boolean result = TEST_USER.matchPassword("password2");
		assertFalse(result);
	}
	
	@Test
	public void login() throws Exception{
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		assertTrue(User.login(TEST_USER.getUserId(),TEST_USER.getPassword()));
		
		//로그인성공
	}

	@Test(expected=UserNotFoundException.class)
	public void loginWhenNotExistedUser() throws Exception{
		User.login("userid2",TEST_USER.getPassword());
		
		//사용자 존재 안할시
	}
	
	@Test(expected=PasswordMismatchException.class)
	public void loginWhenPasswordMismatch() throws Exception{
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		User.login(TEST_USER.getUserId(),"password2");
		
		//비밀번호 틀림
	}
}
