package com.spring.boot.controller;
import com.spring.boot.service.OrderService;
import com.spring.boot.vm.RequestOrderVm;
import com.spring.boot.vm.ResponseOrderVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    private OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseOrderVm> createOrder(@RequestBody RequestOrderVm requestOrderVm) throws URISyntaxException {
        return ResponseEntity.created(new URI("/orders/create")).body(orderService.requestOrder(requestOrderVm));
    }
}
