package tn.esprit.spring.service;

import tn.esprit.spring.entity.Basket;

public interface IBasketService {
	
	void affectationBasketToClient(int idBasket, int idUser);

	Basket addBasket(Basket basket);

	boolean deleteBasket(int id);
	
	void addProductTosBasket(int idbasket,int idProduct);
	
	

}
