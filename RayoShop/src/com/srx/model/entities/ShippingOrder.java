package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SHIPPING_ORDERS database table.
 * 
 */
@Entity
@Table(name="SHIPPING_ORDERS")
@NamedQuery(name="ShippingOrder.findAll", query="SELECT s FROM ShippingOrder s")
public class ShippingOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SHIPPING_ORDER_ID")
	private int shippingOrderId;

	@Temporal(TemporalType.DATE)
	@Column(name="DELLIVERY_DAY")
	private Date delliveryDay;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_DATE")
	private Date orderDate;

	@Column(name="SHIPPING_COST")
	private BigDecimal shippingCost;

	//bi-directional many-to-one association to ShippingOrderDetail
	@OneToMany(mappedBy="shippingOrder")
	private List<ShippingOrderDetail> shippingOrdersDetails;

	public ShippingOrder() {
	}

	public int getShippingOrderId() {
		return this.shippingOrderId;
	}

	public void setShippingOrderId(int shippingOrderId) {
		this.shippingOrderId = shippingOrderId;
	}

	public Date getDelliveryDay() {
		return this.delliveryDay;
	}

	public void setDelliveryDay(Date delliveryDay) {
		this.delliveryDay = delliveryDay;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getShippingCost() {
		return this.shippingCost;
	}

	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	public List<ShippingOrderDetail> getShippingOrdersDetails() {
		return this.shippingOrdersDetails;
	}

	public void setShippingOrdersDetails(List<ShippingOrderDetail> shippingOrdersDetails) {
		this.shippingOrdersDetails = shippingOrdersDetails;
	}

	public ShippingOrderDetail addShippingOrdersDetail(ShippingOrderDetail shippingOrdersDetail) {
		getShippingOrdersDetails().add(shippingOrdersDetail);
		shippingOrdersDetail.setShippingOrder(this);

		return shippingOrdersDetail;
	}

	public ShippingOrderDetail removeShippingOrdersDetail(ShippingOrderDetail shippingOrdersDetail) {
		getShippingOrdersDetails().remove(shippingOrdersDetail);
		shippingOrdersDetail.setShippingOrder(null);

		return shippingOrdersDetail;
	}

}