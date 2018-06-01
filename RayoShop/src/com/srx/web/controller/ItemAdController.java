package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.ItemAd;
import com.srx.model.facades.ItemAdFacade;


@ManagedBean(name = "ItemAdController")
@RequestScoped()
public class ItemAdController  extends AbstractController<ItemAd> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	ItemAdFacade ejbFacade;
	
	public ItemAdController() {
		super(ItemAd.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
