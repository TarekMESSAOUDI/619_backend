package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Order;
import tn.esprit.spring.entity.PaymentType;




@Repository
public interface OrderRepository extends CrudRepository <Order,Long> {
	
	List<Order> findByPaymentType(PaymentType p);
	
	
	@Query(value = "UPDATE T_ORDER o set o.state_order='pay',o.payment_type='By_Card'where o.id_order=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void Pay_By_Card(@Param("idOrder") Long idOrder);
	
	@Query(value = "UPDATE T_ORDER o set o.state_order='at delivery',o.payment_type='At_Delivery'where o.id_order=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void Pay_At_Delivery(@Param("idOrder") Long idOrder);

	
	@Query(value = "SELECT * FROM T_ORDER o WHERE user_id_user=?1", nativeQuery = true)
    public List<Order> getAllOrder_by_Client(int idUser);

	
	

}
