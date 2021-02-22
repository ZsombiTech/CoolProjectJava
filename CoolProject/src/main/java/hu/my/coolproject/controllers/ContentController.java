package hu.my.coolproject.controllers;

import org.zkoss.zhtml.Label;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Panel;

public class ContentController extends BaseController<Panel> {

	@Wire
	private Label userName;

	@Override
	public void doAfterCompose(Panel panel) throws Exception {
		super.doAfterCompose(panel);

	}

	@Listen(Events.ON_CLICK + "=#signOut")
	public void signOut(Event event) {
		Executions.sendRedirect("/login.zul");
	}
}
