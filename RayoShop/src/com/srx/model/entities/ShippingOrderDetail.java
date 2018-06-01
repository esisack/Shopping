package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SHIPPING_ORDERS_DETAIL database table.
 * 
 */
@Entity
@Table(name="SHIPPING_ORDERS_DETAIL")
@NamedQuery(name="ShippingOrderDetail.findAll", query="SELECT s FROM ShippingOrderDetail s")
public class ShippingOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SHIPPING_ORDER_DETAIL_ID")
	private int shippingOrderDetailId;

	private String status;

	//bi-directional many-to-one association to OrderDetail
	@ManyToOne
	@JoinColumn(name="ORDER_DETAIL_ID")
	private OrderDetail ordersDetail;

	//bi-directional many-to-one association to ShippingOrder
	@ManyToOne
	@JoinColumn(name="SHIPPING_ORDER_ID")
	private ShippingOrder shippingOrder;

	public ShippingOrderDetail() {
	}

	public int getShippingOrderDetailId() {
		return this.shippingOrderDetailId;
	}

	public void setShippingOrderDetailId(int shippingOrderDetailId) {
		this.shippingOrderDetailId = shippingOrderDetailId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderDetail getOrdersDetail() {
		return this.ordersDetail;
	}

	public void setOrdersDetail(OrderDetail ordersDetail) {
		this.ordersDetail = ordersDetail;
	}

	public ShippingOrder getShippingOrder() {
		return this.shippingOrder;
	}

	public void setShippingOrder(ShippingOrder shippingOrder) {
		this.shippingOrder = shippingOrder;
	}

}