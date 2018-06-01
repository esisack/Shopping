package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Address;
import com.srx.model.facades.AddressFacade;


@ManagedBean(name = "addressController")
@RequestScoped()
public class AddressController  extends AbstractController<Address> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	AddressFacade ejbFacade;
	
	public AddressController() {
		super(Address.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
