
package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.UnderCategory;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.UnderCategoryRepository;


@Service
public class UnderCategoryImpl implements IUnderCategory {

	@Autowired
	UnderCategoryRepository UCR;
	@Autowired
	ProductRepository PR;
	@Autowired
	CategoryRepository cr;
	
	
	@Override
	public UnderCategory addUndercategory(UnderCategory uc,int idcategory) {
		Category cat=cr.findByIdCategory(idcategory);
		uc.setCategory(cat);
		 UCR.save(uc);
		 return uc;
	}

	@Override
	public void deleteUnderCategory(int idUnderCategory) {
		UCR.deleteById(idUnderCategory);
		
	}

	@Override
	public UnderCategory upadateUndercategory(UnderCategory uc) {
		UnderCategory existingunderCat=UCR.findById(uc.getIdUnderCategory()).orElse(null);
		UCR.findById(uc.getIdUnderCategory());
		existingunderCat.setNameUnderCategory(uc.getNameUnderCategory());
		return 	UCR.save(existingunderCat);
	}

	@Override
	public List<UnderCategory> showAllunderCategories() {
		
			List<UnderCategory> underCategories =(List<UnderCategory>) UCR.findAll();
			return underCategories;
	}

	@Override
	public void assignProductToUnderCategory(int idUnderCategory, int idProduct) {
		UnderCategory undercategory=UCR.findById(idUnderCategory).get();
		Product product=PR.findById(idProduct).get();
		
		product.setUnderCategory(undercategory);
		PR.save(product);
	}

	@Override
	public UnderCategory findById(int idUnderCategory) {
		
		return  UCR.findById(idUnderCategory).get();
	}

	@Override
	public List<Product> getByIdUnder(int idUnderCat) {
		return UCR.GetproductsbyidUnderCat(idUnderCat);
	}

}
