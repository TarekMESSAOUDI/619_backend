package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.CharityEvent;
import tn.esprit.spring.entity.Reservation;

public interface ICharityEventService {
	
void deleteEvent(int id);
	
	CharityEvent addEvent(CharityEvent e);
	
	public void FaireReservation(int idReservation ,int idUser,int idEvent);
	
	int getNombrePlacesEvent(int idevent);

	int getNombreParticpEvent(int idevent);
	
	List<CharityEvent>retreiveAllEvent();
	
	public List<Integer> getEventList();
	
	CharityEvent updateEvent(CharityEvent e);
	
	void addReservation(Reservation r);

}
