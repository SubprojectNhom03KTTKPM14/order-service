package comjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comjava.dto.OrderDTO;
import comjava.dto.OrderDetailDTO;
import comjava.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("")
	public List<OrderDTO> getOrders(@RequestHeader("userId") Integer userId) {

		return orderService.getOrdersByUserId(userId);
	}

	@PostMapping("")
	public void saveOrder(@RequestHeader("userId") Integer userId, @RequestBody List<OrderDetailDTO> orderDetailDTOs) {

		orderService.newOrder(orderDetailDTOs, userId);
	}
}
