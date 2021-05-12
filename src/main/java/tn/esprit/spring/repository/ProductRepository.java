
package tn.esprit.spring.repository;
import tn.esprit.spring.entity.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


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

//@Query(value = "SELECT * FROM t_product WHERE idDepartment =?1", nativeQuery = true)    //to find a product in the Department
//public List<Product> findByIdDepartment(int idDepartment);
	
	
//	@Query("SELECT"
//			+"DISTINCT p FROM Product p"
//			+"JOIN p.UnderCategory u"
//			+"WHERE p.titleProduct =: titleProduct AND u.idUnderCategory =: idUnderCategory")
//    public List<Product>  GetproductByidUcandTitle(int iduc,String name);
	
	//Meissa
	
	Optional<Product> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}

