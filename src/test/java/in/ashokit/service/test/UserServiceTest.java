package in.ashokit.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import in.ashokit.dao.UserDao;
import in.ashokit.service.UserService;

public class UserServiceTest {

	@Test
	public void getNameTest() {

		// creating mock obj
		UserDao userdaoMock = PowerMockito.mock(UserDao.class);

		// defining behaviour for mock obj
		when(userdaoMock.findNameById(101)).thenReturn("Raju");

		// injecting mock dao into service thru constructor
		UserService service = new UserService(userdaoMock);

		// calling service method
		String name = service.getName(101);

		// validate the result

		assertEquals("Raju", name);

	}

	@Test
	public void loginTest() {

		// create mock obj
		UserDao userDaoMock = PowerMockito.mock(UserDao.class);

		// define mock obj behaviour
		when(userDaoMock.findByEmailAndPwd("ashok@gmail.com", "admin")).thenReturn(true);

		// injecting mock obj into service
		UserService service = new UserService(userDaoMock);
		
		String status = service.login("ashok@gmail.com", "admin");
		
		assertEquals("SUCCESS", status);
	}
}
