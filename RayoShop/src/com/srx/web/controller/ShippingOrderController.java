package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.ShippingOrder;
import com.srx.model.facades.ShippingOrderFacade;


@ManagedBean(name = "ShippingOrderController")
@RequestScoped()
public class ShippingOrderController  extends AbstractController<ShippingOrder> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	ShippingOrderFacade ejbFacade;
	
	public ShippingOrderController() {
		super(ShippingOrder.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
