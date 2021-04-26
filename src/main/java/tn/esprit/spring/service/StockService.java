package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.entity.TypeStock;

public interface StockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	void deleteStock(Long idStock);

	Stock updateStock(Stock s);

	Stock retrieveStock(Long idStock);

	List<Stock> retrieveStockByName(String nameStock);



	

	void allocateProductToStock(Long idStock, int IdProduct);



	Stock StockUpadate(Stock st);

	void orderProduct(int idProduct, int quantity);

	


	



}
