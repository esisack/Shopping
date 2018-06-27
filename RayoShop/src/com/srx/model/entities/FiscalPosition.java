package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the FISCAL_POSITIONS database table.
 * 
 */
@Entity
@Table(name = "FISCAL_POSITIONS")
@NamedQuery(name = "FiscalPosition.findAll", query = "SELECT f FROM FiscalPosition f")
public class FiscalPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FISCAL_POSITION_ID")
	private Integer fiscalPositionId;

	private String enabled;

	@Column(name = "FISCAL_POSITION_CODE")
	private String fiscalPositionCode;

	@Column(name = "FISCAL_POSITION_NAME")
	private String fiscalPositionName;

	// bi-directional many-to-one association to Company
	@OneToMany(mappedBy = "fiscalPosition")
	private List<Company> companies;

	// bi-directional many-to-one association to Customer
	@OneToMany(mappedBy = "fiscalPosition")
	private List<Customer> customers;

	public FiscalPosition() {
	}

	public Integer getFiscalPositionId() {
		return this.fiscalPositionId;
	}

	public void setFiscalPositionId(Integer fiscalPositionId) {
		this.fiscalPositionId = fiscalPositionId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getFiscalPositionCode() {
		return this.fiscalPositionCode;
	}

	public void setFiscalPositionCode(String fiscalPositionCode) {
		this.fiscalPositionCode = fiscalPositionCode;
	}

	public String getFiscalPositionName() {
		return this.fiscalPositionName;
	}

	public void setFiscalPositionName(String fiscalPositionName) {
		this.fiscalPositionName = fiscalPositionName;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setFiscalPosition(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setFiscalPosition(null);

		return company;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setFiscalPosition(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setFiscalPosition(null);

		return customer;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fiscalPositionId != null ? fiscalPositionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FiscalPosition)) {
			return false;
		}
		FiscalPosition other = (FiscalPosition) object;
		if ((this.fiscalPositionId == null && other.fiscalPositionId != null)
				|| (this.fiscalPositionId != null && !this.fiscalPositionId.equals(other.fiscalPositionId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.FiscalPosition[ orderNum=" + fiscalPositionId + " ]";
	}

}