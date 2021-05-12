
 package tn.esprit.spring.controller;
import tn.esprit.spring.service.FileStrorageService;
import tn.esprit.spring.service.IProductService;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import ch.qos.logback.core.Context;
import io.netty.handler.ipfilter.IpSubnetFilter;
import tn.esprit.spring.ResourceNotFoundException.ResourceNotFoundException;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.UnderCategory;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.UnderCategoryRepository;
import tn.esprit.spring.response.Response;


@CrossOrigin
@RestController



@CrossOrigin

public class ProductControl {
	@Autowired
	FileStrorageService FSS;
	@Autowired
	IProductService productService;
	@Autowired IProductService IPS;
	@Autowired
	ProductRepository PR;
	@Autowired
	ServletContext context;
	@Autowired
	UnderCategoryRepository ucr;
  
  
  @Autowired
	ProductRepository pr;
	
	//http://localhost:9090/SpringMVC/servlet/show-all-products
	@GetMapping("/show-all-products")
	@ResponseBody
	public List<Product> getAllProducts(){
		List <Product> list=productService.showAll();
		return list;
	}
	
	//http://localhost:9090/SpringMVC/servlet/GetByOneName/{productName}
	@GetMapping("/GetByOneName/{productName}")
	@ResponseBody 
	public Product RetrieveByName(@PathVariable("productName")String nameProd){
		return productService.GetByName(nameProd);
	}
	
	
	//http://localhost:9090/SpringMVC/servlet/GetById/{productId}
	@GetMapping("GetById/{productId}")
	@ResponseBody 
	public Product RetrieveById(@PathVariable("productId")int id){
		return productService.GetById(id);
	}
	
	
	//http://localhost:9090/SpringMVC/servlet/ShowAllByName/{productName}
	@GetMapping("ShowAllByName/{productName}")
	@ResponseBody 
	public List<Product> RetrieveAllByName(@PathVariable("productName")String name){
		return productService.GetAllByName(name);
	}
	

	
	
	//http://localhost:9090/SpringMVC/servlet/add-product

	//@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
	@PostMapping("/add-product")


//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
	@PostMapping("/add-product/{iduc}/{idDep}")

	@ResponseBody
	public Product addProduct(@RequestBody Product p,@PathVariable("iduc")int iduc,@PathVariable("idDep")int idDep) {
	Product prod = productService.addProduct(p,iduc,idDep);
	return prod;
	}
	
	
	
	//http://localhost:9090/SpringMVC/servlet/remove-product/{productId}
//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
	@DeleteMapping("/remove-product/{productId}")
	@ResponseBody
	public void removeProduct(@PathVariable("productId") int id) {
	productService.deleteProduct(id);
	}
	
	

	

	//http://localhost:9090/SpringMVC/servlet/update-Product

//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")

	@PutMapping("/update-Product/{id}")
  @PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
	@ResponseBody
	public Product updateProduct(@PathVariable(value = "id") int id,@RequestBody Product p) {
	return productService.updateProduct(id, p);  
			
	}
	
	//http://localhost:9090/SpringMVC/servlet/affect-image-to-product/{Idp}/{Idimage}
//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
			@PutMapping("/affect-image-to-product/{Idp}/{Idimage}")
			public void affecterProduitARayon(@PathVariable(value = "Idp") int Idp,
					@PathVariable(value = "Idimage") int Idimage) {
				 IPS.assignImageToProduct(Idp, Idimage);
				
			}
  
  //http://localhost:9090/SpringMVC/servlet/gain-product
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/gain-product")
	@ResponseBody
	public List<String> getgainproduct() {
	return pr.getgainproduct();
			
	}
	
	//http://localhost:9090/SpringMVC/servlet/total-gain-product
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/total-gain-product")
		@ResponseBody
		public float gettotalgainproduct() {
		return pr.gettotalgainproduct();
		}
		
		//http://localhost:9090/SpringMVC/servlet/total-achat
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/total-achat")
		@ResponseBody
		public float getallcostproduct() {
		return pr.getallcostproduct();
		}
		
		//http://localhost:9090/SpringMVC/servlet/total-vente
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/total-vente")
		@ResponseBody
		public float getallbuyproduct() {
		return pr.getallbuyproduct();
		}
		
		
		//http://localhost:9090/SpringMVC/servlet/Most-Expensive
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/Most-Expensive")
		@ResponseBody
		public float MostExpensiveProduct() {
			return pr.MostExpensiveProduct();
			}
		
//		//http://localhost:9090/SpringMVC/servlet/getproduct-by/{idUnderCategory}/{titleProduct}
//		@PutMapping("/getproduct-by/{idUnderCategory}/{titleProduct}")
//		@ResponseBody
//		public List<Product> GetproductByidUcandTitle(@PathVariable("idUnderCategory")int  idUnderCategory,@PathVariable("titleProduct")String titleProduct) {
//		return pr.GetproductByidUcandTitle(idUnderCategory, titleProduct);
//				
//		}

	
	

    
    
	

		
		@GetMapping("/GETALLPRODUCTS")
		public List<Product> getAllProds(){
			System.out.println("Get All Products ...");
			List<Product>products=new ArrayList<>();
			PR.findAll().forEach(products :: add);
			return products;
		}
		
		
		@GetMapping("/GETALLS")
		public ResponseEntity<List<String>> getALL(){
			 List<String> listArt = new ArrayList<String>();
			String filesPath= context.getRealPath("/Images");
					File filefolder=new File(filesPath);
					if (filefolder != null)
					{
						for (File file :filefolder.listFiles())
						{
							if(!file.isDirectory())
							{
							  String encodeBase64 = null;
							  try { String extension = FilenameUtils.getExtension(file.getName());
							  FileInputStream fileInputStream = new FileInputStream(file);
						     
							  byte[] bytes = new byte[(int)file.length()];
						      fileInputStream.read(bytes);
						      encodeBase64 = Base64.getEncoder().encodeToString(bytes);
						      listArt.add("data:image/"+extension+";base64,"+encodeBase64);
						      fileInputStream.close();
						      
						      
						  }catch (Exception e){
							  
						  }
						}
					}
				 }
					return new ResponseEntity<List<String>>(listArt,HttpStatus.OK);
		}
		
		// http://localhost:9090/SpringMVC/servlet/Imgarticles/{id}
		@GetMapping(path="/Imgarticles/{id}")
		 public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
			 Product prod  = pr.findById(id).get();
			 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+prod.getFileName()));
		 }
		// http://localhost:9091/SpringMVC/servlet/prod/{id}
		@GetMapping("/prod/{id}")
		public ResponseEntity<Product> getArticleById(@PathVariable(value = "id") int Id)
				throws ResourceNotFoundException {
			Product prod = pr.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + Id));
			return ResponseEntity.ok().body(prod);
		}
		
		
		
		 @PostMapping("/Productss")
		 public ResponseEntity<Response> createProduct (@RequestParam("file") MultipartFile file,int id,
				 @RequestParam("article") String product) throws JsonParseException , JsonMappingException , Exception
		 {
			 System.out.println("Ok .............");
	        Product prod = new ObjectMapper().readValue(product, Product.class);
	        UnderCategory uc=ucr.findById(id).get();
	        prod.setUnderCategory(uc);
	        
	        boolean isExit = new File(context.getRealPath("/Images/")).exists();
	        if (!isExit)
	        {
	        	new File (context.getRealPath("/Images/")).mkdir();
	        	System.out.println("mk dir.............");
	        }
	        String filename = file.getOriginalFilename();
	        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
	        try
	        {
	        	System.out.println("Image");
	        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
	        	 
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }

	       
	        prod.setFileName(newFileName);
	        Product art = pr.save(prod);
	        if (art != null)
	        {
	        	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
	        }
	        else
	        {
	        	return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);	
	        }
		 }
		 
		 
		 @DeleteMapping("/products/{id}")
			public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") int prodId)
					throws ResourceNotFoundException {
				Product product = pr.findById(prodId)
						.orElseThrow(() -> new ResourceNotFoundException("Article not found  id :: " + prodId));
				pr.delete(product);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
			}
		 
		 

}
