
package tn.esprit.spring.repository;
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
	
	
	@Query(value="SELECT product_title,product_descirption,name,data FROM t_product INNERJOIN  files ON t_product.id=files.id ", nativeQuery = true)
	public List<Product> getProductswithImages();
//	@Query("Select p.idProduct FROM Product p "
//			+ "DISTINCT i.data FROM FileDB i "
//			+ "join i.Product p "
//			
//			)
//	public List<Object> getProductswithImages();

//@Query(value = "SELECT * FROM t_product WHERE idDepartment =?1", nativeQuery = true)    //to find a product in the Department
//public List<Product> findByIdDepartment(int idDepartment);
	
	
//	@Query("SELECT"
//			+"DISTINCT p FROM Product p"
//			+"JOIN p.UnderCategory u"
//			+"WHERE p.titleProduct =: titleProduct AND u.idUnderCategory =: idUnderCategory")
//    public List<Product>  GetproductByidUcandTitle(int iduc,String name);

	@Query(value = "SELECT * FROM t_product t WHERE under_category_id_undercategory=?1", nativeQuery = true)
	public List<Product> findAllProductByIdUnderCategory(@Param("id")int id);
	
	
	
}



