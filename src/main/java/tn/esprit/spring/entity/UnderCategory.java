package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table (name = "T_UNDER_CATEGORY")
public class UnderCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idUnderCategory ;
	private String nameUnderCategory ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="UnderCategory")
	@JsonIgnore
	private Set<Product> Product;
	
	@JsonIgnore
	@ManyToOne
	private Category Category;

	public int getIdUnderCategory() {
		return idUnderCategory;
	}

	public void setIdUnderCategory(int idUnderCategory) {
		this.idUnderCategory = idUnderCategory;
	}

	public String getNameUnderCategory() {
		return nameUnderCategory;
	}

	public void setNameUnderCategory(String nameUnderCategory) {
		this.nameUnderCategory = nameUnderCategory;
	}
	
	@JsonIgnore
	public Set<Product> getProduct() {
		return Product;
	}
	
	@JsonIgnore
	public void setProduct(Set<Product> product) {
		Product = product;
	}



	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public UnderCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnderCategory(int idUnderCategory, String nameUnderCategory, Set<tn.esprit.spring.entity.Product> product,
			tn.esprit.spring.entity.Category category) {
		super();
		this.idUnderCategory = idUnderCategory;
		this.nameUnderCategory = nameUnderCategory;
		Product = product;
		Category = category;
	}

	public UnderCategory(String nameUnderCategory, Set<tn.esprit.spring.entity.Product> product,
			tn.esprit.spring.entity.Category category) {
		super();
		this.nameUnderCategory = nameUnderCategory;
		Product = product;
		Category = category;
	}

	public UnderCategory(int idUnderCategory, String nameUnderCategory, Set<tn.esprit.spring.entity.Product> product) {
		super();
		this.idUnderCategory = idUnderCategory;
		this.nameUnderCategory = nameUnderCategory;
		Product = product;
	}

	public UnderCategory(String nameUnderCategory, Set<tn.esprit.spring.entity.Product> product) {
		super();
		this.nameUnderCategory = nameUnderCategory;
		Product = product;
	}
	
	
}
