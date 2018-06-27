package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CAMPAIGN_TYPES database table.
 * 
 */
@Entity
@Table(name="CAMPAIGN_TYPES")
@NamedQuery(name="CampaignType.findAll", query="SELECT c FROM CampaignType c")
public class CampaignType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAMPAIGN_TYPE_ID")
	private int campaignTypeId;

	@Column(name="CAMPAIGN_TYPE_NAME")
	private String campaignTypeName;

	private String enabled;

	//bi-directional many-to-one association to Campaign
	@OneToMany(mappedBy="campaignType")
	private List<Campaign> campaigns;

	//bi-directional many-to-one association to CampaignPrice
	@OneToMany(mappedBy="campaignType")
	private List<CampaignPrice> campaignPrices;

	public CampaignType() {
	}

	public int getCampaignTypeId() {
		return this.campaignTypeId;
	}

	public void setCampaignTypeId(int campaignTypeId) {
		this.campaignTypeId = campaignTypeId;
	}

	public String getCampaignTypeName() {
		return this.campaignTypeName;
	}

	public void setCampaignTypeName(String campaignTypeName) {
		this.campaignTypeName = campaignTypeName;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public List<Campaign> getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public Campaign addCampaign(Campaign campaign) {
		getCampaigns().add(campaign);
		campaign.setCampaignType(this);

		return campaign;
	}

	public Campaign removeCampaign(Campaign campaign) {
		getCampaigns().remove(campaign);
		campaign.setCampaignType(null);

		return campaign;
	}

	public List<CampaignPrice> getCampaignPrices() {
		return this.campaignPrices;
	}

	public void setCampaignPrices(List<CampaignPrice> campaignPrices) {
		this.campaignPrices = campaignPrices;
	}

	public CampaignPrice addCampaignPrice(CampaignPrice campaignPrice) {
		getCampaignPrices().add(campaignPrice);
		campaignPrice.setCampaignType(this);

		return campaignPrice;
	}

	public CampaignPrice removeCampaignPrice(CampaignPrice campaignPrice) {
		getCampaignPrices().remove(campaignPrice);
		campaignPrice.setCampaignType(null);

		return campaignPrice;
	}

}