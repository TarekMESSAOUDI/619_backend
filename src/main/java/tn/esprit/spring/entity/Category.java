package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
@Entity
@Table (name = "T_CATEGORY")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idCategory ;
	private String nameCategory ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Category")
	@JsonIgnore
	private Set<UnderCategory> UnderCategory;

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Set<UnderCategory> getUnderCategory() {
		return UnderCategory;
	}

	public void setUnderCategory(Set<UnderCategory> underCategory) {
		UnderCategory = underCategory;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int idCategory, String nameCategory, Set<tn.esprit.spring.entity.UnderCategory> underCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
		UnderCategory = underCategory;
	}

	public Category(String nameCategory, Set<tn.esprit.spring.entity.UnderCategory> underCategory) {
		super();
		this.nameCategory = nameCategory;
		UnderCategory = underCategory;
	}

	public Category(int idCategory, String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}

	public Category(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}
	
	
}
