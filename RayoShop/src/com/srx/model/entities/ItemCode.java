package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ITEMS_CODE database table.
 * 
 */
@Entity
@Table(name="ITEMS_CODE")
@NamedQuery(name="ItemCode.findAll", query="SELECT i FROM ItemCode i")
public class ItemCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_CODE_ID")
	private int itemCodeId;

	@Column(name="ITEM_CODE_NAME")
	private String itemCodeName;

	@Column(name="ITEM_CODE_TYPE")
	private String itemCodeType;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;

	public ItemCode() {
	}

	public int getItemCodeId() {
		return this.itemCodeId;
	}

	public void setItemCodeId(int itemCodeId) {
		this.itemCodeId = itemCodeId;
	}

	public String getItemCodeName() {
		return this.itemCodeName;
	}

	public void setItemCodeName(String itemCodeName) {
		this.itemCodeName = itemCodeName;
	}

	public String getItemCodeType() {
		return this.itemCodeType;
	}

	public void setItemCodeType(String itemCodeType) {
		this.itemCodeType = itemCodeType;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}