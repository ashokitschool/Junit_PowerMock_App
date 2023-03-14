package in.ashokit.service;

import in.ashokit.dao.UserDao;

public class UserService {

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getName(Integer id) {
		String name = userDao.findNameById(id);
		return name;
	}

	public String login(String email, String pwd) {
		boolean status = userDao.findByEmailAndPwd(email, pwd);
		if (status) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}
}