package hu.my.coolproject.controllers;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Notification;
import org.zkoss.zul.Button;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import hu.my.coolproject.domain.User;
import hu.my.coolproject.service.UserService;
import hu.my.coolproject.springutils.ApplicationContextProvider;

public class LoginController extends BaseController<Window>{
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox loginName;
	@Wire
	private Textbox password;
	@Wire
	private Button login;
	@Wire
    private Radiogroup rgType;
	//@WireVariable("userServiceImpl")
	private transient UserService userService;
	
	@Override
	public void doAfterCompose(Window window) throws Exception{
		super.doAfterCompose(window);
		userService = (UserService) ApplicationContextProvider.getBeanByName("userServiceImpl");
	}
	@Listen(Events.ON_CLICK + "=#login")
	public void send(Event event) {
		if(!validateInput()) {
			return;
		}
		User user = userService.getUserByLoginName(loginName.getValue());
		
		if(user.getPassword().equals(password.getValue())) {
			Executions.sendRedirect("/content.zul");

		}else {
			password.setValue(null);
			wrongPass();
		}
		
		
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
		return isValid;
	}
    public void wrongPass() {
        Notification.show("Your password is wrong, please try again!", true);
    }
	 
}
