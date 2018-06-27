package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.srx.model.entities.ItemCode;
import com.srx.model.facades.ItemCodeFacade;


@ManagedBean(name = "itemCodeController")
@SessionScoped()
public class ItemCodeController  extends AbstractController<ItemCode> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	ItemCodeFacade ejbFacade;
	
	public ItemCodeController() {
		super(ItemCode.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
