package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
@Table (name = "T_CAGNOTTE")
public class Cagnotte implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idCagnotte ;
	private String nameCagnotte;
	private int amountCagnotte ;
	
	@OneToOne(mappedBy="Cagnotte")
	@JsonIgnore
	private CharityEvent CharityEvent;

	public int getIdCagnotte() {
		return idCagnotte;
	}

	public void setIdCagnotte(int idCagnotte) {
		this.idCagnotte = idCagnotte;
	}

	public String getNameCagnotte() {
		return nameCagnotte;
	}

	public void setNameCagnotte(String nameCagnotte) {
		this.nameCagnotte = nameCagnotte;
	}

	public int getAmountCagnotte() {
		return amountCagnotte;
	}

	public void setAmountCagnotte(int amountCagnotte) {
		this.amountCagnotte = amountCagnotte;
	}

	public CharityEvent getCharityEvent() {
		return CharityEvent;
	}

	public void setCharityEvent(CharityEvent charityEvent) {
		CharityEvent = charityEvent;
	}

	public Cagnotte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cagnotte(int idCagnotte, String nameCagnotte, int amountCagnotte,
			tn.esprit.spring.entity.CharityEvent charityEvent) {
		super();
		this.idCagnotte = idCagnotte;
		this.nameCagnotte = nameCagnotte;
		this.amountCagnotte = amountCagnotte;
		CharityEvent = charityEvent;
	}

	public Cagnotte(String nameCagnotte, int amountCagnotte, tn.esprit.spring.entity.CharityEvent charityEvent) {
		super();
		this.nameCagnotte = nameCagnotte;
		this.amountCagnotte = amountCagnotte;
		CharityEvent = charityEvent;
	}

	public Cagnotte(int idCagnotte, String nameCagnotte, int amountCagnotte) {
		super();
		this.idCagnotte = idCagnotte;
		this.nameCagnotte = nameCagnotte;
		this.amountCagnotte = amountCagnotte;
	}

	public Cagnotte(String nameCagnotte, int amountCagnotte) {
		super();
		this.nameCagnotte = nameCagnotte;
		this.amountCagnotte = amountCagnotte;
	}

	
}
