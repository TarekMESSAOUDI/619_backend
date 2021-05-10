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
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="T_PRODUCT")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct ;
	private String titleProduct ;
	private String descriptionProduct ;
	private int quantityProduct ;
	private float priceProduct ;
	private String barcodeProduct ;
	private float weightProduct ;
	private float buyingPriceProduct ;
	private int maxQuantityProduct ;
	private String fileName;

	
	@JsonIgnore
	@ManyToOne
	Department Department;
	
	@JsonIgnore
	@ManyToOne
	Basket Basket;
	
	
	@JsonIgnore
	@ManyToOne
	UnderCategory UnderCategory;

	@ManyToOne
	Stock stock ;

	@OneToOne
	private FileDB FileDB;
	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getTitleProduct() {
		return titleProduct;
	}

	public void setTitleProduct(String titleProduct) {
		this.titleProduct = titleProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}

	public String getBarcodeProduct() {
		return barcodeProduct;
	}

	public void setBarcodeProduct(String barcodeProduct) {
		this.barcodeProduct = barcodeProduct;
	}

	public float getWeightProduct() {
		return weightProduct;
	}

	public void setWeightProduct(float weightProduct) {
		this.weightProduct = weightProduct;
	}

	public float getBuyingPriceProduct() {
		return buyingPriceProduct;
	}

	public void setBuyingPriceProduct(float buyingPriceProduct) {
		this.buyingPriceProduct = buyingPriceProduct;
	}

	public int getMaxQuantityProduct() {
		return maxQuantityProduct;
	}

	public void setMaxQuantityProduct(int maxQuantityProduct) {
		this.maxQuantityProduct = maxQuantityProduct;
	}

	

	public Department getDepartment() {
		return Department;
	}

	public void setDepartment(Department department) {
		Department = department;
	}

	public Basket getBasket() {
		return Basket;
	}

	public void setBasket(Basket basket) {
		Basket = basket;
	}

	
	public UnderCategory getUnderCategory() {
		return UnderCategory;
	}
	
	public void setUnderCategory(UnderCategory underCategory) {
		UnderCategory = underCategory;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int idProduct, String titleProduct, String descriptionProduct, int quantityProduct,
			float priceProduct, String barcodeProduct, float weightProduct, float buyingPriceProduct,
			int maxQuantityProduc, tn.esprit.spring.entity.Department department,
			tn.esprit.spring.entity.Basket basket, tn.esprit.spring.entity.UnderCategory underCategory, Stock stock) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.barcodeProduct = barcodeProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
  	Department = department;
		Basket = basket;
		UnderCategory = underCategory;
		this.stock = stock;
	}

	public FileDB getFileDB() {
		return FileDB;
	}

	public void setFileDB(FileDB fileDB) {
		FileDB = fileDB;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Product(String titleProduct, String descriptionProduct, int quantityProduct, float priceProduct,
			String barcodeProduct, float weightProduct, float buyingPriceProduct, int maxQuantityProduct, 
			tn.esprit.spring.entity.Department department, tn.esprit.spring.entity.Basket basket,
			tn.esprit.spring.entity.UnderCategory underCategory, Stock stock) {
		super();
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.barcodeProduct = barcodeProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
		Department = department;
		Basket = basket;
		UnderCategory = underCategory;
		this.stock = stock;
	}

	public Product(int idProduct, String titleProduct, String descriptionProduct, int quantityProduct,
			float priceProduct, String barcodeProduct, float weightProduct, float buyingPriceProduct,
			int maxQuantityProduct) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.barcodeProduct = barcodeProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
	}

	public Product(String titleProduct, String descriptionProduct, int quantityProduct, float priceProduct,
			String barcodeProduct, float weightProduct, float buyingPriceProduct, int maxQuantityProduct) {
		super();
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.barcodeProduct = barcodeProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
	}
	
	
}
