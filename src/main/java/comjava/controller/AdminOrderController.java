package comjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comjava.dto.OrderDTO;
import comjava.service.OrderService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminOrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("")
	public List<OrderDTO> listOrder() {

		return orderService.getOrders();
	}
}
