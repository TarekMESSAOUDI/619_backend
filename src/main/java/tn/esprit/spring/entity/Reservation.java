package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "T_RESERVATION")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	User user;
	
	@ManyToOne
    CharityEvent charityEvent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CharityEvent getCharityEvent() {
		return charityEvent;
	}

	public void setCharityEvent(CharityEvent charityEvent) {
		this.charityEvent = charityEvent;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int id, User user, CharityEvent charityEvent) {
		super();
		this.id = id;
		this.user = user;
		this.charityEvent = charityEvent;
	}

	public Reservation(User user, CharityEvent charityEvent) {
		super();
		this.user = user;
		this.charityEvent = charityEvent;
	}

	public Reservation(int id) {
		super();
		this.id = id;
	}
	
	
}