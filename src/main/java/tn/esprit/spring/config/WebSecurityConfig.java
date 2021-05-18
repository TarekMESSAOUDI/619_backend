package tn.esprit.spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
		// dont authenticate this particular request
	
		.authorizeRequests()
		.antMatchers("/servlet/retrieve-all-Stocks").permitAll()
		.antMatchers("/servlet/add-department").permitAll()
		.antMatchers("/servlet/remove-department/{department-id}").permitAll()
		.antMatchers("/servlet/add-stock").permitAll()
		.antMatchers("/servlet/remove-stock/{stock-id}").permitAll()
		.antMatchers("/servlet/update-stock").permitAll()
		.antMatchers("/servlet/alteProductToDepartment/{iddepartment}/{idproduct}").permitAll()
		.antMatchers("/servlet/add-product").permitAll()
		.antMatchers("/servlet/Departmentss").permitAll()
		.antMatchers("/servlet/PostPubImage").permitAll()
		.antMatchers("/servlet/depart/{id}").permitAll()
		.antMatchers("servlet/department/{id}").permitAll()
		.antMatchers("/servlet/Getprodbydep/{idDepartment}").permitAll()
		.antMatchers("/servlet/Productss").permitAll()
		
		
		.antMatchers("/servlet/remove-publicity/{pubId}").permitAll()
		.antMatchers("/servlet/add-user").permitAll()
		.antMatchers("/servlet/update-user").permitAll()
		.antMatchers("/servlet/ajouter-user").permitAll()
		.antMatchers("/servlet/retrieve-all-user").permitAll()
		.antMatchers("/servlet/delete-user/{idUser}").permitAll()
		.antMatchers("/servlet/add-subject").permitAll()
		.antMatchers("/servlet/forgot_password").permitAll()
		.antMatchers("/servlet/reset_password").permitAll()
		.antMatchers("/servlet/sendme/{emailUser}").permitAll()
		.antMatchers("/servlet/updatepassword/{emailUser}/{password}/{cpassword}").permitAll()
		.antMatchers("/servlet/add-publicity").permitAll()
		.antMatchers("/servlet/ImgPublcities/{id}").permitAll()
		.antMatchers("/servlet/userss").permitAll()
		.antMatchers("/servlet/Imguserss/{id}").permitAll()
		
		.antMatchers("/servlet/authenticate").permitAll()
		.antMatchers("/servlet/forgot/{email}").permitAll()
		.antMatchers("/servlet/add-basket").permitAll()
		.antMatchers("/servlet/affect-basket-to-user/{idbasket}/{iduser}").permitAll()
		.antMatchers("/servlet/add-bill").permitAll()
		.antMatchers("/servlet/show-all-categories").permitAll()
		.antMatchers("/servlet/retrieve-by-name/{nameCat}").permitAll()
		.antMatchers("/servlet/retrieve-cat-by-id/{id}").permitAll()
		.antMatchers("/servlet/retrieveallEvent").permitAll()
		.antMatchers("/servlet/FaireReservation/{idReservation}/{idUser}/{idEvent}").permitAll()
		.antMatchers("/servlet/addReservation").permitAll()
		.antMatchers("/servlet/add-claim").permitAll()
		.antMatchers("/servlet/retrieve-claim/{claim-id}").permitAll()
		.antMatchers("/servlet/retrieve-all-Comments").permitAll()
		.antMatchers("/servlet/retrieve-comment/{comment-id}").permitAll()
		.antMatchers("/servlet/remove-comment/{comment-id}").permitAll()
		.antMatchers("/servlet/modify-comment").permitAll()
		.antMatchers("/servlet/afficherNbcomment").permitAll()
		.antMatchers("/servlet/add-comment").permitAll()
		.antMatchers("/servlet/affecterSubjecttoComment/{ids}/{id}").permitAll()
		.antMatchers("/servlet/Getcommentbysubject/{idComment}").permitAll()
		.antMatchers("/servlet/retrieve-department/{department-id}").permitAll()
		.antMatchers("/servlet/retrieve-all-Departments").permitAll()
		.antMatchers("/servlet/uploaded").permitAll()
		.antMatchers("/servlet/affect-image-to-user/{idimage}/{iduser}").permitAll()
		.antMatchers("/servlet/show-all-products").permitAll()
		.antMatchers("/servlet/GetByOneName/{productName}").permitAll()
		.antMatchers("/servlet/GetById/{productId}").permitAll()
		.antMatchers("/servlet/ShowAllByName/{productName}").permitAll()
		.antMatchers("/servlet/show-all-publicities").permitAll()
		.antMatchers("/servlet/get-by-Name-all-publicities-by-name/{PubName}").permitAll()
		.antMatchers("/servlet/get-by-id-publicity/{publicityId}").permitAll()
		.antMatchers("/servlet/retrieve-all-subjects").permitAll()
		.antMatchers("/servlet/retrieve-subject-by-id/{subject-id}").permitAll()
		.antMatchers("/servlet/retrieve-subject-by-title/{subject-title}").permitAll()
		.antMatchers("/servlet/retrieve-subject-by-starsgreater/{subject-stars}").permitAll()
		.antMatchers("/servlet/retrieve-max-stars-subject").permitAll()
		.antMatchers("/servlet/retrieve-min-stars-subject").permitAll()
		.antMatchers("/servlet/retrieve-subject-by-starsless/{subject-starsless}").permitAll()
		.antMatchers("/servlet/show-all-under-categories").permitAll()
		.antMatchers("/servlet/show-all-categories").permitAll()
		.antMatchers("/servlet/GetByIdUnderCat/{underCategorytId}").permitAll()
		.antMatchers("/servlet/update-user").permitAll()
		.antMatchers("/servlet/retrieve-user-by-id/{user-id}").permitAll()
		.antMatchers("/servlet/retrieve-user-by-username/{user-username}").permitAll()
		.antMatchers("/servlet/retrieve-user-by-adress/{user-adress}").permitAll()
		.antMatchers("/servlet/retrieve-user-by-date/{user-date}").permitAll()
		.antMatchers("/servlet/retrieve-user-by-sexe/{user-sexe}").permitAll()
		.antMatchers("/servlet/retrieve-user-by-email/{user-email}").permitAll()
		.antMatchers("/servlet/users-names").permitAll()
		.antMatchers("/servlet/sending").permitAll()
		
		// all other requests need to be authenticated
		.anyRequest().authenticated().and().
		// make sure we use stateless session; session won't be used to
		// store user's state.
		exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().regexMatchers("^(/servlet/authenticate).*");
	}
}
