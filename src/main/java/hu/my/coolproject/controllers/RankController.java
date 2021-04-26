package hu.my.coolproject.controllers;

import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.domain.User;
import hu.my.coolproject.service.RanksService;
import hu.my.coolproject.service.UserService;

public class RankController extends BaseController<Window>{
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox rankTB;
	@Wire
	private Grid ranksGrd;
	
	private ListModel<Ranks> allRanksListModel;
	
	@WireVariable("ranksServiceImpl")
	private transient RanksService ranksService;
	@Override
	public void doAfterCompose(Window window) throws Exception{
		super.doAfterCompose(window);
		ranksGrd.setRowRenderer(rightsRowRenderer());
		refreshRanksList();
		
	}
	
	@Listen(Events.ON_CLICK + "=#save")
	public void save(Event event) {	
		if(ranksService.getRankByName(rankTB.getValue()) == null) {
			Ranks rank = new Ranks();
			rank.setName(rankTB.getValue());
			ranksService.saveRanks(rank);
			refreshRanksList();
		}else {
			rankTB.setErrorMessage("Te gombocfeju, nem szabad ugyanazt beirni");
		}
		
	}
	
	public void refreshRanksList() {
		List<Ranks> ranksList = ranksService.getAllRanks();
		allRanksListModel = new ListModelList<>(ranksList);
		ranksGrd.setModel(allRanksListModel);
	}
	
	public boolean validateInput() {
		boolean isValid = true;
		if (rankTB.getValue() == null || rankTB.getValue().equals("")) {
			isValid = false;
			rankTB.setErrorMessage("Valamit be kell irni ");
		}
		return isValid;
	}
	
	private RowRenderer<Ranks> rightsRowRenderer() {
		return new RowRenderer<Ranks>() {

			@Override
			public void render(Row row, Ranks data, int index) throws Exception {
				row.appendChild(new Label(data.getName()));
				final Button remove = new Button(null, "/images/decline2.png");
				remove.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
					public void onEvent(Event event) throws Exception {
						ranksService.deleteRanks(data);
						refreshRanksList();
					}
				});
				row.appendChild(new Label("modositas"));
				row.appendChild(remove);
			}

		};

	}
}
