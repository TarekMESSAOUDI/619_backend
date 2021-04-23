package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Claim;

@Repository
public interface IClaimRepository extends CrudRepository<Claim,Integer> {
	
}