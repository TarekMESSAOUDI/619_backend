package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reservation;


@Repository
public interface IReservationRepository extends CrudRepository<Reservation,Integer>{

}