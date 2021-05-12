package tn.esprit.spring.service;

import java.util.List;

import java.util.Optional;


import tn.esprit.spring.entity.Order;
import tn.esprit.spring.entity.PaymentType;



public interface IOrderService {

	Order addOrder(Order o);

	Order updateOrder(Order o);

	void deleteOrder(Long idOrder);

	List<Order> getAllOrder();

	List<Order> getOrder_by_Type(PaymentType paymentType);

	void Pay_By_Card(Long idOrder);

	void Pay_At_Delivery(Long idOrder);

	List<Order> getAllOrder_by_Client(int idUser);



	

	void orderpdf(Long idOrder);

	Optional<Order> getBill_by_ID(Long idOrder);



	

	
}
