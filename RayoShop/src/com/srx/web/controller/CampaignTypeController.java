package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.CampaignType;
import com.srx.model.facades.CampaignTypeFacade;


@ManagedBean(name = "campaignTypeController")
@RequestScoped()
public class CampaignTypeController  extends AbstractController<CampaignType> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CampaignTypeFacade ejbFacade;
	
	public CampaignTypeController() {
		super(CampaignType.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
