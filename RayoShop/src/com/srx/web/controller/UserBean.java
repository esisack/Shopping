package com.srx.web.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.srx.model.entities.User;

@ManagedBean(name = "userBean")
@SessionScoped()
public class UserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName = "esisack@gmail.com";
	private String userVisibility = "block";
	private String otherVisibility = "none";
	
	public UserBean() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserVisibility() {
		return userVisibility;
	}

	public void setUserVisibility(String userVisibility) {
		this.userVisibility = userVisibility;
	}

	public String getOtherVisibility() {
		return otherVisibility;
	}

	public void setOtherVisibility(String otherVisibility) {
		this.otherVisibility = otherVisibility;
	}

	
	
	

}
