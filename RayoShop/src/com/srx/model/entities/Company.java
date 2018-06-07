package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the COMPANIES database table.
 * 
 */
@Entity
@Table(name = "COMPANIES")
@NamedQueries({ @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
		@NamedQuery(name = "Company.findByUser", query = "SELECT c FROM Company c JOIN c.user u WHERE u.userId = :userId") })
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_ID")
	private int companyId;

	private String address;

	@Column(name = "BUSINESS_NAME")
	private String businessName;

	@Column(name = "CEL_PHONE")
	private String celPhone;

	private String city;

	private String contact;

	@Column(name = "COVER_PAGE")
	private String coverPage;

	private String enabled;

	@Column(name = "FISCAL_NAME")
	private String fiscalName;

	private String latitude;

	private String logo;

	private String longitude;

	private String mail;

	private String phone;

	private long tin;

	// bi-directional many-to-one association to Balance
	@OneToMany(mappedBy = "company")
	private List<Balance> balances;

	// bi-directional many-to-one association to Branch
	@OneToMany(mappedBy = "company")
	private List<Branch> branches;

	// bi-directional many-to-one association to Campaign
	@OneToMany(mappedBy = "company")
	private List<Campaign> campaigns;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	// bi-directional many-to-one association to FiscalPosition
	@ManyToOne
	@JoinColumn(name = "FISCAL_POSITION_ID")
	private FiscalPosition fiscalPosition;

	// bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name = "PLAN_ID")
	private Plan plan;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	// bi-directional many-to-one association to CompanyOrder
	@OneToMany(mappedBy = "company")
	private List<CompanyOrder> companyOrders;

	// bi-directional many-to-one association to CompanyPayment
	@OneToMany(mappedBy = "company")
	private List<CompanyPayment> companyPayments;

	// bi-directional many-to-one association to Item
	@OneToMany(mappedBy = "company")
	private List<Item> items;

	// bi-directional many-to-one association to OfficialStore
	@OneToMany(mappedBy = "company")
	private List<OfficialStore> officialStores;

	// bi-directional many-to-one association to Vendor
	@OneToMany(mappedBy = "company")
	private List<Vendor> vendors;

	public Company() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCelPhone() {
		return this.celPhone;
	}

	public void setCelPhone(String celPhone) {
		this.celPhone = celPhone;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCoverPage() {
		return this.coverPage;
	}

	public void setCoverPage(String coverPage) {
		this.coverPage = coverPage;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getFiscalName() {
		return this.fiscalName;
	}

	public void setFiscalName(String fiscalName) {
		this.fiscalName = fiscalName;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getTin() {
		return this.tin;
	}

	public void setTin(long tin) {
		this.tin = tin;
	}

	public List<Balance> getBalances() {
		return this.balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	public Balance addBalance(Balance balance) {
		getBalances().add(balance);
		balance.setCompany(this);

		return balance;
	}

	public Balance removeBalance(Balance balance) {
		getBalances().remove(balance);
		balance.setCompany(null);

		return balance;
	}

	public List<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setCompany(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setCompany(null);

		return branch;
	}

	public List<Campaign> getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public Campaign addCampaign(Campaign campaign) {
		getCampaigns().add(campaign);
		campaign.setCompany(this);

		return campaign;
	}

	public Campaign removeCampaign(Campaign campaign) {
		getCampaigns().remove(campaign);
		campaign.setCompany(null);

		return campaign;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public FiscalPosition getFiscalPosition() {
		return this.fiscalPosition;
	}

	public void setFiscalPosition(FiscalPosition fiscalPosition) {
		this.fiscalPosition = fiscalPosition;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CompanyOrder> getCompanyOrders() {
		return this.companyOrders;
	}

	public void setCompanyOrders(List<CompanyOrder> companyOrders) {
		this.companyOrders = companyOrders;
	}

	public CompanyOrder addCompanyOrder(CompanyOrder companyOrder) {
		getCompanyOrders().add(companyOrder);
		companyOrder.setCompany(this);

		return companyOrder;
	}

	public CompanyOrder removeCompanyOrder(CompanyOrder companyOrder) {
		getCompanyOrders().remove(companyOrder);
		companyOrder.setCompany(null);

		return companyOrder;
	}

	public List<CompanyPayment> getCompanyPayments() {
		return this.companyPayments;
	}

	public void setCompanyPayments(List<CompanyPayment> companyPayments) {
		this.companyPayments = companyPayments;
	}

	public CompanyPayment addCompanyPayment(CompanyPayment companyPayment) {
		getCompanyPayments().add(companyPayment);
		companyPayment.setCompany(this);

		return companyPayment;
	}

	public CompanyPayment removeCompanyPayment(CompanyPayment companyPayment) {
		getCompanyPayments().remove(companyPayment);
		companyPayment.setCompany(null);

		return companyPayment;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setCompany(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setCompany(null);

		return item;
	}

	public List<OfficialStore> getOfficialStores() {
		return this.officialStores;
	}

	public void setOfficialStores(List<OfficialStore> officialStores) {
		this.officialStores = officialStores;
	}

	public OfficialStore addOfficialStore(OfficialStore officialStore) {
		getOfficialStores().add(officialStore);
		officialStore.setCompany(this);

		return officialStore;
	}

	public OfficialStore removeOfficialStore(OfficialStore officialStore) {
		getOfficialStores().remove(officialStore);
		officialStore.setCompany(null);

		return officialStore;
	}

	public List<Vendor> getVendors() {
		return this.vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public Vendor addVendor(Vendor vendor) {
		getVendors().add(vendor);
		vendor.setCompany(this);

		return vendor;
	}

	public Vendor removeVendor(Vendor vendor) {
		getVendors().remove(vendor);
		vendor.setCompany(null);

		return vendor;
	}

}