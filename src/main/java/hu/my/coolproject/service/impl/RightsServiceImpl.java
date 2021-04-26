package hu.my.coolproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.repository.RightsRepository;
import hu.my.coolproject.service.RightsService;

@Service
@Transactional
public class RightsServiceImpl implements RightsService{

	private final RightsRepository rightsRepository;
	
	public RightsServiceImpl(RightsRepository rightsRepository) {
		this.rightsRepository = rightsRepository;
	}

	@Override
	public List<Rights> getAllRights() {
		return rightsRepository.getAllRights();
	}

	@Override
	public void saveRights(Rights rights) {
		rightsRepository.saveRights(rights);
		
	}

	@Override
	public Rights getRightsByID(long id) {
		return rightsRepository.getRightsByID(id);
	}

	@Override
	public void deleteRights(Rights rights) {
		rightsRepository.deleteRights(rights);
		
	}

	@Override
	public Rights getRightsByKeyText(String rightKeyText) {
		return rightsRepository.getRightsByKeyText(rightKeyText);
	}
	
		
}
