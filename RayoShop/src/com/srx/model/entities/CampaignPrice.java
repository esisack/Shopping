package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CAMPAIGN_PRICES database table.
 * 
 */
@Entity
@Table(name="CAMPAIGN_PRICES")
@NamedQuery(name="CampaignPrice.findAll", query="SELECT c FROM CampaignPrice c")
public class CampaignPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAMPAIGN_PRICE_ID")
	private int campaignPriceId;

	private int days;

	private String price;

	private int visitors;

	private String visivility;

	//bi-directional many-to-one association to CampaignType
	@ManyToOne
	@JoinColumn(name="CAMPAIGN_TYPE_ID")
	private CampaignType campaignType;

	public CampaignPrice() {
	}

	public int getCampaignPriceId() {
		return this.campaignPriceId;
	}

	public void setCampaignPriceId(int campaignPriceId) {
		this.campaignPriceId = campaignPriceId;
	}

	public int getDays() {
		return this.days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getVisitors() {
		return this.visitors;
	}

	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}

	public String getVisivility() {
		return this.visivility;
	}

	public void setVisivility(String visivility) {
		this.visivility = visivility;
	}

	public CampaignType getCampaignType() {
		return this.campaignType;
	}

	public void setCampaignType(CampaignType campaignType) {
		this.campaignType = campaignType;
	}

}