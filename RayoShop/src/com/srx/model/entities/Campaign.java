package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CAMPAIGNS database table.
 * 
 */
@Entity
@Table(name="CAMPAIGNS")
@NamedQuery(name="Campaign.findAll", query="SELECT c FROM Campaign c")
public class Campaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAMPAIGN_ID")
	private int campaignId;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	private String status;

	//bi-directional many-to-one association to CampaignType
	@ManyToOne
	@JoinColumn(name="CAMPAIGN_TYPE_ID")
	private CampaignType campaignType;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	//bi-directional many-to-one association to DisplayAd
	@OneToMany(mappedBy="campaign")
	private List<DisplayAd> displayAds;

	//bi-directional many-to-one association to ItemAd
	@OneToMany(mappedBy="campaign")
	private List<ItemAd> itemAds;

	//bi-directional many-to-one association to TextAd
	@OneToMany(mappedBy="campaign")
	private List<TextAd> textAds;

	public Campaign() {
	}

	public int getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CampaignType getCampaignType() {
		return this.campaignType;
	}

	public void setCampaignType(CampaignType campaignType) {
		this.campaignType = campaignType;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<DisplayAd> getDisplayAds() {
		return this.displayAds;
	}

	public void setDisplayAds(List<DisplayAd> displayAds) {
		this.displayAds = displayAds;
	}

	public DisplayAd addDisplayAd(DisplayAd displayAd) {
		getDisplayAds().add(displayAd);
		displayAd.setCampaign(this);

		return displayAd;
	}

	public DisplayAd removeDisplayAd(DisplayAd displayAd) {
		getDisplayAds().remove(displayAd);
		displayAd.setCampaign(null);

		return displayAd;
	}

	public List<ItemAd> getItemAds() {
		return this.itemAds;
	}

	public void setItemAds(List<ItemAd> itemAds) {
		this.itemAds = itemAds;
	}

	public ItemAd addItemAd(ItemAd itemAd) {
		getItemAds().add(itemAd);
		itemAd.setCampaign(this);

		return itemAd;
	}

	public ItemAd removeItemAd(ItemAd itemAd) {
		getItemAds().remove(itemAd);
		itemAd.setCampaign(null);

		return itemAd;
	}

	public List<TextAd> getTextAds() {
		return this.textAds;
	}

	public void setTextAds(List<TextAd> textAds) {
		this.textAds = textAds;
	}

	public TextAd addTextAd(TextAd textAd) {
		getTextAds().add(textAd);
		textAd.setCampaign(this);

		return textAd;
	}

	public TextAd removeTextAd(TextAd textAd) {
		getTextAds().remove(textAd);
		textAd.setCampaign(null);

		return textAd;
	}

}