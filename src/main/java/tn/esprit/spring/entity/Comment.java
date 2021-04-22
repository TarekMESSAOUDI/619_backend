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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
@Table (name = "T_COMMENT")
public class Comment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idComment ;
	private int likeNumberComment ;
	private int disLikeNumberComment ;
	private String descriptionComment ;
	@Temporal (TemporalType.DATE)
	private Date DateComment ;
	private boolean stateComment ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	User user; 

	@ManyToOne
	Subject Subject; 
	
	//Association reflexive :
	@JsonIgnore
	@ManyToOne
	Comment comment ; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Comment")
	@JsonIgnore
	private Set<Comment> Comment;

	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public int getLikeNumberComment() {
		return likeNumberComment;
	}

	public void setLikeNumberComment(int likeNumberComment) {
		this.likeNumberComment = likeNumberComment;
	}

	public int getDisLikeNumberComment() {
		return disLikeNumberComment;
	}

	public void setDisLikeNumberComment(int disLikeNumberComment) {
		this.disLikeNumberComment = disLikeNumberComment;
	}

	public String getDescriptionComment() {
		return descriptionComment;
	}

	public void setDescriptionComment(String descriptionComment) {
		this.descriptionComment = descriptionComment;
	}

	public Date getDateComment() {
		return DateComment;
	}

	public void setDateComment(Date dateComment) {
		DateComment = dateComment;
	}

	public boolean isStateComment() {
		return stateComment;
	}

	public void setStateComment(boolean stateComment) {
		this.stateComment = stateComment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getSubject() {
		return Subject;
	}

	public void setSubject(Subject subject) {
		Subject = subject;
	}

	public Comment getComment1() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Set<Comment> getComment() {
		return Comment;
	}

	public void setComment(Set<Comment> comment) {
		Comment = comment;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Long idComment, int likeNumberComment, int disLikeNumberComment, String descriptionComment,
			Date dateComment, boolean stateComment, User user, tn.esprit.spring.entity.Subject subject, Comment comment,
			Set<Comment> comment2) {
		super();
		this.idComment = idComment;
		this.likeNumberComment = likeNumberComment;
		this.disLikeNumberComment = disLikeNumberComment;
		this.descriptionComment = descriptionComment;
		DateComment = dateComment;
		this.stateComment = stateComment;
		this.user = user;
		Subject = subject;
		this.comment = comment;
		Comment = comment2;
	}

	public Comment(int likeNumberComment, int disLikeNumberComment, String descriptionComment, Date dateComment,
			boolean stateComment, User user, tn.esprit.spring.entity.Subject subject, Comment comment,
			Set<Comment> comment2) {
		super();
		this.likeNumberComment = likeNumberComment;
		this.disLikeNumberComment = disLikeNumberComment;
		this.descriptionComment = descriptionComment;
		DateComment = dateComment;
		this.stateComment = stateComment;
		this.user = user;
		Subject = subject;
		this.comment = comment;
		Comment = comment2;
	}

	public Comment(Long idComment, int likeNumberComment, int disLikeNumberComment, String descriptionComment,
			Date dateComment, boolean stateComment) {
		super();
		this.idComment = idComment;
		this.likeNumberComment = likeNumberComment;
		this.disLikeNumberComment = disLikeNumberComment;
		this.descriptionComment = descriptionComment;
		DateComment = dateComment;
		this.stateComment = stateComment;
	}

	public Comment(int likeNumberComment, int disLikeNumberComment, String descriptionComment, Date dateComment,
			boolean stateComment) {
		super();
		this.likeNumberComment = likeNumberComment;
		this.disLikeNumberComment = disLikeNumberComment;
		this.descriptionComment = descriptionComment;
		DateComment = dateComment;
		this.stateComment = stateComment;
	}
	
	
	
}
