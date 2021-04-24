package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Delivery;

public interface IDeliveryService {
	
	List<Delivery>retreiveAllDelivery();
	Delivery addDelivery(Delivery dd);
	void deleteDelivery(int id);
	Delivery updateDelivery(Delivery dd);
	Optional<Delivery>retreiveDelivery(int id);
	int calculCosts(int kilometrage);
	public void affecterDelivery(int idDelivery ,int idUser);
	public void DesaffecterDelivery(int idDelivery ,int idUser);

}
