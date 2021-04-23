
package tn.esprit.spring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.el.parser.ParseException;

import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.repository.PublicityRepository;



@Service
public class PublicityServiceImpl implements IPublicityService {

	@Autowired
	PublicityRepository publicityRepository;
	
	
	
	
	private static final Logger L = LogManager.getLogger(IPublicityService.class);
	
	@Override  //done
	public List<Publicity> showAll() {
	 List<Publicity> publicities=(List<Publicity>) publicityRepository.findAll();
	 for (Publicity p :publicities){
		 L.info("Publicity+++"+p);
		 System.out.println(p);
	 }
		 return publicities;
	
	}

	
	@Override //done
	public void deletePublicity(int id) {
		if (publicityRepository.existsById(id))
		{
		publicityRepository.deleteById(id);
		}
		else System.out.println("Publicity with id:"+id+" Does Not exist");
		
	}

	

	@Override  //done
	public Publicity updatePublicity(Publicity p) {
		Publicity existingPub=publicityRepository.findById(p.getIdPublicity()).orElse(null);
		existingPub.setNamePublicity(p.getNamePublicity());
		existingPub.setStartDatePublicity(p.getStartDatePublicity());
		existingPub.setTargetPublicity(p.getTargetPublicity());
		existingPub.setChannelPublicity(p.getChannelPublicity());
		existingPub.setCostPublicity(p.getCostPublicity());
		existingPub.setMailOwnerPublicity(p.getMailOwnerPublicity());
		existingPub.setPhoneOwnerPublicity(p.getPhoneOwnerPublicity());
		existingPub.setDescriptionPublicity(p.getDescriptionPublicity());
		existingPub.setInitialViewNumber(p.getInitialViewNumber());
		existingPub.setFinalViewNumber(p.getFinalViewNumber());
		existingPub.setTypePublicity(p.getTypePublicity());
		existingPub.setEndDatePublicity(p.getEndDatePublicity());
		
		
		return publicityRepository.save(existingPub);
	}

 
	@Override //done
	public Publicity GetPublicityById(int id) {
		return publicityRepository.findById(id).orElse(null);
	}


	@Override //done
	public List<Publicity> GetPublicitiesByName(String name) {
		List<Publicity> pubs =(List<Publicity>) publicityRepository.findAllByNamePublicity(name);
		for (Publicity pub : pubs){
			L.info("Product +++ :" + pub);
		}
		return pubs;
	}


	@Override //done
	public Publicity addPublicity(Publicity p) {
		publicityRepository.save(p);
		return p;
	}


	@Override
	public Publicity findById(int id) {
		return publicityRepository.findById(id).orElse(null); 
	}


	@Override
	public float coastOnChannel(String Channel) {
		if ((Channel.equals("FACEBOOK"))|| (Channel.equals("INSTAGRAM")) || (Channel.equals("SITE")))
				{
			return 300;
		}
		if(Channel.equals("TWITTER")){
			return 150;	
		}
		else return 100;
		 
	}
	
	
	public int differenceStartDateAndEndDatePub(String dateStart, String dateEnd) throws ParseException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		LocalDate dateD = LocalDate.parse(dateStart, format);
		LocalDate dateF = LocalDate.parse(dateEnd, format);
		int periodDays;
		int yearDef = dateF.getYear() - dateD.getYear();
		if (yearDef == 0) {
			periodDays = dateF.getDayOfYear() - dateD.getDayOfYear();
			return periodDays;
		} else {
			int nbrYears = yearDef * 365;
			periodDays = (dateF.getDayOfYear() - dateD.getDayOfYear()) + nbrYears;
			return periodDays;
		}
	}
	
	
	public int costOnNbrDays(String StartDate,String EndDate) throws ParseException{
		
		if(StartDate!=null && EndDate!=null){
			int NbrDaysPub = differenceStartDateAndEndDatePub( StartDate, EndDate);
			int cost = 0;
			if (NbrDaysPub <= 30) {
				return cost += 5 * NbrDaysPub;
			}
			if (NbrDaysPub > 30 && NbrDaysPub <= 90) {
				return cost += 8 * NbrDaysPub;
			}
			if (NbrDaysPub > 90 && NbrDaysPub <= 180) {
				return cost += 12 * NbrDaysPub;
			} else {
				return cost += 20 * NbrDaysPub;
			}
			}
			else return 0;
		}
	
	
	public float CalculeCoutTotalPub( String canal, String dateDebut,
			String dateFin, String typePub) throws ParseException {
		float cost = coastOnChannel(canal);
		
		cost += costOnNbrDays(dateDebut, dateFin);
		
		if (typePub.equals("Video")) {
			cost += 250;
		}
		if (typePub.equals("Image"))
			cost += 150;
		return cost;
	}

		
	

}

