package net.javaguide.orderservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguide.basedomains.dto.Order;
import net.javaguide.basedomains.dto.OrderEvent;
import net.javaguide.orderservice.services.MyService;

@RestController

@RequestMapping("/api/v1/")
public class OrderController {


    private MyService myService;

    public OrderController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping("orders")
    public OrderEvent placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state");
        orderEvent.setOrder(order);

       
        return myService.sendMessageAndWaitForResponse(orderEvent);
    }
}
