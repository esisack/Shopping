package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Make;
import com.srx.model.facades.MakeFacade;


@ManagedBean(name = "MakeController")
@RequestScoped()
public class MakeController  extends AbstractController<Make> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	MakeFacade ejbFacade;
	
	public MakeController() {
		super(Make.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
