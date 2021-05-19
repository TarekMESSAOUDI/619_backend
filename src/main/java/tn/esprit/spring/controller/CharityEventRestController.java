package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.CharityEvent;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.service.ICharityEventService;




@RestController
@CrossOrigin("http://localhost:4200")
public class CharityEventRestController {
	
	
	@Autowired
	ICharityEventService eS;
	
	// http://localhost:9091/SpringMVC/servlet/addEvent
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@PostMapping("/addEvent")
		@ResponseBody
		public CharityEvent addEvent(@RequestBody CharityEvent e) {
			eS.addEvent(e);
		return e;
		}

		
		// http://localhost:9091/SpringMVC/servlet/retrieveallEvent
				@GetMapping("/retrieveallEvent")
				@ResponseBody
				public List<CharityEvent> getEvent() {
				List<CharityEvent> list = eS.retreiveAllEvent();
				return list;
				}
		
				
				
				// http://localhost:9091/SpringMVC/servlet/remove-event/{idDelivery}
				//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
				@DeleteMapping("/remove-event/{idEvent}")
				@ResponseBody
				public void removeEvent(@PathVariable("idEvent") int id) {
				eS.deleteEvent(id); 
				}
				
				
		
				
				//http://localhost:9091/SpringMVC/servlet/FaireReservation/{idUser}/{idEvent}
				@PostMapping("/FaireReservation/{idReservation}/{idUser}/{idEvent}")
				public void FaireReservation(@PathVariable(value = "idReservation")int idreservation,@PathVariable(value = "idUser") int idUser,
				@PathVariable(value = "idEvent") int idEvent) {
				eS.FaireReservation( idreservation,idUser, idEvent);
				}
				
				
				//http://localhost:9091/SpringMVC/servlet/addReservation
					@PostMapping("/addReservation")
					@ResponseBody
					public Reservation addReservation(@RequestBody Reservation r) {
						eS.addReservation(r);
					return r;
					}
				
				


}
