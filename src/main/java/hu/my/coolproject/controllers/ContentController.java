package hu.my.coolproject.controllers;

import java.io.IOException;

import org.zkoss.zhtml.Label;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Center;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Panel;

public class ContentController extends BaseController<Panel> {

	private static final long serialVersionUID = 8099713676502601356L;
	
	private static final String RANKS_PAGE = "/ranks.zul";
	private static final String RIGHTS_PAGE = "/rights.zul";
	private static final String RIGHTS_AND_RANKS_PAGE = "/rightsandranks.zul";
	private static final String CONTENT_PAGE = "/content.zul";
	private static final String WELCOME_PAGE = "/welcome.zul";
	
	@Wire
	private Label userName;
	
	@Wire
	private Center content;
	
	@Wire
	private Combobox languageCmbx;
	
	Include i = new Include();
	
	@Override
	public void doAfterCompose(Panel panel) throws Exception {
		super.doAfterCompose(panel);
		i.setParent(content);
		i.setSrc(WELCOME_PAGE);
		ListModelList<Comboitem> languageList = new ListModelList<>();
		//List<Comboitem> languageList = new ArrayList<>();
		String locale = getLocale();
		Comboitem ci = new Comboitem();
		Comboitem ci2 = new Comboitem();
		ci2.setLabel("HU");
		ci2.setValue(HUN);
		languageList.add(ci2);
		ci.setLabel("EN");
		ci.setValue(ENG);
		languageList.add(ci);
		languageCmbx.setModel(languageList);
		if (locale == "hu") {
			languageList.addSelection(ci2);
		}else {
			languageList.addSelection(ci);
		}
	}
	
	@Listen(Events.ON_CLICK + "=#signOut")
	public void signOut(Event event) {
		logOut();
		Executions.sendRedirect("/login.zul");
	}
	@Listen(Events.ON_CLICK + "=#home")
	public void home() { // fuggvenynev legyen nevesitve vagy ha nem kell kuka
			loadContent(WELCOME_PAGE);
		
	}
	@Listen(Events.ON_CLICK + "=#RanksNavigation")// "=#egyes" ??  legyen szepen elnevezve :)
	public void ranks() {// fuggvenynev legyen nevesitve vagy ha nem kell kuka
		loadContent(RANKS_PAGE);
		
	}
	@Listen(Events.ON_CLICK + "=#RightsNavigation")// "=#kettes" ??  legyen szepen elnevezve :)
	public void rights() {// fuggvenynev legyen nevesitve vagy ha nem kell kuka
		loadContent(RIGHTS_PAGE);
	}
	@Listen(Events.ON_CLICK + "=#RightsAndRanks")// "=#harmas" ??  legyen szepen elnevezve :)
	public void duoble() {// fuggvenynev legyen nevesitve vagy ha nem kell kuka
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
	@Listen(Events.ON_SELECT + "=#languageCmbx")
	public void selectLanguage() throws IOException {
		changeLocale(languageCmbx.getSelectedItem().getValue());
		languageCmbx.setSelectedItem(languageCmbx.getSelectedItem());
	}
}
