package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.SecurityItem;
import com.srx.model.facades.SecurityItemFacade;


@ManagedBean(name = "SecurityItemController")
@RequestScoped()
public class SecurityItemController  extends AbstractController<SecurityItem> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	SecurityItemFacade ejbFacade;
	
	public SecurityItemController() {
		super(SecurityItem.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
