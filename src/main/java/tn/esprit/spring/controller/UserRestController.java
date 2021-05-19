package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.IUserService;


@CrossOrigin(origins = "http://localhost:4200")

//@CrossOrigin(origins="*")

@RestController
public class UserRestController {

	@Autowired
	IUserRepository ur;
	
	@Autowired
	IUserService us;
	
	// http://localhost:9091/SpringMVC/servlet/add-user
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping("/add-user")
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody User user) {
	ResponseEntity<?> u = us.addUser(user);
	return u;
	}
	
	// http://localhost:9091/SpringMVC/servlet/add-user
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping("/ajouter-user")
	@ResponseBody
	public ResponseEntity<?> ajouterUser(@RequestBody User user) {
	ResponseEntity<?> u = us.ajouterUser(user);
	return u;
	}

	// http://localhost:9091/SpringMVC/servlet/delete-user/{user-id}
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping("/delete-user/{idUser}")
	@ResponseBody
	public void deleteUser(@PathVariable("idUser") int userId) {
	us.deleteUser(userId);
	}
	
	// http://localhost:9091/SpringMVC/servlet/update-user
	@PutMapping("/update-user")
	@ResponseBody
	public User updateUser(@RequestBody User user) throws Exception {
	return us.updateUser(user);
	}
	
	
	// http://localhost:9091/SpringMVC/servlet/update-user
//	@PutMapping("/update-user/{id}")
//	//@ResponseBody
//	public ResponseEntity<User> updateUser(@PathVariable("id") int idUser,@RequestBody User user) throws Exception {
//	java.util.Optional<User> userToUpdate = ur.findById(idUser);
//	if (userToUpdate.isPresent()){
//		userToUpdate.get().setUsername(user.getUsername());
//		userToUpdate.get().setLastNameUser(user.getLastNameUser());
//		userToUpdate.get().setEmailUser(user.getEmailUser());
//	}
//	return new ResponseEntity<> (HttpStatus.NOT_FOUND);
//	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-all-user
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-all-user")
	@ResponseBody
	public List<User> getUser() {
	List<User> users = us.retrieveAllUsers();
	return users;
	}
			
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-id/{user-id}
	@GetMapping("/retrieve-user-by-id/{user-id}")
	@ResponseBody
	public User retrieveUserById(@PathVariable("user-id") int userId) {
	return us.retrieveUserById(userId);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-point/{user-point}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-user-by-point/{user-point}")
	@ResponseBody
	public List<User> retrieveUsertByPoint(@PathVariable("user-point") int pointNumber) {
	return us.retrieveUserByPoint(pointNumber);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-client-by-username/{user-username}
	@GetMapping("/retrieve-user-by-username/{user-username}")
	@ResponseBody
	public User retrieveUserByFirstName(@PathVariable("user-username") String username) {
	return us.retrieveUserByUsername(username);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-state/{user-state}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-user-by-state/{user-state}")
	@ResponseBody
	public List<User> retrieveUserByState(@PathVariable("user-state") boolean stateUser) {
	return us.retrieveUserByState(stateUser);
	}	
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-adress/{user-adress}
	@GetMapping("/retrieve-user-by-adress/{user-adress}")
	@ResponseBody
	public List<User> retrieveUserByAdress(@PathVariable("user-adress") String adressUser) {
	return us.retrieveUserByAdress(adressUser);
	}
				
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-date/{user-date}
	@GetMapping("/retrieve-user-by-date/{user-date}")
	@ResponseBody
	public List<User> retrieveUserByDate(@PathVariable("user-date") Date birthDateUser) {
	return us.retrieveUserByDate(birthDateUser);
	}
				
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-sexe/{user-sexe}
	@GetMapping("/retrieve-user-by-sexe/{user-sexe}")
	@ResponseBody
	public List<User> retrieveUserBySexe(@PathVariable("user-sexe") tn.esprit.spring.entity.SexeType sexeUser) {
	return us.retrieveUserBySexe(sexeUser);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-email/{user-email}
	@GetMapping("/retrieve-user-by-email/{user-email}")
	@ResponseBody
	public User retrieveUserByEmail(@PathVariable("user-email") String emailUser) {
	return us.findBymail(emailUser);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-salaire/{user-salaire}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-user-by-salaire/{user-salaire}")
	@ResponseBody
	public List<User> retrieveUserBySalary(@PathVariable("user-salaire") float salaire) {
	return us.retrieveUserBysalary(salaire);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-salairegt/{user-salaire}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-user-by-salairegt/{user-salaire}")
	@ResponseBody
	public List<User> retrieveUserBySalarygt(@PathVariable("user-salaire") float salaire) {
	return ur.findBySalaireGreaterThan(salaire);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-salairelt/{user-salaire}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-user-by-salairelt/{user-salaire}")
	@ResponseBody
	public List<User> retrieveUserBySalarylt(@PathVariable("user-salaire") float salaire) {
	return ur.findBySalaireLessThan(salaire);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-role/{user-role}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-user-by-role/{user-role}")
	@ResponseBody
	public List<User> retrieveUserBySexe(@PathVariable("user-role") Role role) {
	return us.findByRole(role);
	}
	
	// http://localhost:9091/SpringMVC/servlet/users-names
	@GetMapping("/users-names")
	public List<String> getAllUsersNames() throws Exception {
	return ur.getAllClientNames();
	}
	
	// http://localhost:9091/SpringMVC/servlet/activate-user
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/activate-user")
	public User activateUser(@RequestBody User user) throws Exception {
	return us.activateUser(user);
	}
	
	// http://localhost:9091/SpringMVC/servlet/desactivate-User
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/desactivate-User")
	public User desactivateUser(@RequestBody User user) throws Exception {
	return us.desactivateUser(user);
	}
	
	// http://localhost:9091/SpringMVC/servlet/count-user
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/count-user")
	@ResponseBody
	public long retrieveClientByCount() {
	return us.retrieveUserByCount();
	}
	
	// http://localhost:9091/SpringMVC/servlet/findActivatedUser
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/findActivatedUser")
	public List<String> findUserActivated() throws Exception {
		return us.findUsersActivated();
	}

	// http://localhost:9091/SpringMVC/servlet/findDisabledUser
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/findDisabledUser")
	public List<String> findUserDisabled() throws Exception {
		return us.getUsersFromDisabled();
	}
	
	// http://localhost:9091/SpringMVC/servlet/moy-salaire
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/moy-salaire")
	public float salairemoyenne() throws Exception {
	return ur.retrievemoysalaire();
	}
	
	// http://localhost:9091/SpringMVC/servlet/somme-salaire
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/somme-salaire")
	public float salairesomme() throws Exception {
	return ur.retrievesommesalaire();
	}
	
	// http://localhost:9091/SpringMVC/servlet/max-salaire
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/max-salaire")
	public float salairemax() throws Exception {
	return ur.retrievemaxsalaire();
	}
	
	// http://localhost:9091/SpringMVC/servlet/min-age
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/min-age")
	public Date agemin() throws Exception {
	return ur.getminage();
	}
}
