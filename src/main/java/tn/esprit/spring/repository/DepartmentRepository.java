package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Department;
import tn.esprit.spring.entity.Stock;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

	Department saveAndFlush(Department dep);

	
	
	//@Query(value = "SELECT * FROM t_department WHERE nameDepartment LIKE ?1%", nativeQuery = true)
	//public List<Department> findRayonbyName(String name);
	
	
	
	
	@Query(value = "SELECT * FROM T_DEPARTMENT stk WHERE stk.name_department = :t" , nativeQuery =true)      
	List<Department> findDepByName(@Param("t")String nameStock);
	
	
}
