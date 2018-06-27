package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Offer;
import com.srx.model.facades.OfferFacade;


@ManagedBean(name = "OfferController")
@RequestScoped()
public class OfferController  extends AbstractController<Offer> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	OfferFacade ejbFacade;
	
	public OfferController() {
		super(Offer.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
