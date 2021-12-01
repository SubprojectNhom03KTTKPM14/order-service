package comjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comjava.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
