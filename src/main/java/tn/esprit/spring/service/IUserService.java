package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.SexeType;
import tn.esprit.spring.entity.User;

public interface IUserService {
	
	User addUser(User user);

	User updateUser(User user);

	boolean deleteUser(int idUser);

	User retrieveUserById(int idUser);
	
	List<User> retrieveAllUsers();
	
	List<User> retrieveUserByPoint(int pointNumber);

	User retrieveUserByUsername(String username);

	List<User> retrieveUserByState(boolean stateUser);

	List<User> retrieveUserByAdress(String adressUser);

	List<User> retrieveUserByDate(Date birthDateUser);

	List<User> retrieveUserBySexe(SexeType sexeUser);
	
	User findBymail(String emailUser);
	
	List<User> retrieveUserBysalary(float salaire);
	
	List<User> findByRole(Role role);
	
	public User activateUser (User user) throws Exception;
	
	public User desactivateUser (User user) throws Exception;

	long retrieveUserByCount();
	
	public List<String> findUsersActivated() throws Exception;	
	
	public List<String> getUsersFromDisabled();
	
	public void increaseFailedAttempts(User user);
	
	boolean unlockWhenTimeExpired(User user);
	
	void resetFailedAttempts(String emailUser);
	
	void lock(User user);
	
	public User findUserByResetToken(String token);


}
