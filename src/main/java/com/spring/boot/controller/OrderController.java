package com.spring.boot.controller;

import com.spring.boot.service.OrderService;
import com.spring.boot.vm.RequestOrderVm;
import com.spring.boot.vm.ResponseOrderVm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(
        name = "Order Controller",
        description = "APIs responsible for creating and managing orders"
)
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @PostMapping("/create")
    @Operation(
            summary = "Create new order",
            description = "Create a new order based on request data"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Order created successfully",
                    content = @Content(
                            schema = @Schema(implementation = ResponseOrderVm.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid order request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<ResponseOrderVm> createOrder(
            @RequestBody RequestOrderVm requestOrderVm
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/orders/create"))
                .body(orderService.requestOrder(requestOrderVm));
    }
}
