package comjava.service;

import java.util.List;

import comjava.dto.OrderDTO;
import comjava.dto.OrderDetailDTO;

public interface OrderService {

	List<OrderDTO> getOrders();

	List<OrderDTO> getOrdersByUserId(Integer userId);

	void newOrder(List<OrderDetailDTO> list, Integer userId);

	OrderDTO getOrderById(Integer orderId);
}
