package hu.my.coolproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.my.coolproject.domain.User;
import hu.my.coolproject.repository.UserRepository;
import hu.my.coolproject.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAllUser() {
		return userRepository.getAllUser();
	}

	@Override
	public void saveUser(User user) {
		userRepository.saveUser(user);

	}

	@Override
	public User getUserByLoginName(String loginName) {
		return userRepository.getUserByLoginName(loginName);
	}

}
