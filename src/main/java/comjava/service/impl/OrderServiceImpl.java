package comjava.service.impl;

import comjava.VO.OrderDetailVO;
import comjava.dto.*;
import comjava.entity.OrderDetail;
import comjava.entity.Orders;
import comjava.repository.OrderDetailRepository;
import comjava.repository.OrderRepository;
import comjava.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Orders> getOrders() {
        List<Orders> listOrders = orderRepository.findAll();
        return listOrders;
    }

    @Override
    public void newOrder(List<OrderDetailDTO> list, Integer userId) {
        Orders newOrder = orderRepository.save(new Orders(1));
        Orders orders = newOrder;
        orders.setUserId(1);
        LocalDate createdDate = LocalDate.now();
        orders.setCreatedDate(createdDate);
        orderRepository.save(orders);
        for (OrderDetailDTO o: list) {
            OrderDetail orderDetail= new OrderDetail();
            orderDetail.setProductId(o.getProductID());
            orderDetail.setOrderId(orders);
            orderDetail.setQuantity(o.getQuantity());
            orderDetailRepository.save(orderDetail);
        }

    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        OrderDTO orderDTO = new OrderDTO();
//        lấy order từ orderId
        Orders orders = orderRepository.getById(orderId);
//        set Id
        orderDTO.setId(orderId);
//        set date
        orderDTO.setCreatedDate(orders.getCreatedDate());
//       set order detail list
        List<OrderDetail> list = orderDetailRepository.findByOrdersId(orderId);

        List<OrderDetailVO> orderDetailVOList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ProductDTO productDTO =
                    restTemplate.getForObject("http://localhost:8084/product-service/products/"
                                    +list.get(i).getProductId(),
                            ProductDTO.class);
            OrderDetailVO orderDetailVO =new OrderDetailVO();
            orderDetailVO.setProduct(productDTO);
            orderDetailVO.setQuantity(list.size());
            orderDetailVO.totalPrice();
            orderDetailVOList.add(orderDetailVO);
        }
        orderDTO.setOrderDetails(orderDetailVOList);

//        set user
        System.out.println("user"+orders.getUserId());
        UserDTO userDTO =
                restTemplate.getForObject("http://localhost:8081/user-service/users/"
                                + orders.getUserId(),
                        UserDTO.class);
        System.out.println("user"+ userDTO);
        orderDTO.setUser(userDTO);
        return orderDTO;
    }



}
