package hu.my.coolproject.service;

import java.util.List;

import hu.my.coolproject.domain.Ranks;

public interface RanksService {
	
	public List<Ranks> getAllRanks();

	public void saveRanks(Ranks ranks);

	public Ranks getRankByID(long id);

}
