package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ITEM_TYPES database table.
 * 
 */
@Entity
@Table(name="ITEM_TYPES")
@NamedQuery(name="ItemType.findAll", query="SELECT i FROM ItemType i")
public class ItemType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_TYPE_ID")
	private Integer itemTypeId;

	@Column(name="ITEM_TYPE_CODE")
	private String itemTypeCode;

	@Column(name="ITEM_TYPE_NAME")
	private String itemTypeName;

	@Column(name="NON_VEHICLE")
	private String nonVehicle;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="itemType")
	private List<Item> items;

	public ItemType() {
	}

	public Integer getItemTypeId() {
		return this.itemTypeId;
	}

	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemTypeCode() {
		return this.itemTypeCode;
	}

	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}

	public String getItemTypeName() {
		return this.itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public String getNonVehicle() {
		return this.nonVehicle;
	}

	public void setNonVehicle(String nonVehicle) {
		this.nonVehicle = nonVehicle;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setItemType(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setItemType(null);

		return item;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (itemTypeId != null ? itemTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ItemType)) {
			return false;
		}
		ItemType other = (ItemType) object;
		if ((this.itemTypeId == null && other.itemTypeId != null)
				|| (this.itemTypeId != null && !this.itemTypeId.equals(other.itemTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.ItemType[ orderNum=" + itemTypeId + " ]";
	}

}