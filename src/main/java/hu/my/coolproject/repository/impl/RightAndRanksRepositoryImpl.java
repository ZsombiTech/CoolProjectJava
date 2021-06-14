package hu.my.coolproject.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hu.my.coolproject.base.DbSessionProvider;
import hu.my.coolproject.domain.Ranks;
import hu.my.coolproject.domain.RightRanks;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.repository.RightAndRanksRepository;

@Repository
public class RightAndRanksRepositoryImpl  extends DbSessionProvider implements RightAndRanksRepository{
	@Override
	public List<Ranks> getAllRanksID() {
		return getCoolProjectSession().createQuery("FROM Ranks a", Ranks.class).getResultList();
	}
	@Override
	public List<Rights> getRightsWithoutRanksRights(long ranksId) {
		String hql = " SELECT r "+
				" FROM Rights r "+
				" LEFT JOIN RightRanks rr on r.id = rr.rightRankID.rights.id"+
				" WHERE rr.rightRankID.ranks.id <> :RanksID OR rr.rightRankID.ranks.id IS null";
		return getCoolProjectSession().createQuery(hql, Rights.class).setParameter("RanksID", ranksId).getResultList();
	}
	@Override
	public List<Rights> getRightsWithRanksRights(long ranksId) {
		String hql = "SELECT r "+
				" FROM Rights r "+
				" LEFT JOIN RightRanks rr on r.id = rr.rightRankID.rights.id"+
				" WHERE rr.rightRankID.ranks.id = :RanksID ";
		return getCoolProjectSession().createQuery(hql, Rights.class).setParameter("RanksID", ranksId).getResultList();
	}
	
	@Override
	public void saveRightsandRanks(RightRanks rightRanks) {
		getCoolProjectSession().merge(rightRanks);
	}
	@Override
	public void deleteRightsandRanks(RightRanks rightRanks) {
		getCoolProjectSession().delete(rightRanks);
	}
}
