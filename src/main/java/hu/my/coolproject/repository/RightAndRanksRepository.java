package hu.my.coolproject.repository;

import java.util.List;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.RightsandRanks;

public interface RightAndRanksRepository {
	public List<Ranks> getAllRanksID();
}
