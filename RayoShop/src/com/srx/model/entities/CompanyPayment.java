package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMPANY_PAYMENTS database table.
 * 
 */
@Entity
@Table(name="COMPANY_PAYMENTS")
@NamedQuery(name="CompanyPayment.findAll", query="SELECT c FROM CompanyPayment c")
public class CompanyPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMPANY_PAYMENT_ID")
	private int companyPaymentId;

	private BigDecimal amount;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="PAYMENT_DATE")
	private Date paymentDate;

	//bi-directional many-to-one association to Balance
	@OneToMany(mappedBy="companyPayment")
	private List<Balance> balances;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	public CompanyPayment() {
	}

	public int getCompanyPaymentId() {
		return this.companyPaymentId;
	}

	public void setCompanyPaymentId(int companyPaymentId) {
		this.companyPaymentId = companyPaymentId;
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

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public List<Balance> getBalances() {
		return this.balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	public Balance addBalance(Balance balance) {
		getBalances().add(balance);
		balance.setCompanyPayment(this);

		return balance;
	}

	public Balance removeBalance(Balance balance) {
		getBalances().remove(balance);
		balance.setCompanyPayment(null);

		return balance;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}