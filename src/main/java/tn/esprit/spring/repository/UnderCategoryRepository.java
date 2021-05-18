package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.UnderCategory;

public interface UnderCategoryRepository extends CrudRepository<UnderCategory, Integer>{
	
	@Query("Select d FROM Product d "
			//+ "DISTINCT P FROM Product P "
			//+ "join P.Department D "
			+"where d.UnderCategory.idUnderCategory=:id")
	List<Product> GetproductsbyidUnderCat(@Param("id")int id);
	

}
