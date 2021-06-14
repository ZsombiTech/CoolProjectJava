package hu.my.coolproject.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.annotation.Command;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.RightRanks;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.domain.RightsRankID;
import hu.my.coolproject.service.RanksService;
import hu.my.coolproject.service.RightsAndRanksService;

public class RigthsandRanksController extends BaseController<Window> {

	private static final long serialVersionUID = 1L;

	@Wire
	private Combobox ranksCmbx;

	@Wire
	private Listbox left;
	@Wire
	private Listbox right;

	@WireVariable("ranksServiceImpl")
	private transient RanksService ranksService;

	@WireVariable("rightsAndRanksServiceImpl")
	private transient RightsAndRanksService rightsAndRanksService;

	private ListModelList<Ranks> rightAndsRanksList = new ListModelList<>();

	private ListModelList<Rights> leftListModel = new ListModelList<>();
	private ListModelList<Rights> rightListModel = new ListModelList<>();

	public void doAfterCompose(Window window) throws Exception {
		super.doAfterCompose(window);
		initRanksCmbx();
		left.setModel(leftListModel);
		right.setModel(rightListModel);
		leftListModel
				.addAll(rightsAndRanksService.getRightsWithoutRanksRights(rightAndsRanksList.getElementAt(0).getId()));
		rightListModel
				.addAll(rightsAndRanksService.getRightsWithRanksRights(rightAndsRanksList.getElementAt(0).getId()));

	}

	private void initRanksCmbx() {
		List<Ranks> rankList = ranksService.getAllRanks();
		rightAndsRanksList.addAll(rankList);
		ranksCmbx.setModel(rightAndsRanksList);
		ranksCmbx.setItemRenderer(ranksComboRenderer());
		rightAndsRanksList.addToSelection(rightAndsRanksList.get(0));
	}
	
	private void addItems() {
		ranksCmbx.setModel(rightAndsRanksList);
	}

	private ListModelList<String> createListModel(String... labels) {
		ListModelList<String> listModelList = new ListModelList<String>();
		listModelList.setMultiple(true);
		return listModelList;
	}

	private ComboitemRenderer<Ranks> ranksComboRenderer() {
		return new ComboitemRenderer<Ranks>() {
			@Override
			public void render(Comboitem item, Ranks data, int index) throws Exception {
				item.setLabel(data.getName());
			}
		};
	}

	@Listen(Events.ON_CLICK + "=#jobb")
	public void addProjects() {
		Set<Rights> selectedRights = leftListModel.getSelection();

		RightRanks rightRanks = new RightRanks();
		RightsRankID id = new RightsRankID();
		
		List<Rights> selectedRightsArray = new ArrayList<>(selectedRights);
		id.setRights(selectedRightsArray.get(0));
		id.setRanks(rightAndsRanksList.get(ranksCmbx.getSelectedIndex()));
		rightRanks.setRightRankID(id);
		rightsAndRanksService.saveRightsandRanks(rightRanks);
		
		rightListModel.addAll(selectedRights);
		leftListModel.removeAll(selectedRights);
	}

	@Command
	public void removeProjects() {
	

	}

	public void moveSelection(ListModelList<String> origin, ListModelList<String> destination, String failMessage) {
		Set<String> selection = origin.getSelection();
		if (selection.isEmpty()) {
			Clients.showNotification(failMessage, "info", null, null, 2000, true);
		} else {
			destination.addAll(selection);
			origin.removeAll(selection);
		}
	}

	/*
	 * public ListModelList<String> getLeftListModel() { return leftListModel; }
	 * 
	 * public ListModelList<String> getRightListModel() { return rightListModel; }
	 */
	
    @Listen(Events.ON_SELECT + "=#ranksCmbx")
    public void selectName() throws IOException {
        refreshLists();
    }
	
    public void refreshLists() {
        rightListModel.clear();
        leftListModel.clear();
        rightListModel.addAll(rightsAndRanksService.getRightsWithRanksRights(rightAndsRanksList.get(ranksCmbx.getSelectedIndex()).getId()));
        leftListModel.addAll(rightsAndRanksService.getRightsWithoutRanksRights(rightAndsRanksList.get(ranksCmbx.getSelectedIndex()).getId()));
    }

}
