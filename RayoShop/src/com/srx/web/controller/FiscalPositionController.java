package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.srx.model.entities.FiscalPosition;
import com.srx.model.facades.FiscalPositionFacade;


@ManagedBean(name = "fiscalPositionController")
@SessionScoped()
public class FiscalPositionController  extends AbstractController<FiscalPosition> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	FiscalPositionFacade ejbFacade;

	
	public FiscalPositionController() {
		super(FiscalPosition.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
        
	}
	

}
