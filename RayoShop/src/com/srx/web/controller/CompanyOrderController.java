package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.CompanyOrder;
import com.srx.model.facades.CompanyOrderFacade;


@ManagedBean(name = "companyOrderController")
@RequestScoped()
public class CompanyOrderController  extends AbstractController<CompanyOrder> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CompanyOrderFacade ejbFacade;
	
	public CompanyOrderController() {
		super(CompanyOrder.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
