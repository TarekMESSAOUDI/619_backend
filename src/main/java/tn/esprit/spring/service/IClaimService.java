package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Claim;

public interface IClaimService {
	
	Claim addClaim(Claim c);
	
	boolean deleteClaim(int id);
	
	Claim updateClaim(Claim c);

	Claim retrieveClaim(int id);

	List<Claim> retrieveAllClaims();


}
