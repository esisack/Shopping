package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMPANY_ORDERS database table.
 * 
 */
@Entity
@Table(name="COMPANY_ORDERS")
@NamedQuery(name="CompanyOrder.findAll", query="SELECT c FROM CompanyOrder c")
public class CompanyOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMPANY_ORDER_ID")
	private int companyOrderId;

	private BigDecimal amount;

	private int items;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_DATE")
	private Date orderDate;

	//bi-directional many-to-one association to Balance
	@OneToMany(mappedBy="companyOrder")
	private List<Balance> balances;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	public CompanyOrder() {
	}

	public int getCompanyOrderId() {
		return this.companyOrderId;
	}

	public void setCompanyOrderId(int companyOrderId) {
		this.companyOrderId = companyOrderId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public List<Balance> getBalances() {
		return this.balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	public Balance addBalance(Balance balance) {
		getBalances().add(balance);
		balance.setCompanyOrder(this);

		return balance;
	}

	public Balance removeBalance(Balance balance) {
		getBalances().remove(balance);
		balance.setCompanyOrder(null);

		return balance;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}