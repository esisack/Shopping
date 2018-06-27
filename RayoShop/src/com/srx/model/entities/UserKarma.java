package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERS_KARMA database table.
 * 
 */
@Entity
@Table(name="USERS_KARMA")
@NamedQuery(name="UserKarma.findAll", query="SELECT u FROM UserKarma u")
public class UserKarma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_KARMA_ID")
	private int userKarmaId;

	private String description;

	private int score;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="QUALIFIER_ID")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user2;

	public UserKarma() {
	}

	public int getUserKarmaId() {
		return this.userKarmaId;
	}

	public void setUserKarmaId(int userKarmaId) {
		this.userKarmaId = userKarmaId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}