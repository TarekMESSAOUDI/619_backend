package tn.esprit.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.access.prepost.PreAuthorize;
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

@CrossOrigin
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
		@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@DeleteMapping("/delet-basket/{idBasket}")
		@ResponseBody
		public boolean deletBasketBasket(@PathVariable int idBasket) {
		return bs.deleteBasket(idBasket);
		}
		
		// http://localhost:9091/SpringMVC/servlet/affect-basket-to-user
		@PostMapping("/affect-basket-to-user/{idbasket}/{iduser}")
		@ResponseBody
		public void affectationBasketToClient(@PathVariable("idbasket")int idBasket,@PathVariable("iduser")int idUser) throws IOException{
		bsi.affectationBasketToClient(idBasket, idUser);
			}
				
		// http://localhost:9091/SpringMVC/servlet/get-moy-AmountBasket
		@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/get-moy-AmountBasket")
		@ResponseBody
		public float getmoyAmountBasket(){
		return br.getmoyAmountBasket();
		}
				
		// http://localhost:9091/SpringMVC/servlet/get-total-AmountBasket
		@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/get-total-AmountBasket")
		@ResponseBody
		public float gettotalAmountBasket(){
		return br.gettotalAmountBasket();
		}

		// http://localhost:9091/SpringMVC/servlet/get-max-AmountBasket
		@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/get-max-AmountBasket")
		@ResponseBody
		public float getmaxAmountBasket(){
		return br.getmaxAmountBasket();
		}		
				
		// http://localhost:9091/SpringMVC/servlet/get-count-Basket
		@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/get-count-Basket")
		@ResponseBody
		public float getcountAmountBasket(){
		return br.getcountBasket();
		}	
				
		// http://localhost:9091/SpringMVC/servlet/get-ecart-amountBasket
		@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping("/get-ecart-amountBasket")
		@ResponseBody
		public float getecartamountBasket(){
		return br.getecartamountBasket();
		}	
		
		
		//http://localhost:9091/SpringMVC/servlet/AffectProdToBasket
		@PostMapping("/AffectProdToBasket/{idBasket}/{idProd}")
		public void AffectProdToBasket(@PathVariable("idBasket")int idBasket,@PathVariable("idProd")int idProd) throws IOException{
			bs.addProductTosBasket(idBasket, idProd);
				}

}
