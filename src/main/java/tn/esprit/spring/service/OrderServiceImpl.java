package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Order;
import tn.esprit.spring.entity.PaymentType;
import tn.esprit.spring.repository.OrderRepository;


@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	

	private static final Logger L=LogManager.getLogger(OrderServiceImpl.class);
	
	
	@Override
	public Order addOrder(Order o) {
		// TODO Auto-generated method stub
		return orderRepository.save(o);
		
	}
	
	@Override
	public Order updateOrder(Order o) {
		
		return orderRepository.save(o);
	}
	
	@Override
	public void deleteOrder(Long idOrder) {
		orderRepository.deleteById(idOrder);
		
	}
	
	@Override
	public List<Order> getAllOrder() {
		return (List<Order>)orderRepository.findAll();
	}
	
	@Override
	 public List<Order> getOrder_by_Type(PaymentType paymentType){
	    return orderRepository.findByPaymentType(paymentType);
	 }
	
	@Override
	public void Pay_By_Card(Long idOrder) {
		orderRepository.Pay_By_Card(idOrder);

	}
	
	@Override
	public void Pay_At_Delivery(Long idOrder) {
		orderRepository.Pay_At_Delivery(idOrder);
	}
	
	
	@Override
	 public List<Order> getAllOrder_by_Client(int idUser) {
		return orderRepository.getAllOrder_by_Client(idUser);
	}
	

}
