
package tn.esprit.spring.service;



import java.io.IOException;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.repository.DepartmentRepository;
import tn.esprit.spring.repository.FileRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.UnderCategoryRepository;
import tn.esprit.spring.entity.Department;
import tn.esprit.spring.entity.FileDB;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.UnderCategory;



@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired 
	FileRepository filerepository;
	@Autowired
	UnderCategoryRepository UCR;
	@Autowired
	FileStrorageService FileStorageService;
	@Autowired
	UnderCategoryRepository ucr;
	@Autowired
	DepartmentRepository dr;

	
	private static final Logger L = LogManager.getLogger(IProductService.class);
	
	@Override
	public List<Product> showAll() {
		List<Product> products =(List<Product>) productRepository.findAll();
		for (Product product : products){
			L.info("Product +++ :" + product);
		}
		return products;

	}

	@Override  
	public Product addProduct(Product p,int id,int idDepratment) {
		
		UnderCategory undercat=ucr.findById(id).get();
		p.setUnderCategory(undercat);
		
		Department dep=dr.findById(idDepratment).get();
		p.setIdDepartment(dep);
		
		productRepository.save(p);
		return p;
	}

	@Override //done
	public void deleteProduct(int id) {
		if (productRepository.existsById(id))
		{
		productRepository.deleteById(id);
		}
		else System.out.println("Product with id:"+id+" Not exist");
	}

 

	@Override
	public Product GetById(int id) {
		return productRepository.findById(id).orElse(null); 	
	}

	@Override
	public Product GetByName(String nameProduct) {
		return productRepository.findByTitleProduct(nameProduct);
		 
	}

	@Override
	public List<Product> GetAllByName(String nameProduct) {
		List<Product> products =(List<Product>) productRepository.findAllByTitleProduct(nameProduct);
		for (Product product : products){
			L.info("Product +++ :" + product);
		}
		return products;
		
		
	}




	@Override
	public Product updateProduct(int id,Product p) {
		
		Product existingProduct=productRepository.findById(id).get();
		
		
	
		existingProduct.setTitleProduct(p.getTitleProduct());
		existingProduct.setDescriptionProduct(p.getDescriptionProduct());
		existingProduct.setQuantityProduct(p.getQuantityProduct());
		existingProduct.setPriceProduct(p.getPriceProduct());
		existingProduct.setBarcodeProduct(p.getBarcodeProduct());
		existingProduct.setWeightProduct(p.getWeightProduct());
		existingProduct.setBuyingPriceProduct(p.getBuyingPriceProduct());
		existingProduct.setMaxQuantityProduct(p.getMaxQuantityProduct());
	
		return productRepository.save(existingProduct);
	
	}


	

	@Override
	public void assignImageToProduct(int idProduct, int idImage) {
		Product product=productRepository.findById(idProduct).get();
		FileDB image=filerepository.findById(idImage).get();
		image.setProduct(product);
		filerepository.save(image);	
		
	}

	@Override
	public void addImageAndAddUnderCategorie(Product p, int idUnderCategorie, MultipartFile file) {
		
//		productRepository.save(p);
//		UnderCategory undercategory=UCR.findById(idUnderCategorie).get();
//		Product product= productRepository.findById(p.getIdProduct()).get();
//		
//		product.setUnderCategory(undercategory);
		productRepository.save(p);
		
		try {
			FileStorageService.store(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		product=productRepository.findById(p.getIdProduct()).get();
//		FileDB filee=new FileDB();
//		filee.setProduct(p);
//		filerepository.save(filee);
//		FileDB image=filerepository.findById(filedb.getId()).get();
//		image.setProduct(p);
//		filerepository.save(image);
	}

	
	
		/*
	
	@Override
	public List<Product> GetallprodbyidDep(int id) {
		
	
*/
}

