package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Department;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.entities.TypeStock;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.StockService;

@RestController
public class StockRestControler {
	
	
	@Autowired
	StockService stockService;
	
	@Autowired
	StockRepository sr;
	
	
	
	// http://localhost:9090/SpringMVC/servlet/retrieve-all-Stocks
	@GetMapping("/retrieve-all-Stocks")
	@ResponseBody
	public List<Stock> getStocks() {
	List<Stock> list = stockService.retrieveAllStocks();
	return list;
	}

	//localhost:9090/SpringMVC/servlet/retrieve-stock/{stock-id}
		@GetMapping("/retrieve-stock/{stock-id}")
		@ResponseBody
		public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
		}
		
		
		
		// http://localhost:9090/SpringMVC/servlet/add-stock
		@PostMapping("/add-stock")
		@ResponseBody
		public Stock addStock(@RequestBody Stock s) {
		Stock stock1 = stockService.addStock(s);
		return stock1;
		}
	
	
		//http://localhost:9090/SpringMVC/servlet/remove-stock/{stock-id}
			@DeleteMapping("/remove-stock/{stock-id}")
			@ResponseBody
			public void removeStock(@PathVariable("stock-id") Long stockId) {
			stockService.deleteStock(stockId);
			}
			
			
			
			//http://localhost:9090/SpringMVC/servlet/update-stock
			@PutMapping("/update-stock")
			@ResponseBody
			public Stock updatethestock(@RequestBody Stock st) {
			return stockService.StockUpadate(st);
					
			}
			
			
			
			// http://localhost:9090/SpringMVC/servlet/retrieve-Stock-By-Name/{Stock-nameStock}
						@GetMapping("/retrieve-Stock-By-Name/{Stock-nameStock}")
						@ResponseBody
						public List<Stock> retrieveStockByName(@PathVariable("Stock-nameStock") String nameStock) {
						return stockService.retrieveStockByName(nameStock);
						}
			
						
						

			
			
			
			// http://localhost:9090/SpringMVC/servlet/allocateProductToStock/{ids}/{idp}  	
			@PutMapping("/allocateProductToStock/{idstock}/{idproduct}")
			public void allocateProductToStock(@PathVariable(value = "idstock") Long idStock ,@PathVariable(value = "idproduct") int idProduct){
							
			stockService.allocateProductToStock(idStock, idProduct);
			
			
			}
			
			
			//////////////////////order product/////////////////////////
		//http://localhost:9090/SpringMVC/servlet/orderProduct/{pid}/{quantityProduct}  	
			
			@PutMapping(value = "/orderProduct/{pid}/{quantityProduct}")
			public void orderProduct(@PathVariable("pid")int idProduct,@PathVariable("quantityProduct")int quantityProduct) {
				 stockService.orderProduct(idProduct, quantityProduct);
				
			}
			
			


//http://localhost:9090/SpringMVC/servlet/maxquantity
			
			@GetMapping("/maxquantity")
			public int getmaxquantity() {
				 return sr.MaxQuantity();

			}
			
			
			
}
