package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MAKES database table.
 * 
 */
@Entity
@Table(name="MAKES")
@NamedQuery(name="Make.findAll", query="SELECT m FROM Make m")
public class Make implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MAKE_ID")
	private int makeId;

	@Column(name="MAKE_CODE")
	private String makeCode;

	@Column(name="MAKE_LOGO")
	private String makeLogo;

	@Column(name="MAKE_NAME")
	private String makeName;

	@Column(name="MAKE_TYPE")
	private String makeType;

	//bi-directional many-to-one association to Model
	@OneToMany(mappedBy="make")
	private List<Model> models;

	public Make() {
	}

	public int getMakeId() {
		return this.makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public String getMakeCode() {
		return this.makeCode;
	}

	public void setMakeCode(String makeCode) {
		this.makeCode = makeCode;
	}

	public String getMakeLogo() {
		return this.makeLogo;
	}

	public void setMakeLogo(String makeLogo) {
		this.makeLogo = makeLogo;
	}

	public String getMakeName() {
		return this.makeName;
	}

	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}

	public String getMakeType() {
		return this.makeType;
	}

	public void setMakeType(String makeType) {
		this.makeType = makeType;
	}

	public List<Model> getModels() {
		return this.models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	public Model addModel(Model model) {
		getModels().add(model);
		model.setMake(this);

		return model;
	}

	public Model removeModel(Model model) {
		getModels().remove(model);
		model.setMake(null);

		return model;
	}

}