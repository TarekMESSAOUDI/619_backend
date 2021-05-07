
package tn.esprit.spring.service;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.FileDB;
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
	public void addImageAndAddUnderCategorie (Product p,int idUnderCategorie,MultipartFile file);
	
	

	
	
}


