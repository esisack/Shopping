package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEXT_ADS database table.
 * 
 */
@Entity
@Table(name="TEXT_ADS")
@NamedQuery(name="TextAd.findAll", query="SELECT t FROM TextAd t")
public class TextAd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TEXT_AD_ID")
	private int textAdId;

	private String text;

	private String url;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	@JoinColumn(name="CAMPAIGN_ID")
	private Campaign campaign;

	public TextAd() {
	}

	public int getTextAdId() {
		return this.textAdId;
	}

	public void setTextAdId(int textAdId) {
		this.textAdId = textAdId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

}