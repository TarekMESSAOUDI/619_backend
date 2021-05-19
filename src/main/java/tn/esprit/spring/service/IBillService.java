
package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.entity.PaymentType;



public interface IBillService {
	
	public List<Bill> getAllBill();

	Bill addBill(Bill b);

	void deleteBill(Long idBill);

	Bill updateBill(Bill b);

	Optional<Bill> getBill_by_ID(Long idBill);

	List<Bill> getBill_by_Type(PaymentType paymentType);

	List<Bill> getAllBill_by_Order(Long idOrder);


	void modify_type_bill(PaymentType paymentType, Long idBill);

	String get_payment_type_by_idBill(Long idBill);

	void billpdf(Long idBill);

}

package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.entity.PaymentType;



public interface IBillService {
	
	public List<Bill> getAllBill();

	Bill addBill(Bill b);

	void deleteBill(Long idBill);

	Bill updateBill(Bill b);

	Optional<Bill> getBill_by_ID(Long idBill);

	List<Bill> getBill_by_Type(PaymentType paymentType);

	List<Bill> getAllBill_by_Order(Long idOrder);


	void modify_type_bill(PaymentType paymentType, Long idBill);

	String get_payment_type_by_idBill(Long idBill);


	//void billpdf(Long idBill);

	void billpdf(Long idBill);


}
