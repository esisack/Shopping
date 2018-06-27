package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.srx.model.entities.Country;
import com.srx.model.facades.CountryFacade;


@ManagedBean(name = "countryController")
@RequestScoped()
public class CountryController  extends AbstractController<Country> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CountryFacade ejbFacade;

	
	public CountryController() {
		super(Country.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
        
	}

	

}
