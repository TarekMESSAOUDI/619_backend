

	package tn.esprit.spring.controller;

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

import tn.esprit.spring.ResourceNotFoundException.ResourceNotFoundException;
import tn.esprit.spring.entity.Department;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.DepartmentRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.response.Response;
import tn.esprit.spring.service.DepartmentService;


	@RestController
	@CrossOrigin ("http://localhost:4200")
	public class DepartmentRestControler {
		
		
		@Autowired
		DepartmentService departmentService;
		
		@Autowired
		ProductRepository pr ; 
		
		@Autowired
		ServletContext context;
		
		@Autowired
		DepartmentRepository dr;
		
		
		
		
		
		// http://localhost:9090/SpringMVC/servlet/retrieve-all-Departments)
		@GetMapping("/retrieve-all-Departments")
		@ResponseBody
		public List<Department> getDepartments() {
		List<Department> list = departmentService.retrieveAllDepartments();
		return list;
		}

		//http://localhost:9090/SpringMVC/servlet/retrieve-department/{department-id}
			@GetMapping("/retrieve-department/{department-id}")
			@ResponseBody
			public Department retrieveDepartment(@PathVariable("department-id") int departmentId) {
			return departmentService.retrieveDepartment(departmentId);
			}
			
			
			
			// http://localhost:9090/SpringMVC/servlet/add-department
			//@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
			@PostMapping("/add-department")
			@ResponseBody
			public Department addDepartment(@RequestBody Department D) {
			Department department1 = departmentService.addDepartment(D);
			return department1;
			}
		
		
			// http://localhost:9090/SpringMVC/servlet/remove-department/{department-id}
			//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
				@DeleteMapping("/remove-department/{department-id}")
				@ResponseBody
				public void removeDepartment(@PathVariable("department-id") int departmentId) {
				departmentService.deleteDepartment(departmentId);
				}
				
				
				
				
				//http://localhost:9090/SpringMVC/servlet/update-Department
			@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
				@PutMapping("/update-Department")
				@ResponseBody
				public Department updateDepartment(@RequestBody Department dep) {
				return departmentService.DepartmentUpadate(dep);
						
				}
			
				
				
				
				
				
				
		// http://localhost:9090/SpringMVC/servlet/alteProductToDepartment/{idd}/{idp} 
			//@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
	@PutMapping("/alteProductToDepartment/{iddepartment}/{idproduct}")
	public void AllocateProductToDepartment(@PathVariable(value = "iddepartment") int idDepartment,@PathVariable(value = "idproduct") int idProduct){
					
	departmentService.allocateProductToDepartment(idDepartment, idProduct);
	}		
		
	
	
	
	// http://localhost:9090/SpringMVC/servlet/alteFileToDepartment/{idd}/{idf}  	
			@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
@PutMapping("/alteFileToDepartment/{iddepartment}/{idImage}")
public void AllocateFileToDepartment(@PathVariable(value = "iddepartment") int idDepartment,@PathVariable(value = "idImage") int idImage){
				
departmentService.allocateFilesToDepartment(idDepartment, idImage);
}		
	

	
			// http://localhost:9091/SpringMVC/servlet/retrieve-Department-By-Name/{Department-nameDepartment}
			//@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER') ")
								@GetMapping("/retrieve-Department-By-Name/{Department-nameDepartment}")
								@ResponseBody
								public List<Department> retrieveDepByName(@PathVariable("Department-nameDepartment") String nameDepartment) {
								return departmentService.retrievedepartmentByName(nameDepartment);
								}
			
			
			
			
			
			
			
			/*
			// http://localhost:9091/SpringMVC/servlet/findproductbyDepartment/{idDep}
			@GetMapping("/findproductbyDepartment")
			@ResponseBody
			public List<Product> findProductinDep(@PathVariable("idDep") int idDepartment) {
				return pr.findByIdDepartment(idDepartment);
			}
			
			*/
			/*
								// http://localhost:9091/SpringMVC/servlet/findproduitparrayon/{idr}		
								@GetMapping("/findproduitparrayon/{idr}")
								@ResponseBody
								public List<Product> findProduitNameParRayon(@PathVariable(value = "idr") int Idrayon) {
									return departmentService.findProdcutInDepartment(Idrayon);
								}
			
			*/
			
			
			
			
			
			
			
			
			@GetMapping("/GETALLDEPARTMENTS")
			public List<Department> getAlldepartments(){
				System.out.println("Get All deps ...");
				List<Department>departments=new ArrayList<>();
				dr.findAll().forEach(departments :: add);
				return departments;
			}
			
			
			
			@GetMapping("/GETALLdep")
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
			@GetMapping(path="/department/{id}")
			 public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
				 Department prod  = dr.findById(id).get();
				 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+prod.getFileName()));
			 }
			
			
			// http://localhost:9091/SpringMVC/servlet/depart/{id}
			@GetMapping("/depart/{id}")
			public ResponseEntity<Department> getdepById(@PathVariable(value = "id") int Id)
					throws ResourceNotFoundException {
				Department prod = dr.findById(Id)
						.orElseThrow(() -> new ResourceNotFoundException("dep not found for this id :: " + Id));
				return ResponseEntity.ok().body(prod);
			}
			
			
			// http://localhost:9091/SpringMVC/servlet/Depatmentss
			 @PostMapping("/Departmentss")
			 public ResponseEntity<Response> createDepartment (@RequestParam("file") MultipartFile file,
					 @RequestParam("departm") String department) throws JsonParseException , JsonMappingException , Exception
			 {
				 System.out.println("Ok .............");
		        Department prod = new ObjectMapper().readValue(department, Department.class);
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
		        Department art = dr.save(prod);
		        if (art != null)
		        {
		        	return new ResponseEntity<Response>(new Response ("Added With Image Succuess <3"),HttpStatus.OK);
		        }
		        else
		        {
		        	return new ResponseEntity<Response>(new Response ("Department not saved"),HttpStatus.BAD_REQUEST);	
		        }
			 }
			 
			 
			 @DeleteMapping("/department/{id}")
				public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") int prodId)
						throws ResourceNotFoundException {
					Department department = dr.findById(prodId)
							.orElseThrow(() -> new ResourceNotFoundException("Department not found  id :: " + prodId));
					dr.delete(department);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return response;
				}
			
			
			
			
			
			 
			 
			 
			 
			 
			 
			 
			 
			// http://localhost:9091/SpringMVC/servlet/Getprodbydep?id={value}

				@GetMapping("/Getprodbydep")
				public List<Product> getProdsByIdDep(@RequestParam int id){
					
					return departmentService.getProdsByIdDep(id);
					
				}
				
			
	}
	
	
	
	
	
	/*         
	 
	 // http://localhost:9091/SpringMVC/servlet/Getprodbydep/{idDepartment}

	@GetMapping("/Getprodbydep/{idDepartment}")
	public List<Product> getProdsByIdDep(@PathVariable("idDepartment") int idDepartment){
		
		return departmentService.getProdsByIdDep(idDepartment);
		
	}

	 */
	
	
	
	
	

