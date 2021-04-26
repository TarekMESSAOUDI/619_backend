package tn.esprit.spring.repository;
import tn.esprit.spring.entity.Publicity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PublicityRepository extends CrudRepository<Publicity, Integer> {
	public Publicity findByNamePublicity(String name);
	public List<Publicity> findAllByNamePublicity(String name);
}
