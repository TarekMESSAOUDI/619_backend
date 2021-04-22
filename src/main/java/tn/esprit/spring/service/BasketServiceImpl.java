package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Basket;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IBasketRepository;
import tn.esprit.spring.repository.IUserRepository;

@Service
public class BasketServiceImpl implements IBasketService{
	
	@Autowired
	IBasketRepository br;
	
	@Autowired
	IUserRepository ur;

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
	
	

}
