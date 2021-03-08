package hu.my.coolproject.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RightsRankID implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RIGHTS_ID")
	private Rights rights;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RANKS_ID")
	private Ranks ranks;
	
	public Ranks getRanks() {
		return ranks;
	}
	public void setRanks(Ranks ranks) {
		this.ranks = ranks;
	}
	public Rights getRights() {
		return rights;
	}
	public void setRights(Rights rights) {
		this.rights = rights;
	}
}
