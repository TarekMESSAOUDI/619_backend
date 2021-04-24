package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CharityEvent;


@Repository
public interface ICharityEventRepository extends CrudRepository<CharityEvent, Integer>{
	
	
	@Query(value = "SELECT e.nbplace FROM charityevent as e WHERE e.id_e=?1", nativeQuery = true)
	public int NombrePlacesEvent(int idevent);
	@Query(value = "SELECT e.nbparticipant FROM charityevent as e WHERE e.id_e=?1", nativeQuery = true)
	public int NombreParticpEvent(int idevent);
	@Query(value = "SELECT DISTINCT e.id_e FROM charityevent as e", nativeQuery = true)
	public List<Integer> CharityEventList();
	
}