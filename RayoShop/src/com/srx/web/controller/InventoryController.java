package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Inventory;
import com.srx.model.facades.InventoryFacade;


@ManagedBean(name = "InventoryController")
@RequestScoped()
public class InventoryController  extends AbstractController<Inventory> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	InventoryFacade ejbFacade;
	
	public InventoryController() {
		super(Inventory.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
