package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SECURITY_ITEMS database table.
 * 
 */
@Entity
@Table(name="SECURITY_ITEMS")
@NamedQuery(name="SecurityItem.findAll", query="SELECT s FROM SecurityItem s")
public class SecurityItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SECURITY_ITEM_ID")
	private int securityItemId;

	@Column(name="CELL_PHONE")
	private String cellPhone;

	private String password;

	private int pin;

	private int vendors;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public SecurityItem() {
	}

	public int getSecurityItemId() {
		return this.securityItemId;
	}

	public void setSecurityItemId(int securityItemId) {
		this.securityItemId = securityItemId;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getVendors() {
		return this.vendors;
	}

	public void setVendors(int vendors) {
		this.vendors = vendors;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}