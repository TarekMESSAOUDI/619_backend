package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "T_CHARITY_EVENT")
public class CharityEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date datee ;
	private int nbparticipant; 
	private int nbplace ;
	private String titre ;
	private String description;
	
	@JsonIgnore
	@OneToOne
	private Cagnotte Cagnotte;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="charityEvent")
	Set<Reservation> Reservation ;

	@ManyToOne
	User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	public int getNbparticipant() {
		return nbparticipant;
	}

	public void setNbparticipant(int nbparticipant) {
		this.nbparticipant = nbparticipant;
	}

	public int getNbplace() {
		return nbplace;
	}

	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cagnotte getCagnotte() {
		return Cagnotte;
	}

	public void setCagnotte(Cagnotte cagnotte) {
		Cagnotte = cagnotte;
	}

	public Set<Reservation> getReservation() {
		return Reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		Reservation = reservation;
	}

	public CharityEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharityEvent(int id, Date datee, int nbparticipant, int nbplace, String titre, String description,
			tn.esprit.spring.entity.Cagnotte cagnotte, Set<tn.esprit.spring.entity.Reservation> reservation) {
		super();
		this.id = id;
		this.datee = datee;
		this.nbparticipant = nbparticipant;
		this.nbplace = nbplace;
		this.titre = titre;
		this.description = description;
		Cagnotte = cagnotte;
		Reservation = reservation;
	}

	public CharityEvent(Date datee, int nbparticipant, int nbplace, String titre, String description,
			tn.esprit.spring.entity.Cagnotte cagnotte, Set<tn.esprit.spring.entity.Reservation> reservation) {
		super();
		this.datee = datee;
		this.nbparticipant = nbparticipant;
		this.nbplace = nbplace;
		this.titre = titre;
		this.description = description;
		Cagnotte = cagnotte;
		Reservation = reservation;
	}

	public CharityEvent(int id, Date datee, int nbparticipant, int nbplace, String titre, String description) {
		super();
		this.id = id;
		this.datee = datee;
		this.nbparticipant = nbparticipant;
		this.nbplace = nbplace;
		this.titre = titre;
		this.description = description;
	}

	public CharityEvent(Date datee, int nbparticipant, int nbplace, String titre, String description) {
		super();
		this.datee = datee;
		this.nbparticipant = nbparticipant;
		this.nbplace = nbplace;
		this.titre = titre;
		this.description = description;
	}
	
	
}
