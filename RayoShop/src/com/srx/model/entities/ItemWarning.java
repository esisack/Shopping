package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ITEM_WARNINGS database table.
 * 
 */
@Entity
@Table(name="ITEM_WARNINGS")
@NamedQuery(name="ItemWarning.findAll", query="SELECT i FROM ItemWarning i")
public class ItemWarning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_WARNING_ID")
	private int itemWarningId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public ItemWarning() {
	}

	public int getItemWarningId() {
		return this.itemWarningId;
	}

	public void setItemWarningId(int itemWarningId) {
		this.itemWarningId = itemWarningId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}