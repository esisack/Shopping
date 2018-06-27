package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
@NamedQueries({@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o"),
	@NamedQuery(name="Order.findByUser", query="SELECT o FROM Order o JOIN o.user u WHERE u.userId = :userId")})
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private int orderId;

	private BigDecimal amount;

	private String description;

	private int items;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_DATE")
	private Date orderDate;

	@Column(name="SHIPPING_COST")
	private BigDecimal shippingCost;

	private String status;

	//bi-directional many-to-one association to Collection
	@OneToMany(mappedBy="order")
	private List<Collection> collections;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<OrderDetail> ordersDetails;

	public Order() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItems() {
		return this.items;
	}

	public void setItems(int items) {
		this.items = items;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	public Collection addCollection(Collection collection) {
		getCollections().add(collection);
		collection.setOrder(this);

		return collection;
	}

	public Collection removeCollection(Collection collection) {
		getCollections().remove(collection);
		collection.setOrder(null);

		return collection;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrdersDetails() {
		return this.ordersDetails;
	}

	public void setOrdersDetails(List<OrderDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}

	public OrderDetail addOrdersDetail(OrderDetail ordersDetail) {
		getOrdersDetails().add(ordersDetail);
		ordersDetail.setOrder(this);

		return ordersDetail;
	}

	public OrderDetail removeOrdersDetail(OrderDetail ordersDetail) {
		getOrdersDetails().remove(ordersDetail);
		ordersDetail.setOrder(null);

		return ordersDetail;
	}

}