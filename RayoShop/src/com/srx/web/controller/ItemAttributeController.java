package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.ItemAttribute;
import com.srx.model.facades.ItemAttributeFacade;


@ManagedBean(name = "ItemAttributeController")
@RequestScoped()
public class ItemAttributeController  extends AbstractController<ItemAttribute> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	ItemAttributeFacade ejbFacade;
	
	public ItemAttributeController() {
		super(ItemAttribute.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
