package com.aniket.Assets2.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Assets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date purchaseDate= new Date(2000-13-12);
	private String condition;
	@ManyToOne
	@JoinColumn(name="category_id")
	@NonNull
	private Category cat;
	private String assignmentStatus="Available";

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

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	@JsonBackReference
	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public String getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	@Override
	public String toString() {
		return "Assets [id=" + id + ", name=" + name + ", purchaseDate=" + purchaseDate + ", condition=" + condition
				+ ", cat=" + cat + ", assignmentStatus=" + assignmentStatus + "]";
	}

	public Assets(String name, Date purchaseDate, String condition, Category cat, String assignmentStatus) {
		super();
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.condition = condition;
		this.cat = cat;
		this.assignmentStatus = assignmentStatus;
	}

}
