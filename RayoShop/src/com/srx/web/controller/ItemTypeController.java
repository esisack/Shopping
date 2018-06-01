package com.srx.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.ItemType;
import com.srx.model.facades.ItemTypeFacade;


@ManagedBean(name = "itemTypeController")
@RequestScoped()
public class ItemTypeController  extends AbstractController<ItemType> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	ItemTypeFacade ejbFacade;
	
	public ItemTypeController() {
		super(ItemType.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
        
	}
	
	public List<String> getItemTypes() {
		List<String> itemTypes = new ArrayList();
		for (ItemType _itemType : this.getItems()) {
			itemTypes.add(_itemType.getItemTypeName());
		}
		return itemTypes;
		
		
	}
	
	
	

}
