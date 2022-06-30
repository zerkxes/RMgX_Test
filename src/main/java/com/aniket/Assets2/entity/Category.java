package com.aniket.Assets2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private long id;

	private String name;
	private String description;
	@OneToMany(mappedBy = "cat", fetch = FetchType.LAZY)
	private List<Assets> listAssets = new ArrayList<>();

	@JsonManagedReference
	public List<Assets> getListAssets() {
		return listAssets;
	}

	public void setListAssets(List<Assets> listAssets) {
		this.listAssets = listAssets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category(String name, String description, List<Assets> listAssets) {
		super();
		this.name = name;
		this.description = description;
		this.listAssets = listAssets;
	}

	public Category() {

	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", listAssets=" + listAssets
				+ "]";
	}
}
