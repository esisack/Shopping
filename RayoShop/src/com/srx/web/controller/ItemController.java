package com.srx.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.srx.model.entities.Company;
import com.srx.model.entities.Item;
import com.srx.model.entities.Model;
import com.srx.model.entities.User;
import com.srx.model.facades.ItemFacade;
import com.srx.web.utils.FileUploadUtil;

@ManagedBean(name = "itemController")
@SessionScoped()
public class ItemController extends AbstractController<Item> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	ItemFacade ejbFacade;

	@ManagedProperty(value = "#{userController}")
	private UserController userController;

	private CategoryController categoryController;
	private MakeController makeController;
	private ModelController modelController;
	private VersionController versionController;
	private CompanyController companyController;
	private ItemTypeController itemTypeController;
	private String s3Path = "https://s3.amazonaws.com/repuestos-aws-bucket/images";
	private Boolean itemCreate;
	private String view;
	private Integer categoryId;

	
	public ItemController() {
		super(Item.class);
	}

	@PostConstruct
	public void init() {
		super.setFacade(ejbFacade);
		FacesContext context = FacesContext.getCurrentInstance();
		categoryController = context.getApplication().evaluateExpressionGet(context, "#{categoryController}",
				CategoryController.class);
		makeController = context.getApplication().evaluateExpressionGet(context, "#{makeController}",
				MakeController.class);
		modelController = context.getApplication().evaluateExpressionGet(context, "#{modelController}",
				ModelController.class);
		versionController = context.getApplication().evaluateExpressionGet(context, "#{versionController}",
				VersionController.class);
		companyController = context.getApplication().evaluateExpressionGet(context, "#{companyController}",
				CompanyController.class);
		itemTypeController = context.getApplication().evaluateExpressionGet(context, "#{itemTypelController}",
				ItemTypeController.class);

	}

	/**
	 * Resets the "selected" attribute of any parent Entity controllers.
	 */
	public void resetParents() {
		categoryController.setSelected(null);
		makeController.setSelected(null);		
		modelController.setSelected(null);
		versionController.setSelected(null);
		itemTypeController.setSelected(null);
		companyController.setSelected(null);

	}

	/**
	 * Sets the "selected" attribute of the controller in order to display its data
	 * in a dialog. This is reusing existing the existing View dialog.
	 *
	 * @param event
	 *            Event object for the widget that triggered an action
	 *
	 *            public void prepareCategory(ActionEvent event) { if
	 *            (this.getSelected() != null && categoryController.getSelected() ==
	 *            null) {
	 *            categoryController.setSelected(this.getSelected().getCategory());
	 *            } }
	 */

	

	public String getS3Path() {
		return s3Path;
	}

	public void setS3Path(String s3Path) {
		this.s3Path = s3Path;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Boolean getItemCreate() {
		return itemCreate;
	}

	public void setItemCreate(Boolean itemCreate) {
		this.itemCreate = itemCreate;
	}
	

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	
	
	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public List<String> getPicturesByItem() {
		List<String> picturesByItem = Arrays.asList(getSelected().getFirstPicture(), getSelected().getSecondPicture(),
				getSelected().getThirdPicture(), getSelected().getFourthPicture(), getSelected().getFifthPicture(),
				getSelected().getSixthPicture(), getSelected().getSeventhPicture(), getSelected().getEighthPicture(),
				getSelected().getNinethPicture(), getSelected().getTenthPicture());
		return picturesByItem;

	}

	public List<Item> getItemsByCompany() {
		return (List<Item>) ejbFacade.itemsByCompany(userController.getUserLoggedIn().getCompanies().get(0).getCompanyId());
	}

	public List<Item> getItemsFromCompany() {
		return (List<Item>) ejbFacade.itemsByCompany(getSelected().getCompany().getCompanyId());
	}

	public List<Item> getItemsByCategory() {
		if (this.categoryId != null) {
			return (List<Item>) ejbFacade.itemsByCategory(this.getCategoryId());
		} 
		return (List<Item>) ejbFacade.findAll();

	}
	
	public void saveItem(ActionEvent event) {
		this.getSelected().setCompany(userController.getUserLoggedIn().getCompanies().get(0));
		this.setItemCreate(false);
		this.save(event);
	}
		

	public void firstFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setFirstPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}
	
	public void secondFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setSecondPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}

	public void thirdFileUploadListenerThP(FileUploadEvent e)   {
		this.getSelected().setThirdPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}

	public void fourthFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setFourthPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}

	public void fifthFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setFifthPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}

	public void sixthFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setSixthPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}

	public void seventhFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setSeventhPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}

	public void eighthFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setEighthPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}
	public void ninethFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setNinethPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}
	public void tenthFileUploadListener(FileUploadEvent e)   {
		this.getSelected().setTenthPicture(e.getFile().getFileName());
		FileUploadUtil.addNewPicture(e.getFile());
	}

}
