package tn.esprit.spring.response;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;


public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String jwttoken;
	private String type = "Bearer";
	private String username ;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
		
	}


	public JwtResponse(String jwttoken, String username, Collection<? extends GrantedAuthority> collection) {
		this.jwttoken = jwttoken;
		this.username = username;
		this.authorities = collection;
	}


	public String getJwttoken() {
		return jwttoken;
	}


	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
	
}