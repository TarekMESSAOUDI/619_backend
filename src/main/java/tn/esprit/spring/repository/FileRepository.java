package tn.esprit.spring.repository;




import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.FileDB;

@Repository
public interface FileRepository extends CrudRepository<FileDB, Integer>{
public Optional<FileDB> findByName(String name);
public List<FileDB> findAll();

}
