package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.CampaignPrice;
import com.srx.model.facades.CampaignPriceFacade;


@ManagedBean(name = "campaignPriceController")
@RequestScoped()
public class CampaignPriceController  extends AbstractController<CampaignPrice> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CampaignPriceFacade ejbFacade;
	
	public CampaignPriceController() {
		super(CampaignPrice.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
