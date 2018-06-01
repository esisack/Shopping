package com.srx.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import com.srx.model.entities.Question;
import com.srx.model.facades.QuestionFacade;


@ManagedBean(name = "questionController")
@RequestScoped()
public class QuestionController  extends AbstractController<Question> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	QuestionFacade ejbFacade;
	private String activeRequest;
	private String activeAnswer;

	@ManagedProperty(value = "#{userController}")
	private UserController userController;
	
	@ManagedProperty(value = "#{itemController}")
	private ItemController itemController;
	
	@ManagedProperty(value = "#{navigationController}")
	private NavigationController navigationController;
	
	public QuestionController() {
		super(Question.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	public String getActiveRequest() {
		return activeRequest;
	}

	public void setActiveRequest(String activeRequest) {
		this.activeRequest = activeRequest;
	}

	public String getActiveAnswer() {
		return activeAnswer;
	}

	public void setActiveAnswer(String activeAnswer) {
		this.activeAnswer = activeAnswer;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public ItemController getItemController() {
		return itemController;
	}

	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
	}
	

	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	
	public List<Question> getQuestionsByItem() {
		return this.ejbFacade.questionsByItem(this.getItemController().getSelected().getItemId());		
	}

	
	public List<Question> getQuestionsByUser() {
		return this.ejbFacade.questionsByUser(this.getUserController().getUserLoggedIn().getUserId());		
	}
	
	public String canIAskQuestion() {
		if (userController.getLoggedIn()) {
			Question question = new Question();
			question.setItem(itemController.getSelected());
			question.setUser(userController.getUserLoggedIn());
			question.setRequest(this.activeRequest);
			question.setStatus("A");
			this.ejbFacade.create(question);
			this.activeRequest = null;			
		} else {
			navigationController.setReturnPage("/pages/items/view.xhtml?faces-redirect=true");
			return "/login.xhtml?faces-redirect=true";
		}
		
		return null;
	}	
}
