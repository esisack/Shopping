package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.AttributeList;
import com.srx.model.facades.AttributeListFacade;


@ManagedBean(name = "attributeListController")
@RequestScoped()
public class AttributeListController  extends AbstractController<AttributeList> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	AttributeListFacade ejbFacade;
	
	public AttributeListController() {
		super(AttributeList.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
