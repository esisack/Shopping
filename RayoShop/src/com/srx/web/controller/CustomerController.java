package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Customer;
import com.srx.model.facades.CustomerFacade;


@ManagedBean(name = "CustomerController")
@RequestScoped()
public class CustomerController  extends AbstractController<Customer> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CustomerFacade ejbFacade;
	
	public CustomerController() {
		super(Customer.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
