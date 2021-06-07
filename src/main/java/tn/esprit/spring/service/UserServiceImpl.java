package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.twilio.type.PhoneNumber;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.SexeType;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.exception.UserNotFoundException;
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
	public void forgotpass(String emailuser) {
		// TODO Auto-generated method stub
		User d = ur.findByEmailUser(emailuser);
		/* com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+21655717442"), new PhoneNumber("+19286429132"),
		         "Votre commande a été confirmée").create();*/
        final String username = "nader.espritmailer@gmail.com";
        final String password = "12345678aA";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nader.espritmailer@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailuser)
            );
            message.setSubject("Rest Your Password");
            message.setText("Welcom To Consomi Tounsi \n " 
            		+"Dear Client \n"
                    + "Please follow the following link : \n" + "http://localhost:4200/home/forgot/updatepassword");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    

		
	}
	
	
	
	
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
	public ResponseEntity<?> ajouterUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setConfirmPasswordUser(encoder.encode(user.getConfirmPasswordUser()));
		
		if (user == null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add values!"));
		}
		if (user.getPassword().equals(user.getConfirmPasswordUser() != null)) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Confirm your password!"));
		}
		if (user.getAdressUser().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add address !"));
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
		return ResponseEntity.ok(new ResponseMessage("user added Succefully" + user));
	}

	@Override
	public void updateResettoken(String token, String emailUser) throws UserNotFoundException{
		User user = ur.findByEmailUser(emailUser);
		if (user != null){
			user.setResetPasswordToken(token);
			ur.save(user);
		}else{
			throw new UserNotFoundException("could not find User with email" + emailUser);
		}
	}
	
	@Override
	public User get(String resettoken){
		return ur.findByResetPasswordToken(resettoken);
	}
	
	
	@Override
	public User updateUser(@RequestBody User user) throws Exception {
		User userinthedatabase = us.retrieveUserById(user.getIdUser());
		if (!encoder.encode(user.getPassword()).equals(userinthedatabase.getPassword()) && !encoder.encode(user.getConfirmPasswordUser()).equals(userinthedatabase.getConfirmPasswordUser())) {
			user.setPassword(encoder.encode(user.getPassword()));
			user.setPassword(encoder.encode(user.getConfirmPasswordUser()));
		}
		return ur.save(user);
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
	 
	 
	 public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
	        User customer = ur.findByEmailUser(email);
	        if (customer != null) {
	            customer.setResetPasswordToken(token);
	            ur.save(customer);
	        } else {
	            throw new UserNotFoundException("Could not find any customer with the email " + email);
	        }
	    }
	     
	    public User getByResetPasswordToken(String token) {
	        return ur.findByResetPasswordToken(token);
	    }
	     
	    @Override
	    public void updatePassword(String emailUser, String newPassword,String confirmPassword) {
	    	User u = ur.findByEmailUser(emailUser);
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(newPassword);
	        String encodedConfirmPassword = passwordEncoder.encode(confirmPassword);
	        u.setPassword(encodedPassword);
	        u.setConfirmPasswordUser(encodedConfirmPassword);
	         
	        u.setResetPasswordToken(null);
	        ur.save(u);
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
