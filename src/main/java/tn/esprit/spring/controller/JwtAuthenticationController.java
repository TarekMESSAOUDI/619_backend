package tn.esprit.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;
import tn.esprit.spring.config.JwtTokenUtil;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.exception.UserNotFoundException;
import tn.esprit.spring.response.JwtRequest;
import tn.esprit.spring.response.JwtResponse;
import tn.esprit.spring.security.JwtUserDetailsService;
import tn.esprit.spring.service.IEmailService;
import tn.esprit.spring.service.IUserService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	IUserService us;
	
	@Autowired
	IEmailService es;
	
	@Autowired
	private JavaMailSender jms;
	
	// http://localhost:9091/SpringMVC/servlet/forgot/{email}
	/*@PostMapping("/forgot/{email}")
	public String processForgotPasswordForm(@PathVariable("email") String emailUser,
			HttpServletRequest request){
		String email = request.getParameter("emailUser");
		String token = RandomString.make(45);
		
		try {
			us.updateResettoken(token, email);
			
			String resetPasswordLink = "/updateResettoken?token="+ token;
			
			try {
				sendEmail(email, resetPasswordLink);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "password updated";
	}
	
	*/
	
	@PostMapping("/sending")
	private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = jms.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("tarek.messaoudi.1996@gmail.com","curvanord123kingzoogataga");
		helper.setTo(email);
		helper.setReplyTo("messaouditarek22@gmail.com");		
		String subject = "Here's the link to reset your password";
		String content = "<p>Hello</p>"
							+"You have requested to reset your password."
							+"Click the link below to change your password:"
							+"<a href=\"" +resetPasswordLink + "\">Change my password</a>";
	
		helper.setSubject(subject);
		helper.setText(content,true);
		
		jms.send(message);
	}




	//http://localhost:9091/SpringMVC/servlet/forgot/{email}
	@PostMapping("/forgot/{email}")
	public String processForgotPasswordForm(@PathVariable("email") String emailUser,
			HttpServletRequest request) throws Exception {
		User user = us.findBymail(emailUser);

		if (user == null) {
			return "user not found";
		} else {
			// Generate random 36-character string token for reset password
			user.setResettoken(UUID.randomUUID().toString());

			// Save token to database
			us.updateUser(user);

			String appUrl = request.getServerName()+":"+request.getServerPort()+request.getContextPath();

			// Email message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setTo(user.getEmailUser());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl +  "/servlet/update-user"
					+ user.getResettoken());

			es.sendEmail(passwordResetEmail);
		}
		return "mail sent";
	}

	// http://localhost:9091/SpringMVC/servlet/authenticate
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
