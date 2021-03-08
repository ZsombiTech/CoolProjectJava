package hu.my.coolproject.service;

import java.util.List;

import org.zkoss.zul.Textbox;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.User;

public interface RanksService {
	public List<Ranks> getAllRanks();

	public void saveRanks(Ranks ranks);

	public Ranks getRankByID(long id);

}
