
package tn.esprit.spring.service;



import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.FileRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.entity.FileDB;
import tn.esprit.spring.entity.Product;



@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired 
	FileRepository filerepository;
	
	
	
	
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
	public Product addProduct(Product p) {
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
	public Product updateProduct(Product p) {
		
		Product existingProduct=productRepository.findById(p.getIdProduct()).orElse(null);
		
		productRepository.findById(p.getIdProduct());
	
		existingProduct.setTitleProduct(p.getTitleProduct());
		existingProduct.setDescriptionProduct(p.getDescriptionProduct());
		existingProduct.setQuantityProduct(p.getQuantityProduct());
		existingProduct.setPriceProduct(p.getPriceProduct());
		existingProduct.setBarcodeProduct(p.getBarcodeProduct());
		existingProduct.setWeightProduct(p.getWeightProduct());
		existingProduct.setBuyingPriceProduct(p.getBuyingPriceProduct());
		existingProduct.setMaxQuantityProduct(p.getMaxQuantityProduct());
	
		return 	productRepository.save(existingProduct);
	
	}


	

	@Override
	public void assignImageToProduct(int idProduct, int idImage) {
		Product product=productRepository.findById(idProduct).get();
		FileDB image=filerepository.findById(idImage).get();
		image.setProduct(product);
		filerepository.save(image);	
		
	}
	
	//Meissa
	
	public List<Product> list(){
        List<Product> list = (List<Product>) productRepository.findAll();
        return list;
    }

    public Optional<Product> getById(int idProduct){
        return productRepository.findById(idProduct);
    }

    public Optional<Product> getByNombre(String nombre){
        return productRepository.findByNombre(nombre);
    }

    public void save(Product Product){
        productRepository.save(Product);
    }

    public void delete(int idProduct){
        productRepository.deleteById(idProduct);
    }

    public boolean existsId(int idProduct){
        return productRepository.existsById(idProduct);
    }

    public boolean existsNombre(String nombre){
        return productRepository.existsByNombre(nombre);
    }

	}

