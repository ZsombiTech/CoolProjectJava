package hu.my.coolproject.controllers;

import java.util.List;

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

import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.service.RightsService;

public class RightsController extends BaseController<Window> {
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox rightsKeyText;

	@Wire
	private Textbox rightsName;

	@Wire
	private Textbox rightsComment;

	@Wire
	private Grid rigthsList;

	private ListModel<Rights> allRightsListModel;

	@WireVariable("rightsServiceImpl")
	private transient RightsService rightsService;

	public void doAfterCompose(Window window) throws Exception {
		super.doAfterCompose(window);
		rigthsList.setRowRenderer(rightsRowRenderer());
		refreshRigthsList();
	}

	@Listen(Events.ON_CLICK + "=#save")
	public void save(Event event) {
		Rights right = new Rights();
		right.setKeyText(rightsKeyText.getValue());
		right.setName(rightsName.getValue());
		right.setComment(rightsComment.getValue());
		rightsService.saveRights(right);
		refreshRigthsList();

	}

	@Listen(Events.ON_CLICK + "=#decline")
	public void deleterow(Event event) {

	}

	public void refreshRigthsList() {
		List<Rights> rightList = rightsService.getAllRights();
		allRightsListModel = new ListModelList<>(rightList);
		rigthsList.setModel(allRightsListModel);
	}

	private RowRenderer<Rights> rightsRowRenderer() {
		return new RowRenderer<Rights>() {

			@Override
			public void render(Row row, Rights data, int index) throws Exception {
				// TODO Auto-generated method stub
				row.appendChild(new Label(data.getKeyText()));
				row.appendChild(new Label(data.getName()));
				row.appendChild(new Label(data.getComment()));
				final Button remove = new Button(null, "/images/decline2.png");
				remove.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
					public void onEvent(Event event) throws Exception {
						rightsService.deleteRights(data);
						refreshRigthsList();
					}
				});
				row.appendChild(remove);
			}

		};

	}
}
