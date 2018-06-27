package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ITEMS database table.
 * 
 */
@Entity
@Table(name="ITEMS")
@NamedQueries({ @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
	@NamedQuery(name = "Item.findByCompany", query = "SELECT i FROM Item i JOIN i.company c WHERE c.companyId = :companyId"),
	@NamedQuery(name = "Item.findByCategory", query = "SELECT i FROM Item i JOIN i.category c WHERE c.categoryId =:categoryId ") })

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private int itemId;

	@Column(name="CHANNEL_PRICE")
	private BigDecimal channelPrice;

	private String description;

	@Column(name="EIGHTH_PICTURE")
	private String eighthPicture;

	private String enabled;

	@Column(name="FIFTH_PICTURE")
	private String fifthPicture;

	@Column(name="FIRST_PICTURE")
	private String firstPicture;

	@Column(name="FOURTH_PICTURE")
	private String fourthPicture;

	@Column(name="ITEM_CODE")
	private String itemCode;

	@Column(name="ITEM_NAME")
	private String itemName;

	@Column(name="NINETH_PICTURE")
	private String ninethPicture;

	private String publish;

	@Column(name="RETAIL_PRICE")
	private BigDecimal retailPrice;

	@Column(name="SECOND_PICTURE")
	private String secondPicture;

	@Column(name="SEVENTH_PICTURE")
	private String seventhPicture;

	@Column(name="SIXTH_PICTURE")
	private String sixthPicture;

	private int stock;

	@Column(name="TENTH_PICTURE")
	private String tenthPicture;

	@Column(name="THIRD_PICTURE")
	private String thirdPicture;

	//bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy="item")
	private List<Inventory> inventories;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Category category;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	//bi-directional many-to-one association to ItemType
	@ManyToOne
	@JoinColumn(name="ITEM_TYPE_ID")
	private ItemType itemType;

	//bi-directional many-to-one association to Version
	@ManyToOne
	@JoinColumn(name="VERSION_ID")
	private Version version;

	//bi-directional many-to-one association to ItemCode
	@OneToMany(mappedBy="item")
	private List<ItemCode> itemsCodes;

	//bi-directional many-to-one association to ItemAd
	@OneToMany(mappedBy="item")
	private List<ItemAd> itemAds;

	//bi-directional many-to-one association to ItemAttribute
	@OneToMany(mappedBy="item")
	private List<ItemAttribute> itemAttributes;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="item")
	private List<Offer> offers;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="item")
	private List<OrderDetail> ordersDetails;

	//bi-directional many-to-one association to Picture
	@OneToMany(mappedBy="item")
	private List<Picture> pictures;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="item")
	private List<Question> questions;

	//bi-directional many-to-one association to ShopCart
	@OneToMany(mappedBy="item")
	private List<ShopCart> shopCarts;

	//bi-directional many-to-one association to WishList
	@OneToMany(mappedBy="item")
	private List<WishList> wishLists;

	//bi-directional many-to-one association to WishListLog
	@OneToMany(mappedBy="item")
	private List<WishListLog> wishListLogs;
	
	private int year;
	
	@Transient
	private Make make;
	
	@Transient
	private Model model;
	
	

	public Item() {
		firstPicture  = "camera-add-blue.png";
		secondPicture = "camera-add-blue.png";
		thirdPicture  = "camera-add-blue.png";
		fourthPicture = "camera-add-blue.png";
		fifthPicture  = "camera-add-blue.png";
		sixthPicture  = "camera-add-blue.png";
		seventhPicture = "camera-add-blue.png";
		eighthPicture = "camera-add-blue.png";
		ninethPicture = "camera-add-blue.png";
		tenthPicture  = "camera-add-blue.png";
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public BigDecimal getChannelPrice() {
		return this.channelPrice;
	}

	public void setChannelPrice(BigDecimal channelPrice) {
		this.channelPrice = channelPrice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEighthPicture() {
		return this.eighthPicture;
	}

	public void setEighthPicture(String eighthPicture) {
		this.eighthPicture = eighthPicture;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getFifthPicture() {
		return this.fifthPicture;
	}

	public void setFifthPicture(String fifthPicture) {
		this.fifthPicture = fifthPicture;
	}

	public String getFirstPicture() {
		return this.firstPicture;
	}

	public void setFirstPicture(String firstPicture) {
		this.firstPicture = firstPicture;
	}

	public String getFourthPicture() {
		return this.fourthPicture;
	}

	public void setFourthPicture(String fourthPicture) {
		this.fourthPicture = fourthPicture;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getNinethPicture() {
		return this.ninethPicture;
	}

	public void setNinethPicture(String ninethPicture) {
		this.ninethPicture = ninethPicture;
	}

	public String getPublish() {
		return this.publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public BigDecimal getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getSecondPicture() {
		return this.secondPicture;
	}

	public void setSecondPicture(String secondPicture) {
		this.secondPicture = secondPicture;
	}

	public String getSeventhPicture() {
		return this.seventhPicture;
	}

	public void setSeventhPicture(String seventhPicture) {
		this.seventhPicture = seventhPicture;
	}

	public String getSixthPicture() {
		return this.sixthPicture;
	}

	public void setSixthPicture(String sixthPicture) {
		this.sixthPicture = sixthPicture;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTenthPicture() {
		return this.tenthPicture;
	}

	public void setTenthPicture(String tenthPicture) {
		this.tenthPicture = tenthPicture;
	}

	public String getThirdPicture() {
		return this.thirdPicture;
	}

	public void setThirdPicture(String thirdPicture) {
		this.thirdPicture = thirdPicture;
	}

	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setItem(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setItem(null);

		return inventory;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public ItemType getItemType() {
		return this.itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	
	public Make getMake() {
		if (version != null) {
			make = version.getModel().getMake();
		}
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public Model getModel() {
		if (version != null) {
			model = version.getModel();
		}
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<ItemCode> getItemsCodes() {
		return this.itemsCodes;
	}

	public void setItemsCodes(List<ItemCode> itemsCodes) {
		this.itemsCodes = itemsCodes;
	}

	public ItemCode addItemsCode(ItemCode itemsCode) {
		getItemsCodes().add(itemsCode);
		itemsCode.setItem(this);

		return itemsCode;
	}

	public ItemCode removeItemsCode(ItemCode itemsCode) {
		getItemsCodes().remove(itemsCode);
		itemsCode.setItem(null);

		return itemsCode;
	}

	public List<ItemAd> getItemAds() {
		return this.itemAds;
	}

	public void setItemAds(List<ItemAd> itemAds) {
		this.itemAds = itemAds;
	}

	public ItemAd addItemAd(ItemAd itemAd) {
		getItemAds().add(itemAd);
		itemAd.setItem(this);

		return itemAd;
	}

	public ItemAd removeItemAd(ItemAd itemAd) {
		getItemAds().remove(itemAd);
		itemAd.setItem(null);

		return itemAd;
	}

	public List<ItemAttribute> getItemAttributes() {
		return this.itemAttributes;
	}

	public void setItemAttributes(List<ItemAttribute> itemAttributes) {
		this.itemAttributes = itemAttributes;
	}

	public ItemAttribute addItemAttribute(ItemAttribute itemAttribute) {
		getItemAttributes().add(itemAttribute);
		itemAttribute.setItem(this);

		return itemAttribute;
	}

	public ItemAttribute removeItemAttribute(ItemAttribute itemAttribute) {
		getItemAttributes().remove(itemAttribute);
		itemAttribute.setItem(null);

		return itemAttribute;
	}

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Offer addOffer(Offer offer) {
		getOffers().add(offer);
		offer.setItem(this);

		return offer;
	}

	public Offer removeOffer(Offer offer) {
		getOffers().remove(offer);
		offer.setItem(null);

		return offer;
	}

	public List<OrderDetail> getOrdersDetails() {
		return this.ordersDetails;
	}

	public void setOrdersDetails(List<OrderDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}

	public OrderDetail addOrdersDetail(OrderDetail ordersDetail) {
		getOrdersDetails().add(ordersDetail);
		ordersDetail.setItem(this);

		return ordersDetail;
	}

	public OrderDetail removeOrdersDetail(OrderDetail ordersDetail) {
		getOrdersDetails().remove(ordersDetail);
		ordersDetail.setItem(null);

		return ordersDetail;
	}

	public List<Picture> getPictures() {
		return this.pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public Picture addPicture(Picture picture) {
		getPictures().add(picture);
		picture.setItem(this);

		return picture;
	}

	public Picture removePicture(Picture picture) {
		getPictures().remove(picture);
		picture.setItem(null);

		return picture;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setItem(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setItem(null);

		return question;
	}

	public List<ShopCart> getShopCarts() {
		return this.shopCarts;
	}

	public void setShopCarts(List<ShopCart> shopCarts) {
		this.shopCarts = shopCarts;
	}

	public ShopCart addShopCart(ShopCart shopCart) {
		getShopCarts().add(shopCart);
		shopCart.setItem(this);

		return shopCart;
	}

	public ShopCart removeShopCart(ShopCart shopCart) {
		getShopCarts().remove(shopCart);
		shopCart.setItem(null);

		return shopCart;
	}

	public List<WishList> getWishLists() {
		return this.wishLists;
	}

	public void setWishLists(List<WishList> wishLists) {
		this.wishLists = wishLists;
	}

	public WishList addWishList(WishList wishList) {
		getWishLists().add(wishList);
		wishList.setItem(this);

		return wishList;
	}

	public WishList removeWishList(WishList wishList) {
		getWishLists().remove(wishList);
		wishList.setItem(null);

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
		wishListLog.setItem(this);

		return wishListLog;
	}

	public WishListLog removeWishListLog(WishListLog wishListLog) {
		getWishListLogs().remove(wishListLog);
		wishListLog.setItem(null);

		return wishListLog;
	}

}