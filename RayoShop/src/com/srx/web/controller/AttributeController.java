package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Attribute;
import com.srx.model.facades.AttributeFacade;


@ManagedBean(name = "attributeController")
@RequestScoped()
public class AttributeController  extends AbstractController<Attribute> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	AttributeFacade ejbFacade;
	
	public AttributeController() {
		super(Attribute.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
