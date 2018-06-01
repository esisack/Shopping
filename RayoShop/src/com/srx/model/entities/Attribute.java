package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ATTRIBUTES database table.
 * 
 */
@Entity
@Table(name="ATTRIBUTES")
@NamedQuery(name="Attribute.findAll", query="SELECT a FROM Attribute a")
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ATTRIBUTE_ID")
	private int attributeId;

	@Column(name="ATTRIBUTE_NAME")
	private String attributeName;

	@Column(name="CATEGORY_ID")
	private int categoryId;

	private String query;

	private String stock;

	@Column(name="STRING_VALUE")
	private String stringValue;

	//bi-directional many-to-one association to AttributeList
	@OneToMany(mappedBy="attribute")
	private List<AttributeList> attributesLists;

	//bi-directional many-to-one association to ItemAttribute
	@OneToMany(mappedBy="attribute")
	private List<ItemAttribute> itemAttributes;

	public Attribute() {
	}

	public int getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getStock() {
		return this.stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getStringValue() {
		return this.stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public List<AttributeList> getAttributesLists() {
		return this.attributesLists;
	}

	public void setAttributesLists(List<AttributeList> attributesLists) {
		this.attributesLists = attributesLists;
	}

	public AttributeList addAttributesList(AttributeList attributesList) {
		getAttributesLists().add(attributesList);
		attributesList.setAttribute(this);

		return attributesList;
	}

	public AttributeList removeAttributesList(AttributeList attributesList) {
		getAttributesLists().remove(attributesList);
		attributesList.setAttribute(null);

		return attributesList;
	}

	public List<ItemAttribute> getItemAttributes() {
		return this.itemAttributes;
	}

	public void setItemAttributes(List<ItemAttribute> itemAttributes) {
		this.itemAttributes = itemAttributes;
	}

	public ItemAttribute addItemAttribute(ItemAttribute itemAttribute) {
		getItemAttributes().add(itemAttribute);
		itemAttribute.setAttribute(this);

		return itemAttribute;
	}

	public ItemAttribute removeItemAttribute(ItemAttribute itemAttribute) {
		getItemAttributes().remove(itemAttribute);
		itemAttribute.setAttribute(null);

		return itemAttribute;
	}

}