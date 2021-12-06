package comjava.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import comjava.VO.OrderDetailVO;
import comjava.dto.OrderDTO;
import comjava.dto.OrderDetailDTO;
import comjava.dto.ProductDTO;
import comjava.dto.UserDTO;
import comjava.entity.OrderDetail;
import comjava.entity.Orders;
import comjava.repository.OrderDetailRepository;
import comjava.repository.OrderRepository;
import comjava.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<OrderDTO> getOrders() {
		List<Orders> orders = orderRepository.findAll();

		List<OrderDTO> result = new ArrayList<OrderDTO>();
		for (Orders ordersEle : orders) {

			OrderDTO orderDTO = this.getOrderById(ordersEle.getId());
			result.add(orderDTO);
		}

		return result;
	}

	@Override
	public List<OrderDTO> getOrdersByUserId(Integer userId) {

		List<Orders> orders = orderRepository.findByUserId(userId);

		List<OrderDTO> result = new ArrayList<OrderDTO>();
		for (Orders ordersEle : orders) {

			OrderDTO orderDTO = this.getOrderById(ordersEle.getId());
			result.add(orderDTO);
		}

		return result;
	}

	@Override
	public void newOrder(List<OrderDetailDTO> orderDetailDTOs, Integer userId) {
		Orders orders = new Orders();
		orders.setUserId(userId);
		orders.setCreatedDate(LocalDate.now());
		orderRepository.save(orders);

		
		for (OrderDetailDTO o : orderDetailDTOs) {

			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setProductId(o.getProductID());
			orderDetail.setOrders(orders);
			orderDetail.setQuantity(o.getQuantity());
			
			orders.getOrderDetails().add(orderDetail);
		}

		
		orderRepository.save(orders);
	}

	@Override
	public OrderDTO getOrderById(Integer orderId) {
		OrderDTO orderDTO = new OrderDTO();
		Orders orders = orderRepository.getById(orderId);
		orderDTO.setId(orderId);
		orderDTO.setCreatedDate(orders.getCreatedDate());
		List<OrderDetail> list = orderDetailRepository.findByOrdersId(orderId);

		List<OrderDetailVO> orderDetailVOList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			ProductDTO productDTO = restTemplate.getForObject(
					"http://product-service/product-service/products/" + list.get(i).getProductId(), ProductDTO.class);
			OrderDetailVO orderDetailVO = new OrderDetailVO();
			orderDetailVO.setProduct(productDTO);
			orderDetailVO.setQuantity(list.size());
			orderDetailVOList.add(orderDetailVO);
		}
		orderDTO.setOrderDetails(orderDetailVOList);

		UserDTO userDTO = restTemplate.getForObject("http://user-service/user-service/users/" + orders.getUserId(),
				UserDTO.class);
		orderDTO.setUser(userDTO);
		return orderDTO;
	}

}
