package com.spring.boot.service.impl;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.dto.UsersDto;
import com.spring.boot.mapper.OrderMapper;
import com.spring.boot.mapper.ProductMapper;
import com.spring.boot.mapper.UsersMapper;
import com.spring.boot.model.Order;
import com.spring.boot.repo.OrderRepo;
import com.spring.boot.service.OrderService;
import com.spring.boot.service.ProductService;
import com.spring.boot.vm.OrderVm;
import com.spring.boot.vm.RequestOrderVm;
import com.spring.boot.vm.ResponseOrderVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;

    private ProductService productService;


    private OrderMapper orderMapper;

    private UsersMapper usersMapper;

    private ProductMapper productMapper;


    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo , ProductService productService , OrderMapper orderMapper , UsersMapper usersMapper , ProductMapper productMapper) {
        this.orderRepo = orderRepo;
        this.productService = productService;
        this.orderMapper = orderMapper;
        this.usersMapper = usersMapper;
        this.productMapper = productMapper;
    }


    @Override
    public ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm) {
        // user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersDto usersDto = (UsersDto) authentication.getPrincipal();

        // calculate totalNumber
        Long totalNumber = requestOrderVm.getOrderVms().stream().mapToLong(orderVm -> orderVm.getQuantity()).sum();

        // get products
        List<Long> productsIds = requestOrderVm.getOrderVms().stream().map(orderVm -> orderVm.getId()).collect(Collectors.toList());
        List<ProductDto> productDtos = productService.getProductsByIds(productsIds);

        // calculate total price
        Double totalPrice = calculateTotalPrice(requestOrderVm.getOrderVms(), productDtos);


        // save order
        Order order = new Order();
        order.setTotalNumber(totalNumber);
        order.setTotalPrice(totalPrice);
        order.setUser(usersMapper.toEntity(usersDto));
        order.setProducts(productMapper.toEntityList(productDtos));

        orderRepo.save(order);
        // set code
        String code = getCode(order);
        order.setCode(code);
        orderRepo.save(order);

        return new ResponseOrderVm(code, totalPrice, totalNumber);

    }

    private static String getCode(Order order) {
        return "DEGO-" + order.getId();
    }

    private Double calculateTotalPrice(List<OrderVm> orderVms , List<ProductDto> productDtos) {
        Map<Long ,Double> ProductsPrice = productDtos.stream().collect(
                Collectors.toMap(ProductDto::getId, ProductDto::getPrice)
        );

        return orderVms.stream().mapToDouble(order -> {
            Double price = ProductsPrice.get(order.getId());
            return price * order.getQuantity();
        }).sum();


    }

        }



