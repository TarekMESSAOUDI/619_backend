
package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.UnderCategory;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.UnderCategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired 
	CategoryRepository CR;
	@Autowired
	UnderCategoryRepository UCR;
	
	@Override
	public Category addCategory(Category c) {
		return CR.save(c);
	}

	@Override
	public void deleteCategry(int idCategory) {
		CR.deleteById(idCategory);
	}

	@Override
	public Category updateCategory(Category c) {
		
		Category existingCat=CR.findById(c.getIdCategory()).orElse(null);
		CR.findById(c.getIdCategory());
		existingCat.setNameCategory(c.getNameCategory());
		return 	CR.save(existingCat);
	
	}

	@Override
	public List<Category> showAll() {
		List<Category> categories =(List<Category>) CR.findAll();
		return categories;
	}

	@Override
	public void affectUnderCategoryToCategory(int idCategory, int idUnderCategory) {
		Category category=CR.findById(idCategory).get();
		UnderCategory undercategory=UCR.findById(idUnderCategory).get();
		
		undercategory.setCategory(category);
		UCR.save(undercategory);
	}

	@Override
	public List<Category> findByName(String nameCategory) {
		return CR.findByNameCategory(nameCategory);
		
	}

	@Override
	public Category findByIdCat(int id) {
		return CR.findByIdCategory(id);
	}

}
