package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

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

import tn.esprit.spring.entity.Cagnotte;
import tn.esprit.spring.service.ICagnotteService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CagnotteController {
	
	@Autowired
	private ICagnotteService cagnotteService;
	
	// http://localhost:9091/SpringMVC/servlet/add-cagnotte

		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")



		@PreAuthorize("hasAuthority('ADMINISTRATOR')")


		@PostMapping("/add-cagnotte")
		@ResponseBody
		public Cagnotte addCagnotte(@RequestBody Cagnotte c) {
		Cagnotte cagnotte = cagnotteService.addCagnotte(c);
		return cagnotte;
		}
	
	// URL : http://localhost:9091/SpringMVC/servlet/getAllCagnotte

		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")


	    
	  
		@PreAuthorize("hasAuthority('ADMINISTRATOR')")

		@GetMapping(value = "getAllCagnotte")

	    public List<Cagnotte> getAllCagnotte(){
		return cagnotteService.getAllCagnotte();
		}
	    
	 // URL : http://localhost:9091/SpringMVC/servlet/delete-cagnotte
		   @DeleteMapping(value = "delete-cagnotte/{idCagnotte}")

		   //@PreAuthorize("hasAuthority('ADMINISTRATOR')")


		   @PreAuthorize("hasAuthority('ADMINISTRATOR')")

			public void deleteCagnotte(@PathVariable("idCagnotte")int idCagnotte){
			   cagnotteService.deleteCagnotte(idCagnotte);
		   }
		   
		// http://localhost:9091/SpringMVC/servlet/modify-cagnotte
			@PutMapping("/modify-cagnotte")


			@PreAuthorize("hasAuthority('ADMINISTRATOR')")

			@ResponseBody
			public Cagnotte modifyCagnotte(@RequestBody Cagnotte cagnotte) {
			return cagnotteService.updateCagnotte(cagnotte);
			}
			
		// URL : http://localhost:9091/SpringMVC/servlet/getCagnotte_by_ID
			 @GetMapping(value = "getCagnotte_by_ID/{idCagnotte}")

			   

			 @PreAuthorize("hasAuthority('ADMINISTRATOR')")  

			 public Optional<Cagnotte> getCagnotte_by_ID(@PathVariable("idCagnotte")int idCagnotte) {
					return cagnotteService.getCagnotte_by_ID(idCagnotte);
			}

}

