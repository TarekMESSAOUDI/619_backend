package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ImageUser;

@Repository
public interface IImageUserRepository extends CrudRepository <ImageUser,Integer>{

}
