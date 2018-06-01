package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.TextAd;
import com.srx.model.facades.TextAdFacade;


@ManagedBean(name = "TextAdController")
@RequestScoped()
public class TextAdController  extends AbstractController<TextAd> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	TextAdFacade ejbFacade;
	
	public TextAdController() {
		super(TextAd.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
