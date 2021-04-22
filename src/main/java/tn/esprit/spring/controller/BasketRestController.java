package tn.esprit.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Basket;
import tn.esprit.spring.repository.IBasketRepository;
import tn.esprit.spring.service.BasketServiceImpl;
import tn.esprit.spring.service.IBasketService;

@RestController
public class BasketRestController {
	
	@Autowired
	IBasketService bs;
	
	@Autowired
	IBasketRepository br;
	
	@Autowired
	BasketServiceImpl bsi;
	
		// http://localhost:9091/SpringMVC/servlet/add-basket
		@PostMapping("/add-basket")
		@ResponseBody
		public Basket addBasket(@RequestBody Basket basket) {
		Basket ba = bs.addBasket(basket);
		return ba;
		}
				
		// http://localhost:9091/SpringMVC/servlet/delet-basket/{idBasket}
		@DeleteMapping("/delet-basket/{idBasket}")
		@ResponseBody
		public boolean deletBasketBasket(@PathVariable int idBasket) {
		return bs.deleteBasket(idBasket);
		}
		
		// http://localhost:9091/SpringMVC/servlet/affect-basket-to-client
		@PostMapping("/affect-basket-to-client/{idbasket}/{iduser}")
		@ResponseBody
		public void affectationBasketToClient(@PathVariable("idbasket")int idBasket,@PathVariable("iduser")int idUser) throws IOException{
		bsi.affectationBasketToClient(idBasket, idUser);
			}
				
		// http://localhost:9091/SpringMVC/servlet/get-moy-AmountBasket
		@GetMapping("/get-moy-AmountBasket")
		@ResponseBody
		public float getmoyAmountBasket(){
		return br.getmoyAmountBasket();
		}
				
		// http://localhost:9091/SpringMVC/servlet/get-total-AmountBasket
		@GetMapping("/get-total-AmountBasket")
		@ResponseBody
		public float gettotalAmountBasket(){
		return br.gettotalAmountBasket();
		}

		// http://localhost:9091/SpringMVC/servlet/get-max-AmountBasket
		@GetMapping("/get-max-AmountBasket")
		@ResponseBody
		public float getmaxAmountBasket(){
		return br.getmaxAmountBasket();
		}		
				
		// http://localhost:9091/SpringMVC/servlet/get-count-Basket
		@GetMapping("/get-count-Basket")
		@ResponseBody
		public float getcountAmountBasket(){
		return br.getcountBasket();
		}	
				
		// http://localhost:9091/SpringMVC/servlet/get-ecart-amountBasket
		@GetMapping("/get-ecart-amountBasket")
		@ResponseBody
		public float getecartamountBasket(){
		return br.getecartamountBasket();
		}			

}
