package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.UserPartner;
import com.srx.model.facades.UserPartnerFacade;


@ManagedBean(name = "UserPartnerController")
@RequestScoped()
public class UserPartnerController  extends AbstractController<UserPartner> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	UserPartnerFacade ejbFacade;
	
	public UserPartnerController() {
		super(UserPartner.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
