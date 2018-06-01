package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Email;
import com.srx.model.facades.EmailFacade;


@ManagedBean(name = "EmailController")
@RequestScoped()
public class EmailController  extends AbstractController<Email> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	EmailFacade ejbFacade;
	
	public EmailController() {
		super(Email.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
