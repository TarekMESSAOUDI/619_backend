
package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entity.Category;;
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	public List<Category> findByNameCategory(String nameCat);
	public Category findByIdCategory(int id);

}
