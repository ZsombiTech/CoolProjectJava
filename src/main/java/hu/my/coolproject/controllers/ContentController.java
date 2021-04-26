package hu.my.coolproject.controllers;

import org.zkoss.zhtml.Label;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Center;
import org.zkoss.zul.Include;
import org.zkoss.zul.Panel;

public class ContentController extends BaseController<Panel> {

	private static final long serialVersionUID = 8099713676502601356L;
	
	private static final String RANKS_PAGE = "/ranks.zul";
	private static final String RIGHTS_PAGE = "/rights.zul";
	private static final String RIGHTS_AND_RANKS_PAGE = "/rightsandranks.zul";
	private static final String CONTENT_PAGE = "/content.zul";
	
	@Wire
	private Label userName;
	
	@Wire
	private Center content;
	
	Include i = new Include();
	
	@Override
	public void doAfterCompose(Panel panel) throws Exception {
		super.doAfterCompose(panel);
		i.setParent(content);
		i.setSrc(RANKS_PAGE);
	}

	@Listen(Events.ON_CLICK + "=#signOut")
	public void signOut(Event event) {
		logOut();
		Executions.sendRedirect("/login.zul");
	}
	@Listen(Events.ON_CLICK + "=#home")
	public void send() { // fuggvenynev legyen nevesitve vagy ha nem kell kuka
			Executions.sendRedirect(CONTENT_PAGE);
		
	}
	@Listen(Events.ON_CLICK + "=#egyes")// "=#egyes" ??  legyen szepen elnevezve :)
	public void send2() {// fuggvenynev legyen nevesitve vagy ha nem kell kuka
		loadContent(RANKS_PAGE);
		
	}
	@Listen(Events.ON_CLICK + "=#kettes")// "=#kettes" ??  legyen szepen elnevezve :)
	public void send3() {// fuggvenynev legyen nevesitve vagy ha nem kell kuka
		loadContent(RIGHTS_PAGE);
	}
	@Listen(Events.ON_CLICK + "=#harmas")// "=#harmas" ??  legyen szepen elnevezve :)
	public void send4() {// fuggvenynev legyen nevesitve vagy ha nem kell kuka
		loadContent(RIGHTS_AND_RANKS_PAGE);
		
	}
	@Listen(Events.ON_CLICK + "=#about")
	public void send5() {// fuggvenynev legyen nevesitve vagy ha nem kell kuka
			Executions.sendRedirect(CONTENT_PAGE);
		
	}
	@Listen(Events.ON_CLICK + "=#contact")
	public void send6() {// fuggvenynev legyen nevesitve vagy ha nem kell kuka
			Executions.sendRedirect(CONTENT_PAGE);
		
	}
	
	private void loadContent(String path) {
		i.setSrc(path); 
	}
}
