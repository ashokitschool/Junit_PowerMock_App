package in.ashokit.dao;

public interface UserDao {

	public String findNameById(Integer id);

	public boolean findByEmailAndPwd(String email, String pwd);
}
