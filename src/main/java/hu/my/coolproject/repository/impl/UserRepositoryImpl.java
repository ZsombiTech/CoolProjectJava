package hu.my.coolproject.repository.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import hu.my.coolproject.base.DbSessionProvider;
import hu.my.coolproject.domain.User;
import hu.my.coolproject.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends DbSessionProvider implements UserRepository{

	@Override
	public List<User> getAllUser() {
		return getCoolProjectSession().createQuery("FROM User a", User.class).getResultList();
	}

	@Override
	public void saveUser(User user) {
		getCoolProjectSession().merge(user);
		
	}

	@Override
	public User getUserByLoginName(String loginName) {
		String hql = "SELECT a FROM User a WHERE a.loginName = :loginName";
		try {
			return getCoolProjectSession().createQuery(hql, User.class).setParameter("loginName", loginName).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
