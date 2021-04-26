package hu.my.coolproject.controllers;

import java.io.IOException;
import java.util.Locale;

import org.zkoss.util.Locales;
import org.zkoss.util.resource.Labels;
import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import hu.my.coolproject.domain.User;

@VariableResolver(DelegatingVariableResolver.class)
public class BaseController <T extends Component> extends SelectorComposer<T> {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MY_STORED_DATA = "my_stored_data";
	private static final String LOGIN_WIN = "loginWin";
    public static final String ENG = "en_US";
    public static final String HUN = "hu_HU";
	
	@Override
	public void doAfterCompose(T comp) throws Exception{
		super.doAfterCompose(comp);
        if(Sessions.getCurrent().getAttribute(Attributes.PREFERRED_LOCALE) == null){
            //changeLocale(Locales.getCurrent().toString());  igy lehet lekerdezni, hogy a felhasznalonal milyen nyelvi beallitasok vannak es az szerint allitani. itt csekkolni kell hogy a projektunk tamogatja-e a nyelvet. ha nem akkor kell egy alapertelmezett.
        	changeLocale(HUN); //alapertelmezett magyar
        }
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
	
    public void changeLocale(String localeString) throws IOException {
    	Session session = Sessions.getCurrent();
    	if(session.getAttribute(Attributes.PREFERRED_LOCALE) != null && session.getAttribute(Attributes.PREFERRED_LOCALE).equals(localeString)) {
    		return;
    	}
    	Locale locale = localeString.length() > 2 ? new Locale(localeString.substring(0,2),localeString.substring(3)) : new Locale(localeString);  
    	session.setAttribute(Attributes.PREFERRED_LOCALE, locale);
    	//Clients.reloadMessages(locale); ez az oldal frissitese nelkul csereli le a nyelvet. persze ha nem frissul nem latsz sokat de az uj betoltott szovegek mar mas nyelvuek
    	//Locales.setThreadLocal(locale);
    	Executions.sendRedirect(null);
    }
}
