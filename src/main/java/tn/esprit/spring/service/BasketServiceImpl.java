package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Basket;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IBasketRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class BasketServiceImpl implements IBasketService{
	
	@Autowired
	IBasketRepository br;
	
	@Autowired
	IUserRepository ur;
	
	@Autowired
	ProductRepository pr;

	@Override
	public void affectationBasketToClient(int idBasket, int idUser) {
		Basket basket=br.findById(idBasket).get();
		User user=ur.findById(idUser).get();
		user.setBasket(basket);
		ur.save(user);
	}

	@Override
	public Basket addBasket(Basket basket) {
		return br.save(basket);
	}

	@Override
	public boolean deleteBasket(int id) {
		if (br.existsById(id)){
			br.deleteById(id);
			return true;
		}else
		return false;
	}

	@Override
	public void addProductTosBasket(int idbasket,int idProduct) {
		List<Product> products=new ArrayList<Product>();
		Basket basket=br.findById(idbasket).get();
		Product product=pr.findById(idProduct).get();
		product.setBasket(basket);
		products.add(product);
		br.save(basket);
		
	}
	
	

}
