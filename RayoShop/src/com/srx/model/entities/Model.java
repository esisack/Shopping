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
	private Integer modelId;

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

	public Integer getModelId() {
		return this.modelId;
	}

	public void setModelId(Integer modelId) {
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
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (modelId != null ? modelId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Model)) {
			return false;
		}
		Model other = (Model) object;
		if ((this.modelId == null && other.modelId != null)
				|| (this.modelId != null && !this.modelId.equals(other.modelId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Model[ orderNum=" + modelId + " ]";
	}


}