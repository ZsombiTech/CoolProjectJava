package hu.my.coolproject.repository;

import java.util.List;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.Rights;

public interface RightAndRanksRepository {
	public List<Ranks> getAllRanksID();
	public List<Rights> getRightsWithoutRanksRights(long ranksId);
	List<Rights> getRightsWithRanksRights(long ranksId);
	
}
