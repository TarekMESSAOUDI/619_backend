package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
@Entity
@Table (name = "T1_STOCK")
public class Stock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idStock ;
	private String nameStock ;
	@Enumerated(EnumType.STRING)
	private TypeStock TypeStock ;
	@Temporal (TemporalType.DATE)
	private Date validityStock ;
	private Long capacityStock ;
	private Long quantityStock ;
	private int costStock ;
	private Long maxStock;
	private Long minStock;
	
	@JsonIgnore
	@OneToMany( mappedBy="stock",cascade = CascadeType.ALL)
	private List<Product> product;
//
	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	public String getNameStock() {
		return nameStock;
	}

	public void setNameStock(String nameStock) {
		this.nameStock = nameStock;
	}

	public TypeStock getTypeStock() {
		return TypeStock;
	}

	public void setTypeStock(TypeStock typeStock) {
		TypeStock = typeStock;
	}

	public Date getValidityStock() {
		return validityStock;
	}

	public void setValidityStock(Date validityStock) {
		this.validityStock = validityStock;
	}

	public Long getCapacityStock() {
		return capacityStock;
	}

	public void setCapacityStock(Long capacityStock) {
		this.capacityStock = capacityStock;
	}

	public Long getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(Long quantityStock) {
		this.quantityStock = quantityStock;
	}

	public float getCostStock() {
		return costStock;
	}

	public void setCostStock(int costStock) {
		this.costStock = costStock;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
	
	
	

	


	public Long getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(Long maxStock) {
		this.maxStock = maxStock;
	}

	public Long getMinStock() {
		return minStock;
	}

	public void setMinStock(Long minStock) {
		this.minStock = minStock;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(Long idStock, String nameStock, tn.esprit.spring.entity.TypeStock typeStock, Date validityStock,
			Long capacityStock, Long quantityStock, int costStock, List<Product> product) {
		super();
		this.idStock = idStock;
		this.nameStock = nameStock;
		TypeStock = typeStock;
		this.validityStock = validityStock;
		this.capacityStock = capacityStock;
		this.quantityStock = quantityStock;
		this.costStock = costStock;
		this.product = product;
	}

	public Stock(String nameStock, tn.esprit.spring.entity.TypeStock typeStock, Date validityStock, Long capacityStock,
			Long quantityStock, int costStock, List<Product> product) {
		super();
		this.nameStock = nameStock;
		TypeStock = typeStock;
		this.validityStock = validityStock;
		this.capacityStock = capacityStock;
		this.quantityStock = quantityStock;
		this.costStock = costStock;
		this.product = product;
	}

	public Stock(Long idStock, String nameStock, tn.esprit.spring.entity.TypeStock typeStock, Date validityStock,
			Long capacityStock, Long quantityStock, int costStock) {
		super();
		this.idStock = idStock;
		this.nameStock = nameStock;
		TypeStock = typeStock;
		this.validityStock = validityStock;
		this.capacityStock = capacityStock;
		this.quantityStock = quantityStock;
		this.costStock = costStock;
	}

	public Stock(String nameStock, tn.esprit.spring.entity.TypeStock typeStock, Date validityStock, Long capacityStock,
			Long quantityStock, int costStock) {
		super();
		this.nameStock = nameStock;
		TypeStock = typeStock;
		this.validityStock = validityStock;
		this.capacityStock = capacityStock;
		this.quantityStock = quantityStock;
		this.costStock = costStock;
	}

	public Stock(Long idStock, String nameStock, tn.esprit.spring.entity.TypeStock typeStock, Date validityStock,
			Long capacityStock, Long quantityStock, int costStock, Long maxStock, Long minStock,
			List<Product> product) {
		super();
		this.idStock = idStock;
		this.nameStock = nameStock;
		TypeStock = typeStock;
		this.validityStock = validityStock;
		this.capacityStock = capacityStock;
		this.quantityStock = quantityStock;
		this.costStock = costStock;
		this.maxStock = maxStock;
		this.minStock = minStock;
		this.product = product;
	}
	
	
	
	
	
}
