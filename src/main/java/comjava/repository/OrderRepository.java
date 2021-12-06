package comjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import comjava.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

	List<Orders> findByUserId(Integer userId);

}
