package hu.my.coolproject.repository;

import java.util.List;

import hu.my.coolproject.domain.User;

public interface  UserRepository {
	public List<User> getAllUser();
	public void saveUser(User user);
	public User getUserByLoginName(String loginName);
}
