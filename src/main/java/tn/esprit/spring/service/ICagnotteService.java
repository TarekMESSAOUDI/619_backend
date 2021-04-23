package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Cagnotte;



public interface ICagnotteService {
	
	Cagnotte addCagnotte(Cagnotte c);

	List<Cagnotte> getAllCagnotte();

	void deleteCagnotte(int idCagnotte);

	Cagnotte updateCagnotte(Cagnotte c);

	Optional<Cagnotte> getCagnotte_by_ID(int idCagnotte);

}
