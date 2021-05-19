
package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.UnderCategory;
import tn.esprit.spring.repository.UnderCategoryRepository;
import tn.esprit.spring.service.IUnderCategory;
import tn.esprit.spring.service.UnderCategoryImpl;
@CrossOrigin
@RestController
public class UnderCategoryRestController {

	@Autowired
	IUnderCategory IuC;
	@Autowired
	UnderCategoryRepository ucr;
	@Autowired
	UnderCategoryImpl uci;

	
	//http://localhost:9090/SpringMVC/servlet/add-under-category
//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
		@PostMapping("/add-underCategory/{CategoryId}")
		@ResponseBody
		public UnderCategory addUndercategory(@RequestBody UnderCategory uc,@PathVariable("CategoryId") int CategorytId) {
		UnderCategory ucat = IuC.addUndercategory(uc,CategorytId);
		return ucat;
		}
		
		
		//http://localhost:9090/SpringMVC/servlet/remove-under-category/{underCategorytId}
//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
		@DeleteMapping("/remove-under-category/{underCategorytId}")
		@ResponseBody
		public void removeUnderCategory(@PathVariable("underCategorytId") int ucId) {
		IuC.deleteUnderCategory(ucId);
		}
		
		
		
		//http://localhost:9090/SpringMVC/servlet/update-under-category
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
		@PutMapping("/update-under-category")
		@ResponseBody
		public UnderCategory updateUnderCategory(@RequestBody UnderCategory uc) {
		return IuC.upadateUndercategory(uc);
				
		}
		
		
		//http://localhost:9090/SpringMVC/servlet/show-all-under-categories
		@GetMapping("/show-all-under-categories")
		@ResponseBody
		public List<UnderCategory> getAllUndercategories(){
			List <UnderCategory> list=IuC.showAllunderCategories();
			return list;
		}
		//http://localhost:9091/SpringMVC/servlet/affect-product-to-under-category/{Idp}/{Iduc}
//		@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
		@PutMapping("/affect-product-to-under-category/{Idp}/{Iduc}")
		public void affecterProduitARayon(@PathVariable(value = "Idp") int idProduct,
				@PathVariable(value = "Iduc") int idUnderCategory) {
			IuC.assignProductToUnderCategory(idUnderCategory, idProduct);
			
		}
		

		//http://localhost:9090/SpringMVC/servlet/GetByIdUnderCat/{underCategorytId}
		@GetMapping("/GetByIdUnderCat/{underCategorytId}")
		@ResponseBody
		public UnderCategory getById(@PathVariable("underCategorytId")int id){
			return IuC.findById(id);
		}
		
		@GetMapping("/underCatProds/{idUnderCat}")
		 public List<Product> getProdsByIdUnderCat(@PathVariable("idUnderCat") int iddUnderCat){
				
				return  IuC.getByIdUnder(iddUnderCat);

		 
		 
		 }		 
	
	
	
}
