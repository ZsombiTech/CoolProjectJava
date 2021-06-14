package hu.my.coolproject.service;

import java.util.List;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.RightRanks;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.domain.RightsandRanks;

public interface RightsAndRanksService {
	public List<Ranks> getAllRanksID();
	public List<Rights> getRightsWithoutRanksRights(long ranksId);
	public List<Rights> getRightsWithRanksRights(long ranksId);
	public void saveRightsandRanks(RightRanks rightRanks);
	public void deleteRightsAndRanks(RightRanks rightRanks);
}