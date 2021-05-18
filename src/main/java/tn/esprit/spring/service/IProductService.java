
package tn.esprit.spring.service;
import java.util.List;

import java.util.Optional;


import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Articulo;
import tn.esprit.spring.entity.FileDB;

import tn.esprit.spring.entity.Product;




public interface IProductService {
	
	
	public List<Product> showAll();
	public void deleteProduct(int id);
	public Product updateProduct(int id,Product p);
	public Product addProduct(Product p,int id,int idDepartmet);
	public Product GetById(int id);
	public Product GetByName(String nameProduct);
	public List<Product> GetAllByName(String nameProduct);
	
	
	
	public void assignImageToProduct(int idProduct,int idImage);

	

	public void addImageAndAddUnderCategorie (Product p,int idUnderCategorie,MultipartFile file);
	public List<Product> lista();
	public boolean existsId(int idProduct);
	public Optional<Product> getById(int idProduct);
	public boolean existsTitle(String titleProduct);
	public void save(Product product);
	
	
	
	
	
	};

	
	

	
	



