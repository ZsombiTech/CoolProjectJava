package hu.my.coolproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.repository.RanksRepository;
import hu.my.coolproject.repository.RightAndRanksRepository;
import hu.my.coolproject.service.RightsAndRanksService;

@Service
@Transactional
public class RightsAndRanksServiceImpl implements RightsAndRanksService{
	private final RightAndRanksRepository rightAndRanksRepository;
	
	
	public RightsAndRanksServiceImpl(RightAndRanksRepository rightAndRanksRepository) {
		this.rightAndRanksRepository = rightAndRanksRepository;
	}

	@Override
	public List<Ranks> getAllRanksID() {
		return rightAndRanksRepository.getAllRanksID();
	}

	@Override
	public List<Rights> getRightsWithoutRanksRights(long ranksId) {
		return  rightAndRanksRepository.getRightsWithoutRanksRights(ranksId);
	}

	@Override
	public List<Rights> getRightsWithRanksRights(long ranksId) {
		return  rightAndRanksRepository.getRightsWithRanksRights(ranksId);
	}
	
}
