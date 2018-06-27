package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERS_PARTNERS database table.
 * 
 */
@Entity
@Table(name="USERS_PARTNERS")
@NamedQuery(name="UserPartner.findAll", query="SELECT u FROM UserPartner u")
public class UserPartner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_PARTNER_ID")
	private int userPartnerId;

	@Column(name="PARTNER_ID")
	private int partnerId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public UserPartner() {
	}

	public int getUserPartnerId() {
		return this.userPartnerId;
	}

	public void setUserPartnerId(int userPartnerId) {
		this.userPartnerId = userPartnerId;
	}

	public int getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}