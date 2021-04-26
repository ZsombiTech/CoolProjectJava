package hu.my.coolproject.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Notification;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import hu.my.coolproject.domain.User;
import hu.my.coolproject.service.UserService;

public class LoginController extends BaseController<Window> {
	
	private static final long serialVersionUID = 1L;
	private static final String FIELD_IS_REQUIRED = "Field_is_required";
	
	@Wire
	private Textbox loginName;
	
	@Wire
	private Textbox password;
	
	@Wire
	private Button login;
	
	@Wire
	private Combobox languageCmbx;

	@WireVariable("userServiceImpl")
	private transient UserService userService;

	@Override
	public void doAfterCompose(Window window) throws Exception {
		super.doAfterCompose(window);
		ListModelList<Comboitem> languageList = new ListModelList<>();
		//List<Comboitem> languageList = new ArrayList<>();
		Comboitem ci = new Comboitem();
		ci.setLabel("HU");
		ci.setValue(HUN);
		languageList.add(ci);
		ci = new Comboitem();
		ci.setLabel("EN");
		ci.setValue(ENG);
		languageList.add(ci);
		languageCmbx.setModel(languageList);
	}

	@Listen(Events.ON_CLICK + "=#login")
	public void send(Event event) {
		if (!validateInput()) {
			return;
		}
		User user = userService.getUserByLoginName(loginName.getValue());

		if (user != null && user.getPassword().equals(password.getValue())) {
			login(user);
			Executions.sendRedirect("/content.zul");

		} else {
			password.setValue(null);
			wrongPass();
		}
	}

	public boolean validateInput() {
		boolean isValid = true;
		if (loginName.getValue() == null || loginName.getValue() == "") { // Hiba: loginName.getValue() == ""
			isValid = false;
			loginName.setErrorMessage(Labels.getLabel(FIELD_IS_REQUIRED));
		}
		if (password.getValue() == null || password.getValue() == "") { // Hiba password.getValue() == ""
			isValid = false;
			password.setErrorMessage(Labels.getLabel(FIELD_IS_REQUIRED));
		}
		return isValid;
	}

	public void wrongPass() {
		Notification.show(Labels.getLabel("Username_or_password_is_incorrect_please_try_again"), true);
	}
	
	@Listen(Events.ON_SELECT + "=#languageCmbx")
	public void selectLanguage() throws IOException {
		changeLocale(languageCmbx.getSelectedItem().getValue());
		languageCmbx.setSelectedItem(languageCmbx.getSelectedItem());
	}
}
