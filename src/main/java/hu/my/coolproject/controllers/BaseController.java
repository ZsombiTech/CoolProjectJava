package hu.my.coolproject.controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import hu.my.coolproject.domain.User;

@VariableResolver(DelegatingVariableResolver.class)
public class BaseController <T extends Component> extends SelectorComposer<T> {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MY_STORED_DATA = "my_stored_data";
	private static final String LOGIN_WIN = "loginWin";
	
	@Override
	public void doAfterCompose(T comp) throws Exception{
		super.doAfterCompose(comp);
		
		if (!LOGIN_WIN.equals(comp.getId()) && getSessionUser() == null) {
			Executions.sendRedirect("/login.zul");
		}
	}
	
	public void login(User user){
		Session session = Sessions.getCurrent();
		session.setAttribute(MY_STORED_DATA, user);
	}
	
	public void logOut(){
		Session session = Sessions.getCurrent();
		session.removeAttribute(MY_STORED_DATA);
	}
	
	private User getSessionUser(){
		Session session = Sessions.getCurrent();
		Object o = session.getAttribute(MY_STORED_DATA);
		return o == null ? null : (User)o;
		
	}
}
