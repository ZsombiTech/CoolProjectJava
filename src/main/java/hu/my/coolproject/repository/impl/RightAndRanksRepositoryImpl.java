package hu.my.coolproject.repository.impl;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import hu.my.coolproject.base.DbSessionProvider;
import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.repository.RightAndRanksRepository;

@Repository
public class RightAndRanksRepositoryImpl  extends DbSessionProvider implements RightAndRanksRepository{
	@Override
	public List<Ranks> getAllRanksID() {
		return getCoolProjectSession().createQuery("FROM Ranks a", Ranks.class).getResultList();
	}
}
