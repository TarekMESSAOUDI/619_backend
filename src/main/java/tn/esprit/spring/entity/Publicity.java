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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
@Entity
@Table (name = "T_PUBLICITY")
public class Publicity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPublicity ;
	private String namePublicity ;
	@Temporal (TemporalType.DATE)
	private Date startDatePublicity ;
	@Temporal (TemporalType.DATE)
	private Date endDatePublicity ;
	@Enumerated (EnumType.STRING)
	private TargetPublicity targetPublicity ;
	@Enumerated (EnumType.STRING)
	private ChannelPublicity channelPublicity ;
	private float costPublicity ;
	private boolean statusPublicity ;
	private String mailOwnerPublicity ;
	private int phoneOwnerPublicity ;
	private String typePublicity ;
	private String descriptionPublicity ;
	private int InitialViewNumber ;
	private int finalViewNumber ;
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@ManyToOne
	@JsonIgnore
	User user;

	public int getIdPublicity() {
		return idPublicity;
	}

	public void setIdPublicity(int idPublicity) {
		this.idPublicity = idPublicity;
	}

	public String getNamePublicity() {
		return namePublicity;
	}

	public void setNamePublicity(String namePublicity) {
		this.namePublicity = namePublicity;
	}

	public Date getStartDatePublicity() {
		return startDatePublicity;
	}

	public void setStartDatePublicity(Date startDatePublicity) {
		this.startDatePublicity = startDatePublicity;
	}

	public Date getEndDatePublicity() {
		return endDatePublicity;
	}

	public void setEndDatePublicity(Date endDatePublicity) {
		this.endDatePublicity = endDatePublicity;
	}

	public TargetPublicity getTargetPublicity() {
		return targetPublicity;
	}

	public void setTargetPublicity(TargetPublicity targetPublicity) {
		this.targetPublicity = targetPublicity;
	}

	public ChannelPublicity getChannelPublicity() {
		return channelPublicity;
	}

	public void setChannelPublicity(ChannelPublicity channelPublicity) {
		this.channelPublicity = channelPublicity;
	}

	public float getCostPublicity() {
		return costPublicity;
	}

	public void setCostPublicity(float costPublicity) {
		this.costPublicity = costPublicity;
	}

	public boolean isStatusPublicity() {
		return statusPublicity;
	}

	public void setStatusPublicity(boolean statusPublicity) {
		this.statusPublicity = statusPublicity;
	}

	public String getMailOwnerPublicity() {
		return mailOwnerPublicity;
	}

	public void setMailOwnerPublicity(String mailOwnerPublicity) {
		this.mailOwnerPublicity = mailOwnerPublicity;
	}

	public int getPhoneOwnerPublicity() {
		return phoneOwnerPublicity;
	}

	public void setPhoneOwnerPublicity(int phoneOwnerPublicity) {
		this.phoneOwnerPublicity = phoneOwnerPublicity;
	}

	public String getTypePublicity() {
		return typePublicity;
	}

	public void setTypePublicity(String typePublicity) {
		this.typePublicity = typePublicity;
	}

	public String getDescriptionPublicity() {
		return descriptionPublicity;
	}

	public void setDescriptionPublicity(String descriptionPublicity) {
		this.descriptionPublicity = descriptionPublicity;
	}

	public int getInitialViewNumber() {
		return InitialViewNumber;
	}

	public void setInitialViewNumber(int initialViewNumber) {
		InitialViewNumber = initialViewNumber;
	}

	public int getFinalViewNumber() {
		return finalViewNumber;
	}

	public void setFinalViewNumber(int finalViewNumber) {
		this.finalViewNumber = finalViewNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Publicity(int idPublicity, String namePublicity, Date startDatePublicity, Date endDatePublicity,
			TargetPublicity targetPublicity, ChannelPublicity channelPublicity, float costPublicity,
			boolean statusPublicity, String mailOwnerPublicity, int phoneOwnerPublicity, String typePublicity,
			String descriptionPublicity, int initialViewNumber, int finalViewNumber, User user) {
		super();
		this.idPublicity = idPublicity;
		this.namePublicity = namePublicity;
		this.startDatePublicity = startDatePublicity;
		this.endDatePublicity = endDatePublicity;
		this.targetPublicity = targetPublicity;
		this.channelPublicity = channelPublicity;
		this.costPublicity = costPublicity;
		this.statusPublicity = statusPublicity;
		this.mailOwnerPublicity = mailOwnerPublicity;
		this.phoneOwnerPublicity = phoneOwnerPublicity;
		this.typePublicity = typePublicity;
		this.descriptionPublicity = descriptionPublicity;
		InitialViewNumber = initialViewNumber;
		this.finalViewNumber = finalViewNumber;
		this.user = user;
	}

	public Publicity(String namePublicity, Date startDatePublicity, Date endDatePublicity,
			TargetPublicity targetPublicity, ChannelPublicity channelPublicity, float costPublicity,
			boolean statusPublicity, String mailOwnerPublicity, int phoneOwnerPublicity, String typePublicity,
			String descriptionPublicity, int initialViewNumber, int finalViewNumber, User user) {
		super();
		this.namePublicity = namePublicity;
		this.startDatePublicity = startDatePublicity;
		this.endDatePublicity = endDatePublicity;
		this.targetPublicity = targetPublicity;
		this.channelPublicity = channelPublicity;
		this.costPublicity = costPublicity;
		this.statusPublicity = statusPublicity;
		this.mailOwnerPublicity = mailOwnerPublicity;
		this.phoneOwnerPublicity = phoneOwnerPublicity;
		this.typePublicity = typePublicity;
		this.descriptionPublicity = descriptionPublicity;
		InitialViewNumber = initialViewNumber;
		this.finalViewNumber = finalViewNumber;
		this.user = user;
	}

	public Publicity(int idPublicity, String namePublicity, Date startDatePublicity, Date endDatePublicity,
			TargetPublicity targetPublicity, ChannelPublicity channelPublicity, float costPublicity,
			boolean statusPublicity, String mailOwnerPublicity, int phoneOwnerPublicity, String typePublicity,
			String descriptionPublicity, int initialViewNumber, int finalViewNumber) {
		super();
		this.idPublicity = idPublicity;
		this.namePublicity = namePublicity;
		this.startDatePublicity = startDatePublicity;
		this.endDatePublicity = endDatePublicity;
		this.targetPublicity = targetPublicity;
		this.channelPublicity = channelPublicity;
		this.costPublicity = costPublicity;
		this.statusPublicity = statusPublicity;
		this.mailOwnerPublicity = mailOwnerPublicity;
		this.phoneOwnerPublicity = phoneOwnerPublicity;
		this.typePublicity = typePublicity;
		this.descriptionPublicity = descriptionPublicity;
		InitialViewNumber = initialViewNumber;
		this.finalViewNumber = finalViewNumber;
	}

	public Publicity(String namePublicity, Date startDatePublicity, Date endDatePublicity,
			TargetPublicity targetPublicity, ChannelPublicity channelPublicity, float costPublicity,
			boolean statusPublicity, String mailOwnerPublicity, int phoneOwnerPublicity, String typePublicity,
			String descriptionPublicity, int initialViewNumber, int finalViewNumber) {
		super();
		this.namePublicity = namePublicity;
		this.startDatePublicity = startDatePublicity;
		this.endDatePublicity = endDatePublicity;
		this.targetPublicity = targetPublicity;
		this.channelPublicity = channelPublicity;
		this.costPublicity = costPublicity;
		this.statusPublicity = statusPublicity;
		this.mailOwnerPublicity = mailOwnerPublicity;
		this.phoneOwnerPublicity = phoneOwnerPublicity;
		this.typePublicity = typePublicity;
		this.descriptionPublicity = descriptionPublicity;
		InitialViewNumber = initialViewNumber;
		this.finalViewNumber = finalViewNumber;
	}
	public Publicity(String namePublicity, Date startDatePublicity, Date endDatePublicity,
			TargetPublicity targetPublicity, ChannelPublicity channelPublicity, float costPublicity,
			boolean statusPublicity, String mailOwnerPublicity, int phoneOwnerPublicity, String typePublicity,
			String descriptionPublicity, int initialViewNumber, int finalViewNumber, String fileName) {
		super();
		this.namePublicity = namePublicity;
		this.startDatePublicity = startDatePublicity;
		this.endDatePublicity = endDatePublicity;
		this.targetPublicity = targetPublicity;
		this.channelPublicity = channelPublicity;
		this.costPublicity = costPublicity;
		this.statusPublicity = statusPublicity;
		this.mailOwnerPublicity = mailOwnerPublicity;
		this.phoneOwnerPublicity = phoneOwnerPublicity;
		this.typePublicity = typePublicity;
		this.descriptionPublicity = descriptionPublicity;
		InitialViewNumber = initialViewNumber;
		this.finalViewNumber = finalViewNumber;
		this.fileName = fileName;
	}

	public Publicity() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	
	
}
