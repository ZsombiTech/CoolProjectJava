package hu.my.coolproject.repository.impl;

import java.util.List;


import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import hu.my.coolproject.base.DbSessionProvider;
import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.repository.RanksRepository;

@Repository
public class RanksRepositoryImpl extends DbSessionProvider implements RanksRepository{

	@Override
	public List<Ranks> getAllRanks() {
		return getCoolProjectSession().createQuery("FROM Ranks a", Ranks.class).getResultList();
	}

	@Override
	public void saveRanks(Ranks ranks) {
		getCoolProjectSession().merge(ranks);
		
	}

	@Override
	public Ranks getRankByID(long id) {
		String hql = "SELECT a FROM Ranks a WHERE a.id = :id";
		Query<Ranks> query = getCoolProjectSession().createQuery(hql, Ranks.class);
		return query.setParameter("id", id).getSingleResult();
		
	}
	@Override
	public void deleteRanks(Ranks ranks) {
		getCoolProjectSession().delete(ranks);
		
	}
}
