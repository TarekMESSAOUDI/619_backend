package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.SexeType;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.response.ResponseMessage;
import tn.esprit.spring.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository ur;
	
	@Autowired
	IUserService us;
	
	@Autowired
	PasswordEncoder encoder;
	

	@Override
	public ResponseEntity<?> addUser(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		user.setConfirmPasswordUser(encoder.encode(user.getConfirmPasswordUser()));
		user.setStateUser(true);
		user.setAccountNonLocked(true);
		user.setFailedAttempt(0);
		user.setRole(Role.CLIENT);
		
		if (user == null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add values!"));
		}
		if (user.getPassword().equals(user.getConfirmPasswordUser() != null)) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Confirm your password!"));
		}
		if (user.getAdressUser().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add address!"));
		}
		if (user.getAdressUser().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add bithday date!"));
		}
		if (!(user.getBirthDateUser() instanceof Date)) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add bithday date!"));
		}
		if (user.getUsername().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add your first name!"));
		}
		if (user.getEmailUser().equals("") || !UserServiceImpl.validate(user.getEmailUser())) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please check your mail!"));
		}
		if (us.retrieveUserByUsername(user.getUsername()) != null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Username is already taken!"));
		}
		if (us.findBymail(user.getEmailUser()) != null) {
				return ResponseEntity.badRequest().body(new ResponseMessage("Error: Email is already taken!"));		
		}
		ur.save(user);
		return ResponseEntity.ok(new ResponseMessage("user added Succefully"));
	}

	@Override
	public User updateUser(@RequestBody User user) throws Exception {
		User userinthedatabase = us.retrieveUserById(user.getIdUser());
		if (!encoder.encode(user.getPassword()).equals(userinthedatabase.getPassword())) {
			user.setPassword(encoder.encode(user.getPassword()));
		}
		return us.updateUser(user);
	}

	@Override
	public boolean deleteUser(int idUser) {
		if (ur.existsById(idUser)){
			ur.deleteById(idUser);
			return true;
		}else
		return false;
	}

	@Override
	public User retrieveUserById(int idUser) {
		return ur.findById(idUser).get();
	}

	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) ur.findAll();
	}

	@Override
	public List<User> retrieveUserByPoint(int pointNumber) {
		return ur.findByPointnumber(pointNumber);
	}

	@Override
	public User retrieveUserByUsername(String username) {
		return ur.findByUsername(username);
	}

	@Override
	public List<User> retrieveUserByState(boolean stateUser) {
		return ur.findByStateUser(stateUser);
	}

	@Override
	public List<User> retrieveUserByAdress(String adressUser) {
		return ur.findByAdressUser(adressUser);
	}

	@Override
	public List<User> retrieveUserByDate(Date birthDateUser) {
		return ur.findByBirthDateUser(birthDateUser);
	}

	@Override
	public List<User> retrieveUserBySexe(SexeType sexeUser) {
		return ur.findBySexeUser(sexeUser);
	}

	@Override
	public User activateUser (User user) throws Exception {
		user.setStateUser(true);
		return updateUser(user);
	}

	@Override
	public User desactivateUser (User user) throws Exception {
		user.setStateUser(false);
		return updateUser(user);
	}

	@Override
	public long retrieveUserByCount() {
		return ur.count();
	}

	@Override
	public List<String> findUsersActivated() throws Exception {
		return ur.getUsersFromActivated();
	}

	@Override
	public List<String> getUsersFromDisabled() {
		return ur.getUsersFromDisabled();
	}

	@Override
    public boolean unlockWhenTimeExpired(User user) {
        long lockTimeInMillis = user.getLockTime().getTime();
        long currentTimeInMillis = System.currentTimeMillis();
         
        if (lockTimeInMillis < currentTimeInMillis) {
            user.setAccountNonLocked(true);
            user.setLockTime(null);
            user.setFailedAttempt(0);
            ur.save(user);
             
            return true;
        }
        return false;
    }
	public static boolean validate(String emailStr) {
        boolean matcher = emailStr != null;
        return matcher;
}

	 @Override
	    public void resetFailedAttempts(String email) {
	    }

	 @Override
	    public void lock(User user) {
	        user.setAccountNonLocked(false);
	        user.setLockTime(new Date());
	        ur.save(user);
	    }

	 @Override
		public User findUserByResetToken(String login) {
			// TODO Auto-generated method stub
			return ur.findUserByresettoken(login);
		}

	@Override
	public User findBymail(String emailUser) {
		return ur.findByEmailUser(emailUser);
	}

	@Override
	public List<User> retrieveUserBysalary(float salaire) {
		return ur.findBySalaireGreaterThan(salaire);
	}

	@Override
	public List<User> findByRole(Role role) {
		return ur.findByRole(role);
	}

	@Override
	public void increaseFailedAttempts(User user) {
		// TODO Auto-generated method stub
		
	}

}
