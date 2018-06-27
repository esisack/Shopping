package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the PLANS database table.
 * 
 */
@Entity
@Table(name = "PLANS")
@NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAN_ID")
	private Integer planId;

	private String enabled;

	@Column(name = "PLAN_NAME")
	private String planName;

	@Column(name = "PLAN_TYPE")
	private String planType;

	private BigDecimal price;

	// bi-directional many-to-one association to Company
	@OneToMany(mappedBy = "plan")
	private List<Company> companies;

	public Plan() {
	}


	public Integer getPlanId() {
		return planId;
	}


	public void setPlanId(Integer planId) {
		this.planId = planId;
	}



	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanType() {
		return this.planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setPlan(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setPlan(null);

		return company;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (planId != null ? planId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Plan)) {
			return false;
		}
		Plan other = (Plan) object;
		if ((this.planId == null && other.planId != null)
				|| (this.planId != null && !this.planId.equals(other.planId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Plan[ orderNum=" + planId + " ]";
	}

}