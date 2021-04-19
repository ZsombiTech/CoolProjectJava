package hu.my.coolproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zhtml.Label;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Include;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Window;

import hu.my.coolproject.domain.User;

public class ContentController extends BaseController<Panel> {

	@Wire
	private Label userName;
	
	@Wire
	private Center content;
	
	Window Dealer;
	@Override
	public void doAfterCompose(Panel panel) throws Exception {
		super.doAfterCompose(panel);
	
	}

	@Listen(Events.ON_CLICK + "=#signOut")
	public void signOut(Event event) {
		Executions.sendRedirect("/login.zul");
	}
	@Listen(Events.ON_CLICK + "=#home")
	public void send() {
			Executions.sendRedirect("/content.zul");
		
	}
	@Listen(Events.ON_CLICK + "=#egyes")
	public void send2() {
			Executions.sendRedirect("/ranks.zul");
		
	}
	@Listen(Events.ON_CLICK + "=#kettes")
	public void send3() {
		Executions.sendRedirect("/rights.zul");
	}
	@Listen(Events.ON_CLICK + "=#harmas")
	public void send4() {
			Executions.sendRedirect("/rightsandranks.zul");
		
	}
	@Listen(Events.ON_CLICK + "=#about")
	public void send5() {
			Executions.sendRedirect("/content.zul");
		
	}
	@Listen(Events.ON_CLICK + "=#contact")
	public void send6() {
			Executions.sendRedirect("/content.zul");
		
	}
	
}
