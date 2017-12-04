package dao;

import java.util.List;

import model.User;

public interface userDAO {

	public List<User> getAllUser();

	public boolean saveUser(User user);

	public User getByEmail(String email);

}
