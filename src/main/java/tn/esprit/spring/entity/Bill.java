package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "T_BILL")
public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idBill ;
	private double montant;
	@Temporal (TemporalType.DATE)
	private Date dateBill ;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@OneToOne
	private Order order;

	public long getIdBill() {
		return idBill;
	}

	public void setIdBill(long idBill) {
		this.idBill = idBill;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateBill() {
		return dateBill;
	}

	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(long idBill, double montant, Date dateBill, PaymentType paymentType, Order order) {
		super();
		this.idBill = idBill;
		this.montant = montant;
		this.dateBill = dateBill;
		this.paymentType = paymentType;
		this.order = order;
	}

	public Bill(double montant, Date dateBill, PaymentType paymentType, Order order) {
		super();
		this.montant = montant;
		this.dateBill = dateBill;
		this.paymentType = paymentType;
		this.order = order;
	}

	public Bill(long idBill, double montant, Date dateBill, PaymentType paymentType) {
		super();
		this.idBill = idBill;
		this.montant = montant;
		this.dateBill = dateBill;
		this.paymentType = paymentType;
	}

	public Bill(double montant, Date dateBill, PaymentType paymentType) {
		super();
		this.montant = montant;
		this.dateBill = dateBill;
		this.paymentType = paymentType;
	}
	
	

}