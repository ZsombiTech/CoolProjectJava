package hu.my.coolproject.service;

import java.util.List;

import hu.my.coolproject.domain.Rights;

public interface RightsService {
	public List<Rights> getAllRights();

	public void saveRights(Rights rights);

	public Rights getRightsByID(long id);

}
