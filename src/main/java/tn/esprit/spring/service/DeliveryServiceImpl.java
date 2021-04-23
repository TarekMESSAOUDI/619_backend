package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;

import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.entity.User;
//import tn.esprit.spring.entities.DeliveryPerson;
//import tn.esprit.spring.entities.Status;
//import tn.esprit.spring.repository.DeliveryPersonRepository;
import tn.esprit.spring.repository.IDeliveryRepository;
import tn.esprit.spring.repository.IUserRepository;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

	@Autowired
	IUserRepository userR;
	@Autowired
	IDeliveryRepository deliveryR;

	 private final static String ACCOUNT_SID = "AC10024a1f5e8bfaf3b47d00cf6ecc98a3";
	 private final static String AUTH_ID = "7ee7443610b7e9412c7ca955a01559f4";

	   static {
	      Twilio.init(ACCOUNT_SID, AUTH_ID);
	   }
	@Override
	public List<Delivery>retreiveAllDelivery(){
		
		List<Delivery> delivery = (List <Delivery>)deliveryR.findAll();
		return delivery;
	}
	
	@Override
	public Delivery addDelivery(Delivery dd){
		
		return deliveryR.save(dd);
	}
	
	@Override
	public void deleteDelivery(int id) {
		
		deliveryR.deleteById(id);
	}
	
	@Override
	public Delivery updateDelivery(Delivery dd) {
		
		return deliveryR.save(dd);
		}
	
	@Override
	public Optional<Delivery> retreiveDelivery(int id) {
		
		return deliveryR.findById(id);
	}

	@Override
	public void affecterDelivery(int idDelivery, int idUser) {
		// TODO Auto-generated method stub
		Delivery d = deliveryR.findById(idDelivery).orElse(null);
		User deliveryPerson = userR.findById(idUser).orElse(null);
		d.setUser(deliveryPerson);
		deliveryR.save(d);
		 com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+21624339824"), new PhoneNumber("+19286429132"),
		         "Votre commande a été confirmée").create();
        final String username = "nader.espritmailer@gmail.com";
        final String password = "12345678aA";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nader.espritmailer@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(deliveryPerson.getEmailUser())
            );
            message.setSubject("New Delivery");
            message.setText("Dear "+deliveryPerson.getUsername()
                    + "Please check your new delivery:"+"place"+d.getPlaceDelivery() +d.getAdressDelivery()+" date "+d.getDateDelivery()+"kilometrage"+d.getKilometrage()+" cost : "+d.getCosts());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    

		
	}
	
	/*@Override
	public void desaffecterDelivery(int idDelivery, int idUser) {
		// TODO Auto-generated method stub
		Delivery d = deliveryR.findById(idDelivery).orElse(null);
		DeliveryPerson dd = dr.findById(idUser).orElse(null);
		d.setDeliveryPerson(dd);
		deliveryR.delete(d);
		
	}*/
	
	

	

	
	
	
	
	
	@Override
	public void DesaffecterDelivery(int idDelivery, int idUser) {
		// TODO Auto-generated method stub
		Delivery d = deliveryR.findById(idDelivery).orElse(null);
		User deliveryPerson = userR.findById(idUser).orElse(null);
		d.setUser(null);
		deliveryR.save(d);
	
	
}

	@Override
	public int calculCosts(int kilometrage) {
		if (kilometrage<=50) {
			return 5;	
			}else return 10;	
	}}


