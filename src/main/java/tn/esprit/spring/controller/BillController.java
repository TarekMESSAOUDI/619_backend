package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.entity.PaymentType;
import tn.esprit.spring.service.IBillService;
@RestController
public class BillController {
	
	@Autowired
	private IBillService billService;
	
	// http://localhost:9091/SpringMVC/servlet/add-bill
		@PostMapping("/add-bill")
		@ResponseBody
		public Bill addBill(@RequestBody Bill b) {
		Bill bill = billService.addBill(b);
		return bill;
		}
	
	// URL : http://localhost:9091/SpringMVC/servlet/getAllBill
	    @GetMapping(value = "getAllBill")
	  
	    public List<Bill> getAllBill(){
		return billService.getAllBill();
		}
	    
	 // URL : http://localhost:9091/SpringMVC/servlet/delete-bill
		   @DeleteMapping(value = "delete-bill/{idBill}")
		   
			public void deleteBill(@PathVariable("idBill")Long idBill){
			   billService.deleteBill(idBill);
		   }
		   
		// http://localhost:9091/SpringMVC/servlet/modify-bill
			@PutMapping("/modify-bill")
			@ResponseBody
			public Bill modifyBill(@RequestBody Bill bill) {
			return billService.updateBill(bill);
			}
			
		// URL : http://localhost:9091/SpringMVC/servlet/getBill_by_ID/8
			 @GetMapping(value = "getBill_by_ID/{idBill}")
			   
			 public Optional<Bill> getBill_by_ID(@PathVariable("idBill")Long idBill) {
					return billService.getBill_by_ID(idBill);
			}
			 
		// URL : http://localhost:9091/SpringMVC/servlet/getBill_by_Type/At_Delivery
			 @GetMapping(value = "getBill_by_Type/{paymentType}")
			   
			 public List<Bill> getBill_by_Type(@PathVariable("paymentType")PaymentType paymentType) {
					return billService.getBill_by_Type(paymentType);
			}
			 
			 
			// URL : http://localhost:9091/SpringMVC/servlet/getAllBill_by_Order/1
			 @GetMapping(value = "getAllBill_by_Order/{idOrder}")
			   
			 public List<Bill> getAllBill_by_Order(@PathVariable("idOrder")Long idOrder) {
					return billService.getAllBill_by_Order(idOrder);
			}
			 
			 
			 
			// URL : http://localhost:9091/SpringMVC/servlet/modify_type_bill
			   @PutMapping(value = "modify_type_bill/{idBill}/{paymentType}")
			   @ResponseBody
				public void modify_type_bill(@PathVariable("paymentType")PaymentType paymentType,@PathVariable("idBill")Long idBill){
				   billService.modify_type_bill(paymentType, idBill);
					 
				}
			   
			// URL : http://localhost:9091/SpringMVC/servlet/get_payment_type_by_idBill

			   @GetMapping(value = "get_payment_type_by_idBill/{idBill}")
			  

			   public String  get_payment_type_by_idBill(@PathVariable("idBill")Long idBill) {
				 return  billService.get_payment_type_by_idBill(idBill);
				   
			   }
			 
			// URL : http://localhost:9091/SpringMVC/servlet//showPDF/{idBill}
			   @GetMapping("/showPDF/{idBill}")
			   public void billpdf (@PathVariable("idBill") Long idBill) {
				   
				 billService.billpdf(idBill);
			   
			   }
	
	
	

}
