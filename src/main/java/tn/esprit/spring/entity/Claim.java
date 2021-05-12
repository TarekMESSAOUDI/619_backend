package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
@Table (name = "T_CLAIM")
public class Claim implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idClaim ;
	private String titleClaim ;
	private String descriptionClaim ;
	private StateClaim_Order stateClaim ;
	@Temporal (TemporalType.DATE)
	private Date dateClaim ;
	
	@ManyToOne
	User user;

	public int getIdClaim() {
		return idClaim;
	}

	public void setIdClaim(int idClaim) {
		this.idClaim = idClaim;
	}

	public String getTitleClaim() {
		return titleClaim;
	}

	public void setTitleClaim(String titleClaim) {
		this.titleClaim = titleClaim;
	}

	public String getDescriptionClaim() {
		return descriptionClaim;
	}

	public void setDescriptionClaim(String descriptionClaim) {
		this.descriptionClaim = descriptionClaim;
	}

	public StateClaim_Order getStateClaim() {
		return stateClaim;
	}

	public void setStateClaim(StateClaim_Order stateClaim) {
		this.stateClaim = stateClaim;
	}

	public Date getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(int idClaim, String titleClaim, String descriptionClaim, StateClaim_Order stateClaim, Date dateClaim,
			User user) {
		super();
		this.idClaim = idClaim;
		this.titleClaim = titleClaim;
		this.descriptionClaim = descriptionClaim;
		this.stateClaim = stateClaim;
		this.dateClaim = dateClaim;
		this.user = user;
	}

	public Claim(String titleClaim, String descriptionClaim, StateClaim_Order stateClaim, Date dateClaim, User user) {
		super();
		this.titleClaim = titleClaim;
		this.descriptionClaim = descriptionClaim;
		this.stateClaim = stateClaim;
		this.dateClaim = dateClaim;
		this.user = user;
	}

	public Claim(int idClaim, String titleClaim, String descriptionClaim, StateClaim_Order stateClaim, Date dateClaim) {
		super();
		this.idClaim = idClaim;
		this.titleClaim = titleClaim;
		this.descriptionClaim = descriptionClaim;
		this.stateClaim = stateClaim;
		this.dateClaim = dateClaim;
	}

	public Claim(Date dateClaim, String descriptionClaim, StateClaim_Order stateClaim,String titleClaim  ) {
		super();
		this.dateClaim = dateClaim;
		this.descriptionClaim = descriptionClaim;
		this.stateClaim = stateClaim;
		this.titleClaim = titleClaim;
	}


	
}
