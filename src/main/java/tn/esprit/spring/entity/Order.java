package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
@Table(name="T_ORDER")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder ;
	@Temporal (TemporalType.DATE)
	private Date dateOrder ;
	private int productNumberOrder ;
	private String stateOrder ;
	private float amountOrder ;
	private double prix;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@OneToOne(mappedBy="order")
	@JsonIgnore
	private Bill bill;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	Product product;

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getProductNumberOrder() {
		return productNumberOrder;
	}

	public void setProductNumberOrder(int productNumberOrder) {
		this.productNumberOrder = productNumberOrder;
	}

	public String getStateOrder() {
		return stateOrder;
	}

	public void setStateOrder(String stateOrder) {
		this.stateOrder = stateOrder;
	}

	public float getAmountOrder() {
		return amountOrder;
	}

	public void setAmountOrder(float amountOrder) {
		this.amountOrder = amountOrder;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long idOrder, Date dateOrder, int productNumberOrder, String stateOrder, float amountOrder,
			double prix, PaymentType paymentType, tn.esprit.spring.entity.Bill bill, User user,
			tn.esprit.spring.entity.Product product) {
		super();
		this.idOrder = idOrder;
		this.dateOrder = dateOrder;
		this.productNumberOrder = productNumberOrder;
		this.stateOrder = stateOrder;
		this.amountOrder = amountOrder;
		this.prix = prix;
		this.paymentType = paymentType;
		this.bill = bill;
		this.user = user;
		this.product = product;
	}

	public Order(Date dateOrder, int productNumberOrder, String stateOrder, float amountOrder, double prix,
			PaymentType paymentType, tn.esprit.spring.entity.Bill bill, User user,
			tn.esprit.spring.entity.Product product) {
		super();
		this.dateOrder = dateOrder;
		this.productNumberOrder = productNumberOrder;
		this.stateOrder = stateOrder;
		this.amountOrder = amountOrder;
		this.prix = prix;
		this.paymentType = paymentType;
		this.bill = bill;
		this.user = user;
		this.product = product;
	}

	public Order(Long idOrder, Date dateOrder, int productNumberOrder, String stateOrder, float amountOrder,
			double prix, PaymentType paymentType) {
		super();
		this.idOrder = idOrder;
		this.dateOrder = dateOrder;
		this.productNumberOrder = productNumberOrder;
		this.stateOrder = stateOrder;
		this.amountOrder = amountOrder;
		this.prix = prix;
		this.paymentType = paymentType;
	}

	public Order(Date dateOrder, int productNumberOrder, String stateOrder, float amountOrder, double prix,
			PaymentType paymentType) {
		super();
		this.dateOrder = dateOrder;
		this.productNumberOrder = productNumberOrder;
		this.stateOrder = stateOrder;
		this.amountOrder = amountOrder;
		this.prix = prix;
		this.paymentType = paymentType;
	}

	
}