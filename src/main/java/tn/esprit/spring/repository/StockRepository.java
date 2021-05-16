package tn.esprit.spring.repository;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.entity.TypeStock;

public interface StockRepository extends CrudRepository<Stock,Long> {

	@Query(value = "SELECT * FROM T1_Stock stk WHERE stk.name_Stock = :t" , nativeQuery =true)      // Stock Rest messing
List<Stock> findByName(@Param("t")String nameStock);
	
	
	@Query("SELECT MAX(s.quantityStock)FROM Stock s")   
	 public int MaxQuantity();
	
	
	@Query(value="SELECT p.idProduct FROM Product p,Stock s  WHERE   p.quantityProduct<10 ",nativeQuery=true)
	List<Long> missingProduct();
	
	
	
	
	@Query("SELECT COUNT(*) FROM Stock")
public int stocknumber();
	
}


