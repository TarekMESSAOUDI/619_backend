package tn.esprit.spring.repository;





import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.entity.PaymentType;







@Repository
public interface BillRepository  extends CrudRepository <Bill,Long> {
	

	
	List<Bill> findByPaymentType(PaymentType p);

	
	
	@Query(value = "SELECT * FROM T_BILL t WHERE order_id_order=?1", nativeQuery = true)
    public List<Bill> getAllBill_by_Order(Long idOrder);



	@Query(value = "select payment_type from T_BILL t where id_bill=?1", nativeQuery = true)
    public String  get_payment_type_by_idBill(Long idBill);



	@Query(value = "SELECT * FROM T_BILL WHERE id_bill=?1", nativeQuery = true)
	public Bill getOne(Long idBill);



	






	


	
}