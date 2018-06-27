package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VERSIONS database table.
 * 
 */
@Entity
@Table(name="VERSIONS")
@NamedQuery(name="Version.findAll", query="SELECT v FROM Version v")
public class Version implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VERSION_ID")
	private Integer versionId;

	private String enabled;

	@Column(name="VERSION_NAME")
	private String versionName;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="version")
	private List<Item> items;

	//bi-directional many-to-one association to Model
	@ManyToOne
	@JoinColumn(name="MODEL_ID")
	private Model model;

	public Version() {
	}

	public Integer getVersionId() {
		return this.versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getVersionName() {
		return this.versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setVersion(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setVersion(null);

		return item;
	}

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (versionId != null ? versionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Version)) {
			return false;
		}
		Version other = (Version) object;
		if ((this.versionId == null && other.versionId != null)
				|| (this.versionId != null && !this.versionId.equals(other.versionId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Version[ orderNum=" + versionId + " ]";
	}

}