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
	private String readRight;

	@Column(name = "MODFIFY_RIGHT", nullable = false)
	private String modifyRight;

	public String getReadRight() {
		return readRight;
	}

	public void setReadRight(String readRight) {
		this.readRight = readRight;
	}

	public RightsRankID getRightRankID() {
		return rightRankID;
	}

	public void setRightRankID(RightsRankID rightRankID) {
		this.rightRankID = rightRankID;
	}

	public String getModifyRight() {
		return modifyRight;
	}

	public void setModifyRight(String modifyRight) {
		this.modifyRight = modifyRight;
	}

}
