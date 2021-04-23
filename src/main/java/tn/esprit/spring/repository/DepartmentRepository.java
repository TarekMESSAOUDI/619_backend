package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

	Department saveAndFlush(Department dep);

	
	
	//@Query(value = "SELECT * FROM t_department WHERE nameDepartment LIKE ?1%", nativeQuery = true)
	//public List<Department> findRayonbyName(String name);
	
	
	
	
	
	
	
}
