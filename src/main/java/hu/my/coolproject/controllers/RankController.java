package hu.my.coolproject.controllers;

import org.zkoss.zk.ui.Executions;
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

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.User;
import hu.my.coolproject.service.RanksService;
import hu.my.coolproject.service.UserService;

public class RankController extends BaseController<Window>{
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox rankTB;
	
	@WireVariable("ranksServiceImpl")
	private transient RanksService ranksService;
	@Override
	public void doAfterCompose(Window window) throws Exception{
		super.doAfterCompose(window);
		
		
	}
	@Listen(Events.ON_CLICK + "=#save")
	public void save(Event event) {
		Ranks rank = new Ranks();
		rank.setName(rankTB.getValue());
		ranksService.saveRanks(rank);
		
	}

}
