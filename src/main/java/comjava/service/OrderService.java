package comjava.service;


import comjava.dto.OrderDTO;
import comjava.dto.OrderDetailDTO;
import comjava.entity.OrderDetail;
import comjava.entity.Orders;

import java.util.List;
import java.util.Optional;


public interface OrderService {
    List<Orders> getOrders();

    public void newOrder(List<OrderDetailDTO> list, Integer userId);

    public OrderDTO getOrderById( Integer orderId);


}
