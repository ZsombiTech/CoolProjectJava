package hu.my.coolproject.controllers;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.service.RanksService;
import hu.my.coolproject.service.RightsService;

public class RightsController  extends BaseController<Window>{
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox rightsKeyText;
	
	@Wire
	private Textbox rightsName;
	
	@Wire
	private Textbox rightsComment;
	
	@WireVariable("rightsServiceImpl")
	private transient RightsService rightsService;
	public void doAfterCompose(Window window) throws Exception{
		super.doAfterCompose(window);
		
		
	}
	@Listen(Events.ON_CLICK + "=#save")
	public void save(Event event) {
		Rights right = new Rights();
		right.setKeyText(rightsKeyText.getValue());
		right.setName(rightsName.getValue());
		right.setComment(rightsComment.getValue());
		rightsService.saveRights(right);
		
	}


}
