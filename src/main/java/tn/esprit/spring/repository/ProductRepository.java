
package tn.esprit.spring.repository;
import tn.esprit.spring.entity.Department;

import tn.esprit.spring.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends CrudRepository<Product, Integer>  {
	
public Product findByTitleProduct(String name);
public List<Product> findAllByTitleProduct(String name);

	@Query("SELECT 'title :',p.titleProduct ,'---->','Gain :', (p.priceProduct) - (p.buyingPriceProduct) FROM Product p")
	public List<String> getgainproduct();
	
	@Query("SELECT  SUM((((p.priceProduct) - (p.buyingPriceProduct))*(p.quantityProduct))),'DT' FROM Product p")
	public float gettotalgainproduct();
	
	@Query("SELECT  SUM(p.buyingPriceProduct) FROM Product p")
	public float getallcostproduct();
	
	@Query("SELECT  SUM(p.priceProduct) FROM Product p")
	public float getallbuyproduct();


	@Query("Select MAX(p.buyingPriceProduct)FROM Product p")
	public float MostExpensiveProduct();

	
	
//@Query(value = "SELECT * FROM product p WHERE p.idProduct =?1", nativeQuery = true)    //to find a product in the Department
//public List<Product> findByIdDepartment(int idDepartment);
	


//@Query(value = "SELECT * FROM t_product WHERE id=?1", nativeQuery = true)
//public Product findProduct();
	


/*
	@Query("SELECT " 
			+"DISTINCT p.idProduct FROM Product p "
			+"JOIN p.Department d "
			+"WHERE d.idDepartment =: idDepartment")
	public List<Product> findByIdDepartment(int idDepartment);
	*/
	
	
	@Query("Select "
			+ "DISTINCT p.idProduct from Product p "
			+ "join p.Department dep "
			+ "where dep.idDepartment=:idDepartment")
    public List<Product> findByIdDepartment( int idDepartment);
	
	
}

