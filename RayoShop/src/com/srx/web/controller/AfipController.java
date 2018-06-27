package com.srx.web.controller;

import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.srx.web.utils.AfipUtils;

@ManagedBean(name = "afipController")
@ApplicationScoped
public class AfipController {

	private String token;
	private String sign;
	private Date expirationDate;
	
	public AfipController() {

	}

	public String getToken() {
		validateTA();	
		return token;
	}

	public void setToken(String token) {
		
		this.token = token;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	private void validateTA() {
		Date now = new Date();
		if (expirationDate == null || expirationDate.before(now)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(now); 
			calendar.add(Calendar.HOUR,   12);
			expirationDate = calendar.getTime();
			String ta[] = AfipUtils.getToken();
			token = ta[0];
			sign = ta[1];
		}
	}
	
	
	
	
	
	
	

}
