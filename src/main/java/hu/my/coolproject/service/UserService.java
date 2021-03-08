package hu.my.coolproject.service;

import java.util.List;

import org.zkoss.zul.Textbox;

import hu.my.coolproject.domain.User;

public interface UserService {
	public List<User> getAllUser();

	public void saveUser(User user);

	public User getUserByLoginName(String loginName);

}
