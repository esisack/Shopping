package com.srx.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.OrderDetail;
import com.srx.model.facades.OrderDetailFacade;


@ManagedBean(name = "orderDetailController")
@RequestScoped()
public class OrderDetailController  extends AbstractController<OrderDetail> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	OrderDetailFacade ejbFacade;

	@ManagedProperty(value = "#{userController}")
	private UserController userController;

	public OrderDetailController() {
		super(OrderDetail.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}

	
	   public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public List<OrderDetail> getOrderDetailByCompany() {
			return (List<OrderDetail>) ejbFacade.orderDetailByCompany(userController.getUserLoggedIn().getCompanies().get(0).getCompanyId());
    }
		

}
