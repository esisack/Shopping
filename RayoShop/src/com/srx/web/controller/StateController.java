package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.State;
import com.srx.model.facades.StateFacade;


@ManagedBean(name = "StateController")
@RequestScoped()
public class StateController  extends AbstractController<State> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	StateFacade ejbFacade;
	
	public StateController() {
		super(State.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
