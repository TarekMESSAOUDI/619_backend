
package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

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


import tn.esprit.spring.entity.Category;

import tn.esprit.spring.service.ICategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@CrossOrigin
public class CategoryRestController {
	
	@Autowired
	ICategoryService CS;
	
	//  http://localhost:9090/SpringMVC/servlet/add-category
//		@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
		@PostMapping("/add-category")
		@ResponseBody
		public Category addProduct(@RequestBody Category c) {
		Category cat = CS.addCategory(c);
		return cat;
		}
		
		
		//   http://localhost:9090/SpringMVC/servlet/remove-category/{categorytId}
//		@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
		@DeleteMapping("/remove-category/{categorytId}")
		@ResponseBody
		public void removeCategory(@PathVariable("categorytId") int catId) {
		CS.deleteCategry(catId);
		}
		
		
		
		//  http://localhost:9090/SpringMVC/servlet/update-category
		@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
		@PutMapping("/update-category")
		@ResponseBody
		public Category updateProduct(@RequestBody Category c) {
		return CS.updateCategory(c);
				
		}
		
		
		//http://localhost:9090/SpringMVC/servlet/show-all-categories
		@GetMapping("/show-all-categories")
		@ResponseBody
		public List<Category> getAllProducts(){
			List <Category> list=CS.showAll();
			return list;
		}
		
		//http://localhost:9090/SpringMVC/servlet/affect-undercategory-to-category/{Iduc}/{Idc}
//		@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
		@PutMapping("affect-undercategory-to-category/{Iduc}/{Idc}")
		public void affecterProduitARayon(@PathVariable(value = "Iduc") int Iduc,
				@PathVariable(value = "Idc") int idCategory) {
			CS.affectUnderCategoryToCategory(idCategory, Iduc);
			
		}
		//http://localhost:9090/SpringMVC/servlet/retrieve-by-name/{nameCat}
			@GetMapping("/retrieve-by-name/{nameCat}")
			@ResponseBody
			public List<Category> retrieveByName(@PathVariable(value = "nameCat")String nameCategory){
				List <Category> list=CS.findByName(nameCategory);
				return list;
			}
			
		//  http://localhost:9090/SpringMVC/servlet/retrieve-cat-by-id/{id}
			@GetMapping("/retrieve-cat-by-id/{id}")
			@ResponseBody
			public Category retrieveCatById(@PathVariable(value = "id")int id){
				return CS.findByIdCat(id);
			}
	
}
