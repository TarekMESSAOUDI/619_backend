package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Department;
import tn.esprit.spring.entity.Product;

public interface DepartmentService {

	

	Department addDepartment(Department D);

	void deleteDepartment(int idDepartment);

	Department DepartmentUpadate(Department dep);

	Department retrieveDepartment(int idDepartment);

	List<Department> retrieveAllDepartments();

	

	

	

	void allocateProductToDepartment(int idDepartment, int idProduct);

	void allocateFilesToDepartment(int idDepartment, int idImage);

	List<Department> retrievedepartmentByName(String nameDepartment);

	







	

}
