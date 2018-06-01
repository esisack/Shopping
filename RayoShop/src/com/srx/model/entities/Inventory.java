package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INVENTORY database table.
 * 
 */
@Entity
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INVENTORY_ID")
	private int inventoryId;

	@Column(name="ATTR1_ID")
	private int attr1Id;

	@Column(name="ATTR2_ID")
	private int attr2Id;

	@Column(name="ATTR3_ID")
	private int attr3Id;

	@Column(name="CHANNEL_PRICE")
	private BigDecimal channelPrice;

	private int quantity;

	@Column(name="RETAIL_PRICE")
	private BigDecimal retailPrice;

	//bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name="BRANCH_ID")
	private Branch branch;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;

	public Inventory() {
	}

	public int getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getAttr1Id() {
		return this.attr1Id;
	}

	public void setAttr1Id(int attr1Id) {
		this.attr1Id = attr1Id;
	}

	public int getAttr2Id() {
		return this.attr2Id;
	}

	public void setAttr2Id(int attr2Id) {
		this.attr2Id = attr2Id;
	}

	public int getAttr3Id() {
		return this.attr3Id;
	}

	public void setAttr3Id(int attr3Id) {
		this.attr3Id = attr3Id;
	}

	public BigDecimal getChannelPrice() {
		return this.channelPrice;
	}

	public void setChannelPrice(BigDecimal channelPrice) {
		this.channelPrice = channelPrice;
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

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}