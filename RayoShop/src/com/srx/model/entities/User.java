package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findByMail", query = "SELECT u FROM User u WHERE u.mail = :mail"),
	@NamedQuery(name = "User.findByDocument", query = "SELECT u FROM User u WHERE u.document = :document") })

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int userId;

	private long document;

	private String enabled;

	private String mail;

	private String name;

	private String password;

	private int pin;

	@Column(name="USER_ROL")
	private String userRol;

	//bi-directional many-to-one association to Collection
	@OneToMany(mappedBy="user")
	private List<Collection> collections;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="user")
	private List<Company> companies;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="user")
	private List<Customer> customers;

	//bi-directional many-to-one association to Email
	@OneToMany(mappedBy="user")
	private List<Email> emails;

	//bi-directional many-to-one association to ItemWarning
	@OneToMany(mappedBy="user")
	private List<ItemWarning> itemWarnings;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="user")
	private List<Question> questions;

	//bi-directional many-to-one association to SecurityItem
	@OneToMany(mappedBy="user")
	private List<SecurityItem> securityItems;

	//bi-directional many-to-one association to ShopCart
	@OneToMany(mappedBy="user")
	private List<ShopCart> shopCarts;

	//bi-directional many-to-one association to UsersKarma
	@OneToMany(mappedBy="user1")
	private List<UserKarma> usersKarmas1;

	//bi-directional many-to-one association to UsersKarma
	@OneToMany(mappedBy="user2")
	private List<UserKarma> usersKarmas2;

	//bi-directional many-to-one association to UserPartner
	@OneToMany(mappedBy="user")
	private List<UserPartner> usersPartners;

	//bi-directional many-to-one association to Vendor
	@OneToMany(mappedBy="user")
	private List<Vendor> vendors;

	//bi-directional many-to-one association to WishList
	@OneToMany(mappedBy="user")
	private List<WishList> wishLists;

	//bi-directional many-to-one association to WishListLog
	@OneToMany(mappedBy="user")
	private List<WishListLog> wishListLogs;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getDocument() {
		return this.document;
	}

	public void setDocument(long document) {
		this.document = document;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getUserRol() {
		return this.userRol;
	}

	public void setUserRol(String userRol) {
		this.userRol = userRol;
	}

	public List<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	public Collection addCollection(Collection collection) {
		getCollections().add(collection);
		collection.setUser(this);

		return collection;
	}

	public Collection removeCollection(Collection collection) {
		getCollections().remove(collection);
		collection.setUser(null);

		return collection;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setUser(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setUser(null);

		return company;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setUser(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setUser(null);

		return customer;
	}

	public List<Email> getEmails() {
		return this.emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Email addEmail(Email email) {
		getEmails().add(email);
		email.setUser(this);

		return email;
	}

	public Email removeEmail(Email email) {
		getEmails().remove(email);
		email.setUser(null);

		return email;
	}

	public List<ItemWarning> getItemWarnings() {
		return this.itemWarnings;
	}

	public void setItemWarnings(List<ItemWarning> itemWarnings) {
		this.itemWarnings = itemWarnings;
	}

	public ItemWarning addItemWarning(ItemWarning itemWarning) {
		getItemWarnings().add(itemWarning);
		itemWarning.setUser(this);

		return itemWarning;
	}

	public ItemWarning removeItemWarning(ItemWarning itemWarning) {
		getItemWarnings().remove(itemWarning);
		itemWarning.setUser(null);

		return itemWarning;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setUser(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setUser(null);

		return question;
	}

	public List<SecurityItem> getSecurityItems() {
		return this.securityItems;
	}

	public void setSecurityItems(List<SecurityItem> securityItems) {
		this.securityItems = securityItems;
	}

	public SecurityItem addSecurityItem(SecurityItem securityItem) {
		getSecurityItems().add(securityItem);
		securityItem.setUser(this);

		return securityItem;
	}

	public SecurityItem removeSecurityItem(SecurityItem securityItem) {
		getSecurityItems().remove(securityItem);
		securityItem.setUser(null);

		return securityItem;
	}

	public List<ShopCart> getShopCarts() {
		return this.shopCarts;
	}

	public void setShopCarts(List<ShopCart> shopCarts) {
		this.shopCarts = shopCarts;
	}

	public ShopCart addShopCart(ShopCart shopCart) {
		getShopCarts().add(shopCart);
		shopCart.setUser(this);

		return shopCart;
	}

	public ShopCart removeShopCart(ShopCart shopCart) {
		getShopCarts().remove(shopCart);
		shopCart.setUser(null);

		return shopCart;
	}

	public List<UserKarma> getUsersKarmas1() {
		return this.usersKarmas1;
	}

	public void setUsersKarmas1(List<UserKarma> usersKarmas1) {
		this.usersKarmas1 = usersKarmas1;
	}

	public UserKarma addUsersKarmas1(UserKarma usersKarmas1) {
		getUsersKarmas1().add(usersKarmas1);
		usersKarmas1.setUser1(this);

		return usersKarmas1;
	}

	public UserKarma removeUsersKarmas1(UserKarma usersKarmas1) {
		getUsersKarmas1().remove(usersKarmas1);
		usersKarmas1.setUser1(null);

		return usersKarmas1;
	}

	public List<UserKarma> getUsersKarmas2() {
		return this.usersKarmas2;
	}

	public void setUsersKarmas2(List<UserKarma> usersKarmas2) {
		this.usersKarmas2 = usersKarmas2;
	}

	public UserKarma addUsersKarmas2(UserKarma usersKarmas2) {
		getUsersKarmas2().add(usersKarmas2);
		usersKarmas2.setUser2(this);

		return usersKarmas2;
	}

	public UserKarma removeUsersKarmas2(UserKarma usersKarmas2) {
		getUsersKarmas2().remove(usersKarmas2);
		usersKarmas2.setUser2(null);

		return usersKarmas2;
	}

	public List<UserPartner> getUsersPartners() {
		return this.usersPartners;
	}

	public void setUsersPartners(List<UserPartner> usersPartners) {
		this.usersPartners = usersPartners;
	}

	public UserPartner addUsersPartner(UserPartner usersPartner) {
		getUsersPartners().add(usersPartner);
		usersPartner.setUser(this);

		return usersPartner;
	}

	public UserPartner removeUsersPartner(UserPartner usersPartner) {
		getUsersPartners().remove(usersPartner);
		usersPartner.setUser(null);

		return usersPartner;
	}

	public List<Vendor> getVendors() {
		return this.vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public Vendor addVendor(Vendor vendor) {
		getVendors().add(vendor);
		vendor.setUser(this);

		return vendor;
	}

	public Vendor removeVendor(Vendor vendor) {
		getVendors().remove(vendor);
		vendor.setUser(null);

		return vendor;
	}

	public List<WishList> getWishLists() {
		return this.wishLists;
	}

	public void setWishLists(List<WishList> wishLists) {
		this.wishLists = wishLists;
	}

	public WishList addWishList(WishList wishList) {
		getWishLists().add(wishList);
		wishList.setUser(this);

		return wishList;
	}

	public WishList removeWishList(WishList wishList) {
		getWishLists().remove(wishList);
		wishList.setUser(null);

		return wishList;
	}

	public List<WishListLog> getWishListLogs() {
		return this.wishListLogs;
	}

	public void setWishListLogs(List<WishListLog> wishListLogs) {
		this.wishListLogs = wishListLogs;
	}

	public WishListLog addWishListLog(WishListLog wishListLog) {
		getWishListLogs().add(wishListLog);
		wishListLog.setUser(this);

		return wishListLog;
	}

	public WishListLog removeWishListLog(WishListLog wishListLog) {
		getWishListLogs().remove(wishListLog);
		wishListLog.setUser(null);

		return wishListLog;
	}

}