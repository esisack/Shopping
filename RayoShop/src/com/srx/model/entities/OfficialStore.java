package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OFFICIAL_STORES database table.
 * 
 */
@Entity
@Table(name="OFFICIAL_STORES")
@NamedQuery(name="OfficialStore.findAll", query="SELECT o FROM OfficialStore o")
public class OfficialStore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OFFICIAL_STORE_ID")
	private int officialStoreId;

	private String background;

	private String enabled;

	private String logo;

	private String picture;

	private String slogan;

	private String title;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	public OfficialStore() {
	}

	public int getOfficialStoreId() {
		return this.officialStoreId;
	}

	public void setOfficialStoreId(int officialStoreId) {
		this.officialStoreId = officialStoreId;
	}

	public String getBackground() {
		return this.background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}