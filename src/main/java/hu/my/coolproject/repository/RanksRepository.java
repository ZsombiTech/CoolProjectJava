package hu.my.coolproject.repository;

import java.util.List;


import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.Rights;

public interface RanksRepository {
	public List<Ranks> getAllRanks();

	public void saveRanks(Ranks ranks);

	public Ranks getRankByID(long id);
	
	public void deleteRanks(Ranks ranks);
}
