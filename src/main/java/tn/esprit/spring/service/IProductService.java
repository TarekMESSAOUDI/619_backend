
package tn.esprit.spring.service;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Product;




public interface IProductService {
	
	
	public List<Product> showAll();
	public void deleteProduct(int id);
	public Product updateProduct(Product p);
	public Product addProduct(Product p);
	public Product GetById(int id);
	public Product GetByName(String nameProduct);
	public List<Product> GetAllByName(String nameProduct);
	

	
	public void assignImageToProduct(int idProduct,int idImage);
	public List<Product> list();
	public boolean existsId(int idProduct);
	public Optional getById(int idProduct);
	public boolean existsNombre(String nombre);
	public void save(Product product);
	
	

	
	
}


