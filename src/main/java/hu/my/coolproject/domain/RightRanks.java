package hu.my.coolproject.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rights_ranks")
public class RightRanks {
	
	@EmbeddedId
	private RightsRankID rightRankID;

	@Column(name = "READ_RIGHT", nullable = false)
	private boolean readRight;

	@Column(name = "MODIFY_RIGHT", nullable = false)
	private boolean modifyRight;

	public RightsRankID getRightRankID() {
		return rightRankID;
	}

	public void setRightRankID(RightsRankID rightRankID) {
		this.rightRankID = rightRankID;
	}

	public boolean isReadRight() {
		return readRight;
	}

	public void setReadRight(boolean readRight) {
		this.readRight = readRight;
	}

	public boolean isModifyRight() {
		return modifyRight;
	}

	public void setModifyRight(boolean modifyRight) {
		this.modifyRight = modifyRight;
	}

}
