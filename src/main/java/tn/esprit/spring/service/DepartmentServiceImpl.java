package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Department;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.entity.VVrayonImage;
import tn.esprit.spring.repository.DepartmentRepository;
import tn.esprit.spring.repository.FileVvRepository;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
DepartmentRepository departmentrepository ;
	
	@Autowired
ProductRepository productrepository;
	
	@Autowired
	FileVvRepository fvr ;
	
	
	private static final Logger L = LogManager.getLogger(DepartmentService.class);
	
	
	@Override
	public List<Department> retrieveAllDepartments() {
		List<Department> departments =(List<Department>) departmentrepository.findAll();
		for (Department dep : departments){
			L.info("dep +++ :" + dep);		
		}
		return departments;
	
		
	}
	
	@Override
	public Department addDepartment(Department D) {
		return departmentrepository.save(D);
	}
	
	
	@Override
	public void deleteDepartment(int idDepartment) {
		departmentrepository.deleteById(idDepartment);
	}

	
	@Override
	public Department DepartmentUpadate(Department dep) {
		
		Department existingDep=departmentrepository.findById(dep.getIdDepartment()).orElse(null);
		
		departmentrepository.findById(dep.getIdDepartment());
		existingDep.setNameDepartment(dep.getNameDepartment());
		existingDep.setTypeDepartment(dep.getTypeDepartment());
		existingDep.setCapacityDepartment(dep.getCapacityDepartment());
		
		return 	departmentrepository.save(existingDep);
	}

	
	
	
	@Override
	public Department retrieveDepartment(int idDepartment) {
		// TODO Auto-generated method stub
		return departmentrepository.findById(idDepartment).get();
	}
	
	
	@Override
	public List<Department> retrievedepartmentByName(String nameDepartment){
		return departmentrepository.findDepByName(nameDepartment);
	}
	
	
	
	
	
////////////////////////////////////////////
@Override
public void allocateProductToDepartment(int idDepartment, int idProduct) {
	List<Product> products=new ArrayList<Product>();
Product product = productrepository.findById(idProduct).get();
Department department = departmentrepository.findById(idDepartment).get();
product.setIdDepartment(department);
products.add(product);
productrepository.save(product);

}


/*
public void deallocateProductFromDepartment(int IdDepartment, int IdProduct) {
	
	Department department = departmentrepository.findById(IdDepartment).get();
	
	int nbp=department.getProduct().size();         //get products
	for(int index = 0; index < nbp; index++){
		
		
		if(department.getProduct().get(index).getId() == IdProduct){
			
			department.getProduct().remove(index);
			
		}
	
}
}

	
*/
	



@Override
public void allocateFilesToDepartment(int idDepartment, int idImage) {
	VVrayonImage Vvimage = fvr.findById(idImage).get();
Department department = departmentrepository.findById(idDepartment).get();
Vvimage.setDepartment(department);
fvr.save(Vvimage);

}

@Override
public List<Product> getProdsByIdDep(int idDepartment) {
	// TODO Auto-generated method stub
	return departmentrepository.Getproductsbyiddep(idDepartment);
}








/*

@Override
public List<Product> getAllProductName() {
	
	return productrepository.findAll();
}
*/


}
