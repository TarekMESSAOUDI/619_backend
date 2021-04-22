
package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.UnderCategory;



public interface IUnderCategory {
public UnderCategory addUndercategory(UnderCategory uc);
public void deleteUnderCategory(int idUnderCategory);
public UnderCategory upadateUndercategory(UnderCategory uc);
public List<UnderCategory> showAllunderCategories();
public void assignProductToUnderCategory(int idUnderCategory,int idProduct);
public UnderCategory findById(int idUnderCategory);

}
