package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MODELS database table.
 * 
 */
@Entity
@Table(name="MODELS")
@NamedQuery(name="Model.findAll", query="SELECT m FROM Model m")
public class Model implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MODEL_ID")
	private int modelId;

	@Column(name="MODEL_NAME")
	private String modelName;

	//bi-directional many-to-one association to Make
	@ManyToOne
	@JoinColumn(name="MAKE_ID")
	private Make make;

	//bi-directional many-to-one association to Version
	@OneToMany(mappedBy="model")
	private List<Version> versions;

	public Model() {
	}

	public int getModelId() {
		return this.modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Make getMake() {
		return this.make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public List<Version> getVersions() {
		return this.versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public Version addVersion(Version version) {
		getVersions().add(version);
		version.setModel(this);

		return version;
	}

	public Version removeVersion(Version version) {
		getVersions().remove(version);
		version.setModel(null);

		return version;
	}

}