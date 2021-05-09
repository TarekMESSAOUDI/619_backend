
package tn.esprit.spring.repository;
import tn.esprit.spring.entity.Department;

import tn.esprit.spring.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PathVariable;


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
	
	
	@Query(value="SELECT product_title,product_descirption,name,data FROM t_product INNERJOIN  files ON t_product.id=files.id ", nativeQuery = true)
	public List<Product> getProductswithImages();
//	@Query("Select p.idProduct FROM Product p "
//			+ "DISTINCT i.data FROM FileDB i "
//			+ "join i.Product p "
//			
//			)
//	public List<Object> getProductswithImages();

	
	
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
	///////////////////////////////////////////////////////////////
	/*
	@Query("Select "
			+ "DISTINCT p.idProduct from Product p "
			+ "join p.Department dep "
			+ "where dep.idDepartment=:idDepartment")
    public List<Product> findByIdDepartment( int idDepartment);
	*/
	//////////////////////////////////////////////////////////
	/*
	@Query("SELECT p.idProduct FROM Product d where Department.idDepartment = : idDepartment")
	List<Product>findByIdDepartment(int idDepartment);
	
    */
	//////////////////////////////////////////////////
	/*
	@Query(value = "SELECT * FROM product WHERE idDepartment =?1", nativeQuery = true)
	public List<Product> findProduitParRayon(int IdDepartment);
	*/

	
	
	
	
	
	//public List<Product> findByIdDepartment(int idDepartment);
	
	
	
	
	
	

	
	
	
	
}

