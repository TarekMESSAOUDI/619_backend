package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Delivery;
//import tn.esprit.spring.repository.DeliveryPersonRepository;
//import tn.esprit.spring.repository.DeliveryRepository;
import tn.esprit.spring.service.IDeliveryService;




@RestController
@CrossOrigin("http://localhost:4200")
public class DeliveryRestControlIer{
	
	
	@Autowired
	IDeliveryService deliveryS;
	
	
	
	
	// http://localhost:9091/SpringMVC/servlet/addDelivery
	//@PreAuthorize("hasAuthority('CLIENT')")
	@PostMapping("/addDelivery")
	@ResponseBody
	public Delivery addDeliveryPerson(@RequestBody Delivery d) {
		deliveryS.addDelivery(d);
	return d;
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrievealldelivery
	//@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DELIVERYPERSON')")
		@GetMapping("/retrievealldelivery")
		@ResponseBody
		public List<Delivery> getDelivery() {
		List<Delivery> list = deliveryS.retreiveAllDelivery();
		return list;
		}
		
		// http://localhost:9091/SpringMVC/servlet/retrievedelivery/{deliveryid}
		//@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DELIVERYPERSON') or hasAuthority('CLIENT')")
		@GetMapping("/retrievedelivery/{Delivery-id}")
		@ResponseBody
		public Optional<Delivery>retrieveDeliveryPerson(@PathVariable("Delivery-id") int idDelivery ) {
		return deliveryS.retreiveDelivery(idDelivery );
		}
		
		
		// http://localhost:9091/SpringMVC/servlet/remove-delivery/{idDelivery}
		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@DeleteMapping("/remove-delivery/{Delivery-id}")
		@ResponseBody
		public void removeDelivery(@PathVariable("Delivery-id") int idDelivery) {
		deliveryS.deleteDelivery(idDelivery);
		}
		
		
		// http://localhost:9091/SpringMVC/servlet/modify-delivery
		//@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DELIVERYPERSON') or hasAuthority('CLIENT')")
		@PutMapping("/modify-delivery")
		@ResponseBody
		public Delivery modifyDelivery(@RequestBody Delivery d) {
		return deliveryS.updateDelivery(d);
	}
		
		//http://localhost:9091/SpringMVC/servlet/desaffect-Delivery-to-DeliveryPerson/{idDeliv}/{idUser}
		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
				@PutMapping("/desaffect-Delivery-to-DeliveryPerson/{idDeliv}/{idUser}")
				public void DesaffecterDelivery(@PathVariable(value = "idDeliv") int idDelivery,
				@PathVariable(value = "idUser") int idUser) {
					deliveryS.DesaffecterDelivery(idDelivery, idUser);
					
					
				}
				 
				
				
				//http://localhost:9091/SpringMVC/servlet/affect-Delivery-to-DeliveryPerson/{idDeliv}/{idUser}
		        //@PreAuthorize("hasAuthority('ADMINISTRATOR')")
				@PutMapping("/affect-Delivery-to-DeliveryPerson/{idDeliv}/{idUser}")
				public void affecterDelivery(@PathVariable(value = "idDeliv") int idDelivery,
				@PathVariable(value = "idUser") int idUser) {
				deliveryS.affecterDelivery(idDelivery, idUser);
					
					
				}
				
				
				
				
				@GetMapping(value="/calculCosts/{poids}/{kilo}")
				//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
				public int calculCosts(@PathVariable("poids")float poids,@PathVariable("kilo")int kilo){
					return deliveryS.calculCosts( kilo);
				}
				
					
		}
		
		