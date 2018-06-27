package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ITEM_ATTRIBUTES database table.
 * 
 */
@Entity
@Table(name="ITEM_ATTRIBUTES")
@NamedQuery(name="ItemAttribute.findAll", query="SELECT i FROM ItemAttribute i")
public class ItemAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ATTRIBUTE_ID")
	private int itemAttributeId;

	@Column(name="INT_VALUE")
	private BigDecimal intValue;

	@Column(name="STRING_VALUE")
	private String stringValue;

	//bi-directional many-to-one association to Attribute
	@ManyToOne
	@JoinColumn(name="ATTRIBUTE_ID")
	private Attribute attribute;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;

	public ItemAttribute() {
	}

	public int getItemAttributeId() {
		return this.itemAttributeId;
	}

	public void setItemAttributeId(int itemAttributeId) {
		this.itemAttributeId = itemAttributeId;
	}

	public BigDecimal getIntValue() {
		return this.intValue;
	}

	public void setIntValue(BigDecimal intValue) {
		this.intValue = intValue;
	}

	public String getStringValue() {
		return this.stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}