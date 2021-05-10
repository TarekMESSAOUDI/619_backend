package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
@Table (name = "T_DEPARTMENT")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartment ;
	private String nameDepartment ;
	@Enumerated(EnumType.STRING)
	private TypeDepartment typeDepartment ;
	private int capacityDepartment ;
	
	@ManyToOne
	User user ;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Department")
	
	@JsonIgnore
	private Set<Product> Product;

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getNameDepartment() {
		return nameDepartment;
	}

	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

	public TypeDepartment getTypeDepartment() {
		return typeDepartment;
	}

	public void setTypeDepartment(TypeDepartment typeDepartment) {
		this.typeDepartment = typeDepartment;
	}

	public int getCapacityDepartment() {
		return capacityDepartment;
	}

	public void setCapacityDepartment(int capacityDepartment) {
		this.capacityDepartment = capacityDepartment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	public Set<Product> getProduct() {
		return Product;
	}

	@JsonIgnore
	public void setProduct(Set<Product> product) {
		Product = product;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int idDepartment, String nameDepartment, TypeDepartment typeDepartment, int capacityDepartment,
			User user, Set<tn.esprit.spring.entity.Product> product) {
		super();
		this.idDepartment = idDepartment;
		this.nameDepartment = nameDepartment;
		this.typeDepartment = typeDepartment;
		this.capacityDepartment = capacityDepartment;
		this.user = user;
		Product = product;
	}

	public Department(String nameDepartment, TypeDepartment typeDepartment, int capacityDepartment, User user,
			Set<tn.esprit.spring.entity.Product> product) {
		super();
		this.nameDepartment = nameDepartment;
		this.typeDepartment = typeDepartment;
		this.capacityDepartment = capacityDepartment;
		this.user = user;
		Product = product;
	}

	public Department(int idDepartment, String nameDepartment, TypeDepartment typeDepartment, int capacityDepartment) {
		super();
		this.idDepartment = idDepartment;
		this.nameDepartment = nameDepartment;
		this.typeDepartment = typeDepartment;
		this.capacityDepartment = capacityDepartment;
	}

	public Department(String nameDepartment, TypeDepartment typeDepartment, int capacityDepartment) {
		super();
		this.nameDepartment = nameDepartment;
		this.typeDepartment = typeDepartment;
		this.capacityDepartment = capacityDepartment;
	}
		
		
	
}
