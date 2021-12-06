package comjava.repository;

import comjava.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository  extends JpaRepository<OrderDetail, Integer> {

    @Query(value = "select * from order_detail where order_id  = ?1 ",nativeQuery = true)
    List<OrderDetail> findByOrdersId(Integer orderId);

}
