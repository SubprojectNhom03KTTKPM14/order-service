package comjava.controller;

import comjava.dto.OrderDTO;
import comjava.dto.OrderDetailDTO;
import comjava.entity.Orders;
import comjava.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String helloWorld(){
        return "order service!";
    }

    /*add order*/
    @PostMapping("/orders")
    public List<OrderDetailDTO> saveOrder(@RequestBody List<OrderDetailDTO> list){
        orderService.newOrder(list,1);
        return list;
    }
    /*get list order*/
    @GetMapping("/orders")
    public List<Orders> listOrder(){
        List<Orders> ordersLists = orderService.getOrders();
        return ordersLists;
    }

//    /*get order detail*/
    @GetMapping("/orders/{orderId}")
    public OrderDTO findOrderById(@PathVariable("orderId") Integer orderId){
        OrderDTO orderDTO =orderService.getOrderById(orderId);
        System.out.println("orders"+orderDTO);
        return orderDTO;
    }
}
