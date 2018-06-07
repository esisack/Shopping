package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.srx.model.entities.User;
import com.srx.model.facades.UserFacade;

@ManagedBean(name = "userController")
@SessionScoped()
public class UserController extends AbstractController<User> implements Serializable {


	private static final long serialVersionUID = 1L;
	@EJB
	UserFacade ejbFacade;

	@ManagedProperty(value = "#{companyController}")
	private CompanyController companyController;
	@ManagedProperty(value = "#{navigationController}")
	private NavigationController navigationController;

	private User userLoggedIn;
	private User newUser;
	private Boolean loggedIn = false;
	private Boolean enterprise;
	private String pmail;
	private String ppassword;
	private String checkPassword;

	
	public UserController() {
		super(User.class);
	}

	@PostConstruct
	public void init() {
		super.setFacade(ejbFacade);
	}
		
	
	public User getUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(User userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
		
	public Boolean getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Boolean enterprise) {
		this.enterprise = enterprise;
	}

	public String getPmail() {
		return pmail;
	}

	public void setPmail(String pmail) {
		this.pmail = pmail;
	}

	public String getPpassword() {
		return ppassword;
	}

	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	
	public void createUser() {
		newUser = new User();
	}

	
	public CompanyController getCompanyController() {
		return companyController;
	}

	public void setCompanyController(CompanyController companyController) {
		this.companyController = companyController;
	}

	
	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	public String doLogin() {
		
		String navigation = null;
		userLoggedIn = ejbFacade.userByMail(this.pmail);
		
		if (userLoggedIn != null && userLoggedIn.getPassword().equals(this.ppassword)) {
			loggedIn = true;
			if (userLoggedIn.getUserRol().contains("E")) {
				enterprise = true;
			}
			navigation = navigationController.getReturnPage();
			
			try {
				companyController.setSelected(userLoggedIn.getCompanies().get(0));
			}
			catch(ArrayIndexOutOfBoundsException exception) {
				companyController.prepareCreate(null);
				companyController.getSelected().setTin(userLoggedIn.getDocument());
				companyController.getSelected().setBusinessName(userLoggedIn.getName());
				companyController.getSelected().setFiscalName(userLoggedIn.getName());
				companyController.getSelected().setUser(userLoggedIn);
				companyController.getSelected().setMail(userLoggedIn.getMail());
			} 
		} else {					
			FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return navigation;
	}

	/**
	 * Logout operation.
	 * 
	 * @return
	 */
	public String doLogout() {
		loggedIn = false;
		enterprise = false;
		userLoggedIn = null;
		companyController.setSelected(null);
		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		navigationController.setReturnPage("/index.xhtml?faces-redirect=true");
		return navigationController.getReturnPage();
	}
	
	public String processUser()  {
		
		if (ejbFacade.userByMail(newUser.getMail()) != null) {
			FacesMessage msg = new FacesMessage("Mail existente ingrese uno nuevo o intente recuperar su cuenta ", "ERROR MSG");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("userMail", msg);
			return null;
		};
		if (ejbFacade.userByDocument(newUser.getDocument()) != null) {
			FacesMessage msg = new FacesMessage("Nro de Cuit existente ingrese uno nuevo o intente recuperar su cuenta ", "ERROR MSG");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		};
		
		this.newUser.setEnabled("S");
		this.ejbFacade.create(newUser);
		return "/login.xhtml?faces-redirect=true";
	}

	
}
