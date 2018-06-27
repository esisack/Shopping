package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.UserKarma;
import com.srx.model.facades.UserKarmaFacade;


@ManagedBean(name = "UserKarmaController")
@RequestScoped()
public class UserKarmaController  extends AbstractController<UserKarma> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	UserKarmaFacade ejbFacade;
	
	public UserKarmaController() {
		super(UserKarma.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
