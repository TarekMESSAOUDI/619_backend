package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "T_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	protected int idUser ;
	protected String username ;
	protected String lastNameUser ;
	protected String cinUser ;
	protected String password ;
	protected String confirmPasswordUser ;
	protected boolean stateUser ;
	protected String phoneNumberUser ;
	protected String adressUser ;
	@Temporal (TemporalType.DATE)
	protected Date birthDateUser ;
	protected String emailUser ;
	protected String imageUser ;
	@Enumerated (EnumType.STRING)
	protected SexeType sexeUser ;
	protected boolean accountNonLocked;
	@Column(name = "failedAttempt", columnDefinition = "int default 0")
	protected int failedAttempt;
	@Column(name = "lockTime")
	protected Date lockTime;
	@Column(name = "resettoken")
	protected String resettoken;
	protected boolean isBlocked;
	protected LocalDate blockDate;
	protected LocalDate unBlockDate;
	protected boolean isPrivate;
	protected float salaire;
	protected int pointnumber;
	protected boolean avilaibility;
	@Enumerated(EnumType.STRING)
	private ZoneMap zone;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Order> Order;
	
	@OneToOne
	private Basket Basket; 

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Comment> Comment;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<ImageUser> ImageUser1;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Claim> Claim;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<CharityEvent> CharityEvent;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Publicity> Publicity;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	private Set<Delivery> Delivery;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Department> Department;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getCinUser() {
		return cinUser;
	}

	public void setCinUser(String cinUser) {
		this.cinUser = cinUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPasswordUser() {
		return confirmPasswordUser;
	}

	public void setConfirmPasswordUser(String confirmPasswordUser) {
		this.confirmPasswordUser = confirmPasswordUser;
	}

	public boolean isStateUser() {
		return stateUser;
	}

	public void setStateUser(boolean stateUser) {
		this.stateUser = stateUser;
	}

	public String getPhoneNumberUser() {
		return phoneNumberUser;
	}

	public void setPhoneNumberUser(String phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}

	public String getAdressUser() {
		return adressUser;
	}

	public void setAdressUser(String adressUser) {
		this.adressUser = adressUser;
	}

	public Date getBirthDateUser() {
		return birthDateUser;
	}

	public void setBirthDateUser(Date birthDateUser) {
		this.birthDateUser = birthDateUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getImageUser() {
		return imageUser;
	}

	public void setImageUser(String imageUser) {
		this.imageUser = imageUser;
	}

	public SexeType getSexeUser() {
		return sexeUser;
	}

	public void setSexeUser(SexeType sexeUser) {
		this.sexeUser = sexeUser;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public int getFailedAttempt() {
		return failedAttempt;
	}

	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getResettoken() {
		return resettoken;
	}

	public void setResettoken(String resettoken) {
		this.resettoken = resettoken;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public LocalDate getBlockDate() {
		return blockDate;
	}

	public void setBlockDate(LocalDate blockDate) {
		this.blockDate = blockDate;
	}

	public LocalDate getUnBlockDate() {
		return unBlockDate;
	}

	public void setUnBlockDate(LocalDate unBlockDate) {
		this.unBlockDate = unBlockDate;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public int getPointnumber() {
		return pointnumber;
	}

	public void setPointnumber(int pointnumber) {
		this.pointnumber = pointnumber;
	}

	public boolean isAvilaibility() {
		return avilaibility;
	}

	public void setAvilaibility(boolean avilaibility) {
		this.avilaibility = avilaibility;
	}

	public ZoneMap getZone() {
		return zone;
	}

	public void setZone(ZoneMap zone) {
		this.zone = zone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Order> getOrder() {
		return Order;
	}

	public void setOrder(Set<Order> order) {
		Order = order;
	}

	public Basket getBasket() {
		return Basket;
	}

	public void setBasket(Basket basket) {
		Basket = basket;
	}

	public Set<Comment> getComment() {
		return Comment;
	}

	public void setComment(Set<Comment> comment) {
		Comment = comment;
	}

	public Set<ImageUser> getImageUser1() {
		return ImageUser1;
	}

	public void setImageUser1(Set<ImageUser> imageUser1) {
		ImageUser1 = imageUser1;
	}

	public Set<Claim> getClaim() {
		return Claim;
	}

	public void setClaim(Set<Claim> claim) {
		Claim = claim;
	}

	public Set<CharityEvent> getCharityEvent() {
		return CharityEvent;
	}

	public void setCharityEvent(Set<CharityEvent> charityEvent) {
		CharityEvent = charityEvent;
	}

	public Set<Publicity> getPublicity() {
		return Publicity;
	}

	public void setPublicity(Set<Publicity> publicity) {
		Publicity = publicity;
	}

	public Set<Delivery> getDelivery() {
		return Delivery;
	}

	public void setDelivery(Set<Delivery> delivery) {
		Delivery = delivery;
	}

	public Set<Department> getDepartment() {
		return Department;
	}

	public void setDepartment(Set<Department> department) {
		Department = department;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int idUser, String username, String lastNameUser, String cinUser, String password,
			String confirmPasswordUser, boolean stateUser, String phoneNumberUser, String adressUser,
			Date birthDateUser, String emailUser, String imageUser, SexeType sexeUser, boolean accountNonLocked,
			int failedAttempt, Date lockTime, String resettoken, boolean isBlocked, LocalDate blockDate,
			LocalDate unBlockDate, boolean isPrivate, float salaire, int pointnumber, boolean avilaibility,
			ZoneMap zone, Role role, Set<tn.esprit.spring.entity.Order> order, tn.esprit.spring.entity.Basket basket,
			Set<tn.esprit.spring.entity.Comment> comment, Set<tn.esprit.spring.entity.ImageUser> imageUser1,
			Set<tn.esprit.spring.entity.Claim> claim, Set<tn.esprit.spring.entity.CharityEvent> charityEvent,
			Set<tn.esprit.spring.entity.Publicity> publicity, Set<tn.esprit.spring.entity.Delivery> delivery,
			Set<tn.esprit.spring.entity.Department> department) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.imageUser = imageUser;
		this.sexeUser = sexeUser;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.resettoken = resettoken;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.isPrivate = isPrivate;
		this.salaire = salaire;
		this.pointnumber = pointnumber;
		this.avilaibility = avilaibility;
		this.zone = zone;
		this.role = role;
		Order = order;
		Basket = basket;
		Comment = comment;
		ImageUser1 = imageUser1;
		Claim = claim;
		CharityEvent = charityEvent;
		Publicity = publicity;
		Delivery = delivery;
		Department = department;
	}

	public User(String username, String lastNameUser, String cinUser, String password, String confirmPasswordUser,
			boolean stateUser, String phoneNumberUser, String adressUser, Date birthDateUser, String emailUser,
			String imageUser, SexeType sexeUser, boolean accountNonLocked, int failedAttempt, Date lockTime,
			String resettoken, boolean isBlocked, LocalDate blockDate, LocalDate unBlockDate, boolean isPrivate,
			float salaire, int pointnumber, boolean avilaibility, ZoneMap zone, Role role,
			Set<tn.esprit.spring.entity.Order> order, tn.esprit.spring.entity.Basket basket,
			Set<tn.esprit.spring.entity.Comment> comment, Set<tn.esprit.spring.entity.ImageUser> imageUser1,
			Set<tn.esprit.spring.entity.Claim> claim, Set<tn.esprit.spring.entity.CharityEvent> charityEvent,
			Set<tn.esprit.spring.entity.Publicity> publicity, Set<tn.esprit.spring.entity.Delivery> delivery,
			Set<tn.esprit.spring.entity.Department> department) {
		super();
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.imageUser = imageUser;
		this.sexeUser = sexeUser;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.resettoken = resettoken;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.isPrivate = isPrivate;
		this.salaire = salaire;
		this.pointnumber = pointnumber;
		this.avilaibility = avilaibility;
		this.zone = zone;
		this.role = role;
		Order = order;
		Basket = basket;
		Comment = comment;
		ImageUser1 = imageUser1;
		Claim = claim;
		CharityEvent = charityEvent;
		Publicity = publicity;
		Delivery = delivery;
		Department = department;
	}

	public User(int idUser, String username, String lastNameUser, String cinUser, String password,
			String confirmPasswordUser, boolean stateUser, String phoneNumberUser, String adressUser,
			Date birthDateUser, String emailUser, String imageUser, SexeType sexeUser, boolean accountNonLocked,
			int failedAttempt, Date lockTime, String resettoken, boolean isBlocked, LocalDate blockDate,
			LocalDate unBlockDate, boolean isPrivate, float salaire, int pointnumber, boolean avilaibility,
			ZoneMap zone, Role role) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.imageUser = imageUser;
		this.sexeUser = sexeUser;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.resettoken = resettoken;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.isPrivate = isPrivate;
		this.salaire = salaire;
		this.pointnumber = pointnumber;
		this.avilaibility = avilaibility;
		this.zone = zone;
		this.role = role;
	}

	public User(String username, String lastNameUser, String cinUser, String password, String confirmPasswordUser,
			boolean stateUser, String phoneNumberUser, String adressUser, Date birthDateUser, String emailUser,
			String imageUser, SexeType sexeUser, boolean accountNonLocked, int failedAttempt, Date lockTime,
			String resettoken, boolean isBlocked, LocalDate blockDate, LocalDate unBlockDate, boolean isPrivate,
			float salaire, int pointnumber, boolean avilaibility, ZoneMap zone, Role role) {
		super();
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.imageUser = imageUser;
		this.sexeUser = sexeUser;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.resettoken = resettoken;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.isPrivate = isPrivate;
		this.salaire = salaire;
		this.pointnumber = pointnumber;
		this.avilaibility = avilaibility;
		this.zone = zone;
		this.role = role;
	}

	public User(int idUser, String username, String lastNameUser, String cinUser, String password,
			String confirmPasswordUser, boolean stateUser, String phoneNumberUser, String adressUser,
			Date birthDateUser, String emailUser, String imageUser, SexeType sexeUser, boolean accountNonLocked,
			int failedAttempt, Date lockTime, String resettoken, boolean isBlocked, LocalDate blockDate,
			LocalDate unBlockDate, boolean isPrivate, int pointnumber, Role role,
			Set<tn.esprit.spring.entity.Order> order, tn.esprit.spring.entity.Basket basket,
			Set<tn.esprit.spring.entity.Comment> comment, Set<tn.esprit.spring.entity.ImageUser> imageUser1,
			Set<tn.esprit.spring.entity.Claim> claim, Set<tn.esprit.spring.entity.CharityEvent> charityEvent,
			Set<tn.esprit.spring.entity.Publicity> publicity, Set<tn.esprit.spring.entity.Delivery> delivery,
			Set<tn.esprit.spring.entity.Department> department) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.imageUser = imageUser;
		this.sexeUser = sexeUser;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.resettoken = resettoken;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.isPrivate = isPrivate;
		this.pointnumber = pointnumber;
		this.role = role;
		Order = order;
		Basket = basket;
		Comment = comment;
		ImageUser1 = imageUser1;
		Claim = claim;
		CharityEvent = charityEvent;
		Publicity = publicity;
		Delivery = delivery;
		Department = department;
	}

	public User(int idUser, String username, String lastNameUser, String cinUser, String password,
			String confirmPasswordUser, boolean stateUser, String phoneNumberUser, String adressUser,
			Date birthDateUser, String emailUser, String imageUser, SexeType sexeUser, boolean accountNonLocked,
			int failedAttempt, Date lockTime, String resettoken, boolean isBlocked, LocalDate blockDate,
			LocalDate unBlockDate, boolean isPrivate, float salaire, Role role,
			Set<tn.esprit.spring.entity.Order> order, tn.esprit.spring.entity.Basket basket,
			Set<tn.esprit.spring.entity.Comment> comment, Set<tn.esprit.spring.entity.ImageUser> imageUser1,
			Set<tn.esprit.spring.entity.Claim> claim, Set<tn.esprit.spring.entity.CharityEvent> charityEvent,
			Set<tn.esprit.spring.entity.Publicity> publicity, Set<tn.esprit.spring.entity.Delivery> delivery,
			Set<tn.esprit.spring.entity.Department> department) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.imageUser = imageUser;
		this.sexeUser = sexeUser;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.resettoken = resettoken;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.isPrivate = isPrivate;
		this.salaire = salaire;
		this.role = role;
		Order = order;
		Basket = basket;
		Comment = comment;
		ImageUser1 = imageUser1;
		Claim = claim;
		CharityEvent = charityEvent;
		Publicity = publicity;
		Delivery = delivery;
		Department = department;
	}
	
	

}
