package hu.my.coolproject.repository;

import java.util.List;

import hu.my.coolproject.domain.Rights;

public interface RightsRepository {
	public List<Rights> getAllRights();

	public void saveRights(Rights rights);

	public Rights getRightsByID(long id);

	public void deleteRights(Rights rights);
	
	public Rights getRightsByKeyText(String rightKeyText);
}
