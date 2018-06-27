package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SHOP_CARTS database table.
 * 
 */
@Entity
@Table(name="SHOP_CARTS")
@NamedQueries({@NamedQuery(name="ShopCart.findAll", query="SELECT s FROM ShopCart s"),
	@NamedQuery(name="ShopCart.findByUser", query="SELECT s FROM ShopCart s JOIN s.user u WHERE u.userId = :userId")})
public class ShopCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SHOP_CART_ID")
	private int shopCartId;

	@Column(name="CHANNEL_PRICE")
	private BigDecimal channelPrice;

	@Column(name="FINAL_PRICE")
	private BigDecimal finalPrice;

	private int quantity;

	@Column(name="RETAIL_PRICE")
	private BigDecimal retailPrice;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public ShopCart() {
	}

	public int getShopCartId() {
		return this.shopCartId;
	}

	public void setShopCartId(int shopCartId) {
		this.shopCartId = shopCartId;
	}

	public BigDecimal getChannelPrice() {
		return this.channelPrice;
	}

	public void setChannelPrice(BigDecimal channelPrice) {
		this.channelPrice = channelPrice;
	}

	public BigDecimal getFinalPrice() {
		return this.finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}