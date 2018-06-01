package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Campaign;
import com.srx.model.facades.CampaignFacade;


@ManagedBean(name = "campaignController")
@RequestScoped()
public class CampaignController  extends AbstractController<Campaign> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CampaignFacade ejbFacade;
	
	public CampaignController() {
		super(Campaign.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
