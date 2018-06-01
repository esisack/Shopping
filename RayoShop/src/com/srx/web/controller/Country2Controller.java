package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.srx.model.entities.Country;
import com.srx.model.facades.CountryFacade;

@ManagedBean(name = "country2Controller")
@SessionScoped
public class Country2Controller extends AbstractController<Country> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private CountryFacade ejbFacade;
	
	public Country2Controller() {
        // Inform the Abstract parent controller of the concrete Product?cap_first Entity
        super(Country.class);
       
	}
	
	@PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
	}

	

}
