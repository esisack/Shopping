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
	private int versionId;

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

	public int getVersionId() {
		return this.versionId;
	}

	public void setVersionId(int versionId) {
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

}