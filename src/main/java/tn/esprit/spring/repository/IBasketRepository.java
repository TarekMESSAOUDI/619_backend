package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Basket;

@Repository
public interface IBasketRepository extends CrudRepository<Basket, Integer>{
	
	@Query("SELECT AVG(b.amountBasket) FROM Basket b")
	public float getmoyAmountBasket();

	@Query("SELECT AVG(b.amountBasket)*COUNT(b.idBasket) FROM Basket b")
	public float gettotalAmountBasket();
	
	@Query("SELECT MAX(b.amountBasket) FROM Basket b")
	public float getmaxAmountBasket();
	
	@Query("SELECT COUNT(b.amountBasket) FROM Basket b")
	public float getcountBasket();
	
	@Query("SELECT STDDEV(b.amountBasket) FROM Basket b")
	public float getecartamountBasket();

}
