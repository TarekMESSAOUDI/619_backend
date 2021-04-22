package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "T_DELIVERY")
public class Delivery implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idDelivery ;
	@Temporal (TemporalType.DATE)
	private Date dateDelivery ;
	private String placeDelivery ;
	private boolean stateDelivery ;
	@Enumerated (EnumType.STRING)
	private MeansOfTransport meansOfTransportDelivery ;
	private String adressDelivery ;
	private boolean finishedDelivery;
	@Enumerated(EnumType.STRING)
	private Status status;
	private int kilometrage;
	private int costs;
	
	@JsonIgnore
	@ManyToOne
	User user;

	public int getIdDelivery() {
		return idDelivery;
	}

	public void setIdDelivery(int idDelivery) {
		this.idDelivery = idDelivery;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public String getPlaceDelivery() {
		return placeDelivery;
	}

	public void setPlaceDelivery(String placeDelivery) {
		this.placeDelivery = placeDelivery;
	}

	public boolean isStateDelivery() {
		return stateDelivery;
	}

	public void setStateDelivery(boolean stateDelivery) {
		this.stateDelivery = stateDelivery;
	}

	public MeansOfTransport getMeansOfTransportDelivery() {
		return meansOfTransportDelivery;
	}

	public void setMeansOfTransportDelivery(MeansOfTransport meansOfTransportDelivery) {
		this.meansOfTransportDelivery = meansOfTransportDelivery;
	}

	public String getAdressDelivery() {
		return adressDelivery;
	}

	public void setAdressDelivery(String adressDelivery) {
		this.adressDelivery = adressDelivery;
	}

	public boolean isFinishedDelivery() {
		return finishedDelivery;
	}

	public void setFinishedDelivery(boolean finishedDelivery) {
		this.finishedDelivery = finishedDelivery;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public int getCosts() {
		return costs;
	}

	public void setCosts(int costs) {
		this.costs = costs;
	}

	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery(int idDelivery, Date dateDelivery, String placeDelivery, boolean stateDelivery,
			MeansOfTransport meansOfTransportDelivery, String adressDelivery, boolean finishedDelivery, Status status,
			int kilometrage, int costs, User user) {
		super();
		this.idDelivery = idDelivery;
		this.dateDelivery = dateDelivery;
		this.placeDelivery = placeDelivery;
		this.stateDelivery = stateDelivery;
		this.meansOfTransportDelivery = meansOfTransportDelivery;
		this.adressDelivery = adressDelivery;
		this.finishedDelivery = finishedDelivery;
		this.status = status;
		this.kilometrage = kilometrage;
		this.costs = costs;
		this.user = user;
	}

	public Delivery(Date dateDelivery, String placeDelivery, boolean stateDelivery,
			MeansOfTransport meansOfTransportDelivery, String adressDelivery, boolean finishedDelivery, Status status,
			int kilometrage, int costs, User user) {
		super();
		this.dateDelivery = dateDelivery;
		this.placeDelivery = placeDelivery;
		this.stateDelivery = stateDelivery;
		this.meansOfTransportDelivery = meansOfTransportDelivery;
		this.adressDelivery = adressDelivery;
		this.finishedDelivery = finishedDelivery;
		this.status = status;
		this.kilometrage = kilometrage;
		this.costs = costs;
		this.user = user;
	}

	public Delivery(int idDelivery, Date dateDelivery, String placeDelivery, boolean stateDelivery,
			MeansOfTransport meansOfTransportDelivery, String adressDelivery, boolean finishedDelivery, Status status,
			int kilometrage, int costs) {
		super();
		this.idDelivery = idDelivery;
		this.dateDelivery = dateDelivery;
		this.placeDelivery = placeDelivery;
		this.stateDelivery = stateDelivery;
		this.meansOfTransportDelivery = meansOfTransportDelivery;
		this.adressDelivery = adressDelivery;
		this.finishedDelivery = finishedDelivery;
		this.status = status;
		this.kilometrage = kilometrage;
		this.costs = costs;
	}

	public Delivery(Date dateDelivery, String placeDelivery, boolean stateDelivery,
			MeansOfTransport meansOfTransportDelivery, String adressDelivery, boolean finishedDelivery, Status status,
			int kilometrage, int costs) {
		super();
		this.dateDelivery = dateDelivery;
		this.placeDelivery = placeDelivery;
		this.stateDelivery = stateDelivery;
		this.meansOfTransportDelivery = meansOfTransportDelivery;
		this.adressDelivery = adressDelivery;
		this.finishedDelivery = finishedDelivery;
		this.status = status;
		this.kilometrage = kilometrage;
		this.costs = costs;
	}

	
}
