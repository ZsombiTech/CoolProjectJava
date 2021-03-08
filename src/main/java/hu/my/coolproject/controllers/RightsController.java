package hu.my.coolproject.controllers;

import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class RightsController  extends BaseController<Window>{
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox rightsUS;
	
	@Wire
	private Textbox rightsRI;
	

	public void doAfterCompose(Window window) throws Exception{
		super.doAfterCompose(window);
		
		
	}

}
