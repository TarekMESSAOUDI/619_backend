package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
@Table (name = "T_SUBJECT")
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idSubject ;
	private String titleSubject ;
	private String descriptionSubject ;
	private float starsNumberSubject ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Subject")
	private Set<Comment> Comment;

	public int getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public String getTitleSubject() {
		return titleSubject;
	}

	public void setTitleSubject(String titleSubject) {
		this.titleSubject = titleSubject;
	}

	public String getDescriptionSubject() {
		return descriptionSubject;
	}

	public void setDescriptionSubject(String descriptionSubject) {
		this.descriptionSubject = descriptionSubject;
	}

	public float getStarsNumberSubject() {
		return starsNumberSubject;
	}

	public void setStarsNumberSubject(float starsNumberSubject) {
		this.starsNumberSubject = starsNumberSubject;
	}

	public Set<Comment> getComment() {
		return Comment;
	}

	public void setComment(Set<Comment> comment) {
		Comment = comment;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int idSubject, String titleSubject, String descriptionSubject, float starsNumberSubject,
			Set<tn.esprit.spring.entity.Comment> comment) {
		super();
		this.idSubject = idSubject;
		this.titleSubject = titleSubject;
		this.descriptionSubject = descriptionSubject;
		this.starsNumberSubject = starsNumberSubject;
		Comment = comment;
	}

	public Subject(String titleSubject, String descriptionSubject, float starsNumberSubject,
			Set<tn.esprit.spring.entity.Comment> comment) {
		super();
		this.titleSubject = titleSubject;
		this.descriptionSubject = descriptionSubject;
		this.starsNumberSubject = starsNumberSubject;
		Comment = comment;
	}

	public Subject(int idSubject, String titleSubject, String descriptionSubject, float starsNumberSubject) {
		super();
		this.idSubject = idSubject;
		this.titleSubject = titleSubject;
		this.descriptionSubject = descriptionSubject;
		this.starsNumberSubject = starsNumberSubject;
	}

	public Subject(String titleSubject, String descriptionSubject, float starsNumberSubject) {
		super();
		this.titleSubject = titleSubject;
		this.descriptionSubject = descriptionSubject;
		this.starsNumberSubject = starsNumberSubject;
	}

	
}
