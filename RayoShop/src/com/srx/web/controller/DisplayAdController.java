package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.DisplayAd;
import com.srx.model.facades.DisplayAdFacade;


@ManagedBean(name = "DisplayAdController")
@RequestScoped()
public class DisplayAdController  extends AbstractController<DisplayAd> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	DisplayAdFacade ejbFacade;
	
	public DisplayAdController() {
		super(DisplayAd.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
