package tn.esprit.spring.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.FileDB;

@Repository
public interface FileRepository extends CrudRepository<FileDB, Integer>{


}
