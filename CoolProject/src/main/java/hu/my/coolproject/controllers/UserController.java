package hu.my.coolproject.controllers;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import hu.my.coolproject.domain.User;
import hu.my.coolproject.service.UserService;

public class UserController extends BaseController<Window>{
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox loginName;
	@Wire
	private Textbox password;
	@Wire
	private Textbox userName;
	@Wire
	private Textbox email;
	@Wire
	private Grid users;
	
	@WireVariable("userServiceImpl")
	private transient UserService userService;
	
	ListModelList<User> userListModel = new ListModelList<User>();
	@Override
	public void doAfterCompose(Window window) throws Exception{
		super.doAfterCompose(window);
		//userService = (UserService) ApplicationContextProvider.getBeanByName("userServiceImpl");
		users.setModel(userListModel);
		users.setRowRenderer(new RowRenderer<User>() {
			@Override
			public void render(Row row, User data, int index) throws Exception {
				row.appendChild(new Label(data.getLoginName()));
				row.appendChild(new Label(data.getPassword()));
				row.appendChild(new Label(data.getUserName()));
				row.appendChild(new Label(data.getEmail()));
			}
			});
		refreshList();
	}
	@Listen(Events.ON_CLICK + "=#submit")
	public void send(Event event) {
		if(!validateInput()) {
			return;
		}
		
		User user2 = new User();
		user2.setLoginName(loginName.getValue());
		user2.setPassword(password.getValue());
		user2.setUserName(userName.getValue());
		user2.setEmail(email.getValue());
		userService.saveUser(user2);
		refreshList();
		
		loginName.setValue("");
		password.setValue("");
		userName.setValue("");
		email.setValue("");
	}
	public boolean validateInput() {
		boolean isValid = true;
		if(loginName.getValue() == null || loginName.getValue() == "") {
			isValid = false;
			loginName.setErrorMessage("Valamit be kell irni ");
		}
		if(password.getValue() == null || password.getValue() == "") {
			isValid = false;
			password.setErrorMessage("Valamit be kell irni ");
		}
		if(userName.getValue() == null || userName.getValue() == "") {
			isValid = false;
			userName.setErrorMessage("Valamit be kell irni ");
		}
		if(email.getValue() == null || email.getValue() == "") {
			isValid = false;
			email.setErrorMessage("Valamit be kell irni ");
		}
		return isValid;
	}
	private void refreshList() {
		userListModel.clear();
		userListModel.addAll(userService.getAllUser());
	}
	
}
