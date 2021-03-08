package hu.my.coolproject.base;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class DbSessionProvider {

	@Autowired
	@Qualifier("CoolProjectSessionFactory")
	private SessionFactory coolProjectSessionFactory;

	protected Session getCoolProjectSession() {
		return coolProjectSessionFactory.getCurrentSession();
	}

	public SessionFactory getCoolProjectSessionFactory() {
		return coolProjectSessionFactory;
	}
}
