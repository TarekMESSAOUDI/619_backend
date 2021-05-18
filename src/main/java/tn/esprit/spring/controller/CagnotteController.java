package tn.esprit.spring.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.entity.Cagnotte;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.UnderCategory;
import tn.esprit.spring.repository.CagnotteRepository;
import tn.esprit.spring.response.Response;
import tn.esprit.spring.service.ICagnotteService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CagnotteController {
	
	@Autowired
	private ICagnotteService cagnotteService;
	
	@Autowired
	CagnotteRepository cr;
	@Autowired
	ServletContext context;
	
	// http://localhost:9091/SpringMVC/servlet/add-cagnotte

		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")



		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")


		@PostMapping("/add-cagnotte")
		@ResponseBody
		public Cagnotte addCagnotte(@RequestBody Cagnotte c) {
		Cagnotte cagnotte = cagnotteService.addCagnotte(c);
		return cagnotte;
		}
	
	// URL : http://localhost:9091/SpringMVC/servlet/getAllCagnotte

		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")


	    
	  
		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")

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
			 
//			// http://localhost:9090/SpringMVC/servlet/Imgarticles/{id}
//				@GetMapping(path="/Imgarticles/{id}")
//				 public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
//					 Cagnotte cagnotte  = cr.findById(id).get();
//					 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+cagnotte.getFileName()));
//				 }
//				
//				@PostMapping("/Productss")
//				 public ResponseEntity<Response> createProduct (@RequestParam("file") MultipartFile file,int id,
//						 @RequestParam("article") String cagnotte) throws JsonParseException , JsonMappingException , Exception
//				 {
//					 System.out.println("Ok .............");
//			        Cagnotte cagnotte = new ObjectMapper().readValues(cagnotte, Cagnotte.class);
//			       
//			        
//			        
//			        boolean isExit = new File(context.getRealPath("/Images/")).exists();
//			        if (!isExit)
//			        {
//			        	new File (context.getRealPath("/Images/")).mkdir();
//			        	System.out.println("mk dir.............");
//			        }
//			        String filename = file.getOriginalFilename();
//			        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
//			        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
//			        try
//			        {
//			        	System.out.println("Image");
//			        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
//			        	 
//			        }catch(Exception e) {
//			        	e.printStackTrace();
//			        }
//
//			       
//			        cagnotte.setName(newFileName);
//			        Cagnotte art = cr.save(cagnotte);
//			        if (art != null)
//			        {
//			        	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
//			        }
//			        else
//			        {
//			        	return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);	
//			        }
//				 }
//			 
			 
}

