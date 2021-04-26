package hu.my.coolproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.repository.RanksRepository;
import hu.my.coolproject.service.RanksService;

@Service
@Transactional
public class RanksServiceImpl implements RanksService{

	private final RanksRepository ranksRepository;
	
	public RanksServiceImpl(RanksRepository ranksRepository) {
		this.ranksRepository = ranksRepository;
	}

	@Override
	public List<Ranks> getAllRanks() {
		return ranksRepository.getAllRanks();
	}

	@Override
	public void saveRanks(Ranks ranks) {
		ranksRepository.saveRanks(ranks);
		
	}

	@Override
	public Ranks getRankByID(long id) {
		return ranksRepository.getRankByID(id);
	}
	
	@Override
	public void deleteRanks(Ranks ranks) {
		ranksRepository.deleteRanks(ranks);
		
	}
}
