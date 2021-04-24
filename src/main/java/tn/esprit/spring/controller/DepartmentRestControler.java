

	package tn.esprit.spring.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Department;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.service.DepartmentService;


	@RestController
	public class DepartmentRestControler {
		
		
		@Autowired
		DepartmentService departmentService;
		
		@Autowired
		ProductRepository pr ; 
		
		
		
		
		
		// http://localhost:9090/SpringMVC/servlet/retrieve-all-Departments
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
			@PostMapping("/add-department")
			@ResponseBody
			public Department addDepartment(@RequestBody Department D) {
			Department department1 = departmentService.addDepartment(D);
			return department1;
			}
		
		
			// http://localhost:9090/SpringMVC/servlet/remove-department/{department-id}
				@DeleteMapping("/remove-department/{department-id}")
				@ResponseBody
				public void removeDepartment(@PathVariable("department-id") int departmentId) {
				departmentService.deleteDepartment(departmentId);
				}
				
				
				
				
				//http://localhost:9090/SpringMVC/servlet/update-Department
				@PutMapping("/update-Department")
				@ResponseBody
				public Department updateDepartment(@RequestBody Department dep) {
				return departmentService.DepartmentUpadate(dep);
						
				}
			
				
				
				
				
				
				
		// http://localhost:9090/SpringMVC/servlet/alteProductToDepartment/{idd}/{idp}  	
	@PutMapping("/alteProductToDepartment/{iddepartment}/{idproduct}")
	public void AllocateProductToDepartment(@PathVariable(value = "iddepartment") int idDepartment,@PathVariable(value = "idproduct") int idProduct){
					
	departmentService.allocateProductToDepartment(idDepartment, idProduct);
	}		
		
	
	
	
	// http://localhost:9090/SpringMVC/servlet/alteFileToDepartment/{idd}/{idf}  	
@PutMapping("/alteFileToDepartment/{iddepartment}/{idImage}")
public void AllocateFileToDepartment(@PathVariable(value = "iddepartment") int idDepartment,@PathVariable(value = "idImage") int idImage){
				
departmentService.allocateFilesToDepartment(idDepartment, idImage);
}		
	

	
	
	}

	
	
	

