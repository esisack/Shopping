package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.ShippingOrderDetail;
import com.srx.model.facades.ShippingOrderDetailFacade;


@ManagedBean(name = "ShippingOrderDetailController")
@RequestScoped()
public class ShippingOrderDetailController  extends AbstractController<ShippingOrderDetail> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	ShippingOrderDetailFacade ejbFacade;
	
	public ShippingOrderDetailController() {
		super(ShippingOrderDetail.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
