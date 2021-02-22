package hu.my.coolproject.controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

@VariableResolver(DelegatingVariableResolver.class)
public class BaseController <T extends Component> extends SelectorComposer<T> {
	
	
	
	@Override
	public void doAfterCompose(T comp) throws Exception{
		super.doAfterCompose(comp);
		
	}
}
