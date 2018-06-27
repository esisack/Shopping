package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ATTRIBUTES_LIST database table.
 * 
 */
@Entity
@Table(name="ATTRIBUTES_LIST")
@NamedQuery(name="AttributeList.findAll", query="SELECT a FROM AttributeList a")
public class AttributeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ATTRIBUTE_LIST_ID")
	private int attributeListId;

	@Column(name="INT_VALUE")
	private BigDecimal intValue;

	@Column(name="STRING_VALUE")
	private String stringValue;

	//bi-directional many-to-one association to Attribute
	@ManyToOne
	@JoinColumn(name="ATTRIBUTE_ID")
	private Attribute attribute;

	public AttributeList() {
	}

	public int getAttributeListId() {
		return this.attributeListId;
	}

	public void setAttributeListId(int attributeListId) {
		this.attributeListId = attributeListId;
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

}