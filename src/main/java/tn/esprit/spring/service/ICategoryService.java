
package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Category;

public interface ICategoryService {

	
	public Category addCategory(Category c);
	public void deleteCategry(int idCategory);
	public Category updateCategory(Category c);
	public List<Category> showAll();
	public void affectUnderCategoryToCategory(int idCategory,int idUnderCategory );
	public List<Category> findByName(String nameCategory);
	public Category findByIdCat(int id);
}	

