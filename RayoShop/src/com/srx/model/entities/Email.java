package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMAILS database table.
 * 
 */
@Entity
@Table(name="EMAILS")
@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMAIL_ID")
	private int emailId;

	private String offers;

	@Column(name="PUBLICATION_WARNING")
	private String publicationWarning;

	private String purchases;

	private String questions;

	private int sales;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public Email() {
	}

	public int getEmailId() {
		return this.emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public String getOffers() {
		return this.offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}

	public String getPublicationWarning() {
		return this.publicationWarning;
	}

	public void setPublicationWarning(String publicationWarning) {
		this.publicationWarning = publicationWarning;
	}

	public String getPurchases() {
		return this.purchases;
	}

	public void setPurchases(String purchases) {
		this.purchases = purchases;
	}

	public String getQuestions() {
		return this.questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}