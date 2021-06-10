package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.service.IClaimService;

@RestController

@CrossOrigin("http://localhost:4200")

public class ClaimRestController{
	
	@Autowired
	IClaimService Cs;
	
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-all-claims
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-all-claims")
	@ResponseBody
	public List<Claim> getClaims() {
	List<Claim> list = Cs.retrieveAllClaims();
	return list;
	}
	
	// http://localhost:9091/SpringMVC/servlet/add-claim
	@PostMapping("/add-claim")
	@ResponseBody
	public Claim addClaim(@RequestBody Claim c) {
	Claim claim= Cs.addClaim(c);
	return claim;
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-claim/{claim-id}
	@GetMapping("/retrieve-claim/{claim-id}")
	@ResponseBody
	public Claim retrieveClaim(@PathVariable("claim-id") int idClaim) {
	return Cs.retrieveClaim(idClaim);
	}
	
	// http://localhost:9091/SpringMVC/servlet/remove-claim/{claim-id}
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping("/remove-claim/{claim-id}")
	@ResponseBody
	public void removeUser(@PathVariable("claim-id") int idClaim) {
	Cs.deleteClaim(idClaim);
	}
	
	// http://localhost:9091/SpringMVC/servlet/modify-claim
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/modify-claim")
	@ResponseBody
	public Claim modifyClaim(@RequestBody Claim c) {
	return Cs.updateClaim(c);
}
	}
