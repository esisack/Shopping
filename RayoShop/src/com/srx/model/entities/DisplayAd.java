package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DISPLAY_ADS database table.
 * 
 */
@Entity
@Table(name="DISPLAY_ADS")
@NamedQuery(name="DisplayAd.findAll", query="SELECT d FROM DisplayAd d")
public class DisplayAd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DISPLAY_AD_ID")
	private int displayAdId;

	private String description;

	private String picture;

	private String price;

	private String title;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	@JoinColumn(name="CAMPAIGN_ID")
	private Campaign campaign;

	public DisplayAd() {
	}

	public int getDisplayAdId() {
		return this.displayAdId;
	}

	public void setDisplayAdId(int displayAdId) {
		this.displayAdId = displayAdId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

}