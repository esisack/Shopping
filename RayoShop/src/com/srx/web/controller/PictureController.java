package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Picture;
import com.srx.model.facades.PictureFacade;


@ManagedBean(name = "PictureController")
@RequestScoped()
public class PictureController  extends AbstractController<Picture> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	PictureFacade ejbFacade;
	
	public PictureController() {
		super(Picture.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
