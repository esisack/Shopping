package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.ItemWarning;
import com.srx.model.facades.ItemWarningFacade;


@ManagedBean(name = "ItemWarningController")
@RequestScoped()
public class ItemWarningController  extends AbstractController<ItemWarning> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	ItemWarningFacade ejbFacade;
	
	public ItemWarningController() {
		super(ItemWarning.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
