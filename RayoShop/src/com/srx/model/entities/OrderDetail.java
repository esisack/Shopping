package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.jpa.config.Cascade;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ORDERS_DETAIL database table.
 * 
 */
@Entity
@Table(name="ORDERS_DETAIL")
@NamedQueries({@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o"),
	@NamedQuery(name="OrderDetail.findByCompany", query="SELECT o FROM OrderDetail o JOIN o.item i JOIN i.company c WHERE c.companyId = :companyId")})
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_DETAIL_ID")
	private int orderDetailId;

	private BigDecimal discount;

	private int quantity;

	@Column(name="SHIPPING_COST")
	private BigDecimal shippingCost;

	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;

	//bi-directional many-to-one association to Order
	@ManyToOne()
	@JoinColumn(name="ORDER_ID")
	private Order order;

	//bi-directional many-to-one association to ShippingOrderDetail
	@OneToMany(mappedBy="ordersDetail")
	private List<ShippingOrderDetail> shippingOrdersDetails;

	public OrderDetail() {
	}

	public int getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getShippingCost() {
		return this.shippingCost;
	}

	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<ShippingOrderDetail> getShippingOrdersDetails() {
		return this.shippingOrdersDetails;
	}

	public void setShippingOrdersDetails(List<ShippingOrderDetail> shippingOrdersDetails) {
		this.shippingOrdersDetails = shippingOrdersDetails;
	}

	public ShippingOrderDetail addShippingOrdersDetail(ShippingOrderDetail shippingOrdersDetail) {
		getShippingOrdersDetails().add(shippingOrdersDetail);
		shippingOrdersDetail.setOrdersDetail(this);

		return shippingOrdersDetail;
	}

	public ShippingOrderDetail removeShippingOrdersDetail(ShippingOrderDetail shippingOrdersDetail) {
		getShippingOrdersDetails().remove(shippingOrdersDetail);
		shippingOrdersDetail.setOrdersDetail(null);

		return shippingOrdersDetail;
	}

}