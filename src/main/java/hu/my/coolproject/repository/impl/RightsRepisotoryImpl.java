package hu.my.coolproject.repository.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import hu.my.coolproject.base.DbSessionProvider;
import hu.my.coolproject.domain.Rights;
import hu.my.coolproject.repository.RightsRepository;

@Repository
public class RightsRepisotoryImpl extends DbSessionProvider implements RightsRepository{

	@Override
	public List<Rights> getAllRights() {
		return getCoolProjectSession().createQuery("FROM Rights a", Rights.class).getResultList();
	}

	@Override
	public void saveRights(Rights rights) {
		getCoolProjectSession().merge(rights);
		
	}

	@Override
	public Rights getRightsByID(long id) {
		String hql = "SELECT a FROM Rights a WHERE a.id = :id";
		Query<Rights> query = getCoolProjectSession().createQuery(hql, Rights.class);
		return query.setParameter("id", id).getSingleResult();
	}
}
