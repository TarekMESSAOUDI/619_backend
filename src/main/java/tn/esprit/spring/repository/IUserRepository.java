package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.SexeType;
import tn.esprit.spring.entity.User;

public interface IUserRepository extends CrudRepository<User, Integer>{

	//List<User> findByPointNumberGreaterThan(int pointNumber);
	
	List<User> findByStateUser(boolean stateUser);
	
	List<User> findByAdressUser(String adressUser);
	
	List<User> findByBirthDateUser(Date birthDateUser);
	
	List<User> findBySexeUser(SexeType sexeUser);
	
	List<User> findBySalaireGreaterThan (float salaryDepartmentManager);
	
	long  count();
	
	@Query("SELECT AVG(u.salaire) from User u")
	float retrievemoysalaire();

	@Query("SELECT COUNT(u.salaire)*AVG(u.salaire) from User u")
	float retrievesommesalaire();
	
	@Query("SELECT MAX(u.salaire) from User u")
	float retrievemaxsalaire();
	
	@Query("SELECT u.role FROM User u where  u.idUser =:id")
	public String getUserRole(@Param("id")int id);
	
	@Query("SELECT CONCAT(u.username,CONCAT(' ',u.lastNameUser)) FROM User u where  u.stateUser =TRUE")
	public List<String> getUsersFromActivated();
	
	@Query("SELECT CONCAT(u.username,CONCAT(' ',u.lastNameUser)) FROM User u where  u.stateUser =FALSE")
	public List<String> getUsersFromDisabled();
	
	@Query("Select u FROM User u where u.role= :role")
	List<User> findAllByRole(@Param("role") User user);

	@Query("SELECT e.username,e.emailUser FROM User e")
	List<String> getAllClientNames();
	
	@Query("SELECT MAX(e.pointnumber),e.phoneNumberUser FROM User e")
	List<String> getMaxRank();
	
	@Query("SELECT e.phoneNumberUser,e.adressUser FROM User e GROUP BY e.adressUser")
	List<String> getphonegoupbyadress();
	
	@Query("SELECT MAX(e.birthDateUser) FROM User e ")
	Date getminage();


}