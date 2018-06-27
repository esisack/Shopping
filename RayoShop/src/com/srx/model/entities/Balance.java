package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the BALANCES database table.
 * 
 */
@Entity
@Table(name="BALANCES")
@NamedQuery(name="Balance.findAll", query="SELECT b FROM Balance b")
public class Balance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BALANCE_ID")
	private int balanceId;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name="BALANCE_DATE")
	private Date balanceDate;

	@Column(name="OPERATION_TYPE")
	private String operationType;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	//bi-directional many-to-one association to CompanyOrder
	@ManyToOne
	@JoinColumn(name="COMPANY_ORDER_ID")
	private CompanyOrder companyOrder;

	//bi-directional many-to-one association to CompanyPayment
	@ManyToOne
	@JoinColumn(name="COMPANY_PAYMENT_ID")
	private CompanyPayment companyPayment;

	public Balance() {
	}

	public int getBalanceId() {
		return this.balanceId;
	}

	public void setBalanceId(int balanceId) {
		this.balanceId = balanceId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getBalanceDate() {
		return this.balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getOperationType() {
		return this.operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyOrder getCompanyOrder() {
		return this.companyOrder;
	}

	public void setCompanyOrder(CompanyOrder companyOrder) {
		this.companyOrder = companyOrder;
	}

	public CompanyPayment getCompanyPayment() {
		return this.companyPayment;
	}

	public void setCompanyPayment(CompanyPayment companyPayment) {
		this.companyPayment = companyPayment;
	}

}