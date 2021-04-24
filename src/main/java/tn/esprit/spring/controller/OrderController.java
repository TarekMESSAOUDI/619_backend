package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Order;
import tn.esprit.spring.entity.PaymentType;
import tn.esprit.spring.service.IOrderService;



@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	// http://localhost:9091/SpringMVC/servlet/add-order
	@PreAuthorize("hasAuthority('CLIENT')")
	@PostMapping("/add-order")
	@ResponseBody
	public Order addOrder(@RequestBody Order o) {
	Order order = orderService.addOrder(o);
	return order;
	}
	
	// http://localhost:9091/SpringMVC/servlet/modify-order
	@PreAuthorize("hasAuthority('CLIENT')")
				@PutMapping("/modify-order")
				@ResponseBody
				public Order updateOrder(@RequestBody Order o) {
				return orderService.updateOrder(o);
				}
	
	// URL : http://localhost:9091/SpringMVC/servlet/delete-order
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
				 @DeleteMapping(value = "delete-order/{idOrder}")
				   
				public void deleteOrder(@PathVariable("idOrder")Long idOrder){
					   orderService.deleteOrder(idOrder);
				   }
				 
	// URL : http://localhost:9091/SpringMVC/servlet/getAllOrder
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
				@GetMapping(value = "getAllOrder")
				  
				public List<Order> getAllOrder(){
				return orderService.getAllOrder();
					}
				
				
	// URL : http://localhost:9091/SpringMVC/servlet/getOrder_by_Type/At_Delivery
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
				 @GetMapping(value = "getOrder_by_Type/{paymentType}")
				   
				 public List<Order> getOrder_by_Type(@PathVariable("paymentType")PaymentType paymentType) {
						return orderService.getOrder_by_Type(paymentType);
				}
				 
	// URL : http://localhost:9091/SpringMVC/servlet/pay_By_Card
	@PreAuthorize("hasAuthority('CLIENT')")
				 @PutMapping("/pay_By_Card/{idOrder}")
				
				 public void Pay_By_Card(@PathVariable(value = "idOrder") Long idOrder) {
						orderService.Pay_By_Card(idOrder);
				 }
				
	// URL : http://localhost:9091/SpringMVC/servlet/pay_At_Delivery
	@PreAuthorize("hasAuthority('CLIENT')")
				 @PutMapping("/pay_At_Delivery/{idOrder}")
				
				 public void Pay_At_Delivery(@PathVariable(value = "idOrder") Long idOrder) {
						orderService.Pay_At_Delivery(idOrder);
				 }
	
	// URL : http://localhost:9091/SpringMVC/servlet/getAllOrder_by_Client/1
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
					@GetMapping(value = "getAllOrder_by_Client/{idUser}")
								   
					public List<Order> getAllOrder_by_Client(@PathVariable("idUser")int idUser) {
							return orderService.getAllOrder_by_Client(idUser);
								}

}
