package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Balance;
import com.srx.model.facades.BalanceFacade;


@ManagedBean(name = "balanceController")
@RequestScoped()
public class BalanceController  extends AbstractController<Balance> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	BalanceFacade ejbFacade;
	
	public BalanceController() {
		super(Balance.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
