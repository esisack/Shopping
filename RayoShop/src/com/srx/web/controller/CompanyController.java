package com.srx.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.srx.model.entities.Company;
import com.srx.model.facades.CompanyFacade;

@ManagedBean(name = "companyController")
@SessionScoped()
public class CompanyController extends AbstractController<Company> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	CompanyFacade ejbFacade;
	private MapModel mapModel;
	private Marker marker;

	private CategoryController categoryController;
	private FiscalPositionController fiscalPositionController;
	private PlanController planController;

	private String businessName;
	private UploadedFile logoImage;

	public CompanyController() {
		super(Company.class);

	}

	@PostConstruct
	public void init() {
		super.setFacade(ejbFacade);
		FacesContext context = FacesContext.getCurrentInstance();
		categoryController = context.getApplication().evaluateExpressionGet(context, "#{categoryController}",
				CategoryController.class);
		fiscalPositionController = context.getApplication().evaluateExpressionGet(context,
				"#{fiscalPositionController}", FiscalPositionController.class);
		planController = context.getApplication().evaluateExpressionGet(context, "#{planController}",
				PlanController.class);

		mapModel = new DefaultMapModel();

		LatLng coord1 = new LatLng(-24.7996956, -65.4162299);
		LatLng coord2 = new LatLng(-24.788138, -65.412318);
		LatLng coord3 = new LatLng(-24.7936545, -65.4129864);
		LatLng coord4 = new LatLng(-24.7808868, -65.4028109);
		LatLng coord5 = new LatLng(-24.7808825, -65.4290758);
		LatLng coord6 = new LatLng(-24.785994, -65.4164929);
		LatLng coord7 = new LatLng(-24.785045, -65.4134177);
		LatLng coord8 = new LatLng(-24.789029, -65.4147007);
		LatLng coord9 = new LatLng(-24.794425, -65.416035);
		LatLng coord10 = new LatLng(-24.7838927, -65.4168114);

		// Basic marker
		mapModel.addOverlay(new Marker(coord1, "Balmat"));
		mapModel.addOverlay(new Marker(coord2, "Balodin"));
		mapModel.addOverlay(new Marker(coord3, "Castillo"));
		mapModel.addOverlay(new Marker(coord4, "Grisino"));
		mapModel.addOverlay(new Marker(coord5, "Dycar"));
		mapModel.addOverlay(new Marker(coord6, "Melbac"));
		mapModel.addOverlay(new Marker(coord7, "Optica Prisma"));
		mapModel.addOverlay(new Marker(coord8, "Papel Market"));
		mapModel.addOverlay(new Marker(coord9, "Super Brico"));
		mapModel.addOverlay(new Marker(coord10, "CeluShop"));

	}

	public void resetParents() {
		categoryController.setSelected(null);
		fiscalPositionController.setSelected(null);
		planController.setSelected(null);
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public UploadedFile getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(UploadedFile logoImage) {
		this.logoImage = logoImage;
	}

	public MapModel getMapModel() {
		return mapModel;
	}

	public void setMapModel(MapModel mapModel) {
		this.mapModel = mapModel;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
	}

	public Marker getMarker() {
		return marker;
	}

	public void uploadPhoto(FileUploadEvent e) {

		UploadedFile uploadedPhoto = e.getFile();
		System.out.println("paso por 1");
		String filePath = "C:/Pictures/";
		byte[] bytes = null;

		if (uploadedPhoto != null) {
			System.out.println("paso por 2");
			bytes = uploadedPhoto.getContents();
			String filename = FilenameUtils.getName(uploadedPhoto.getFileName());
			BufferedOutputStream stream;
			try {
				System.out.println("paso por 3");

				stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + filename)));
				stream.write(bytes);
				stream.close();
				this.getSelected().setLogo(filename);
				System.out.println("paso por 4");

			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}

}
