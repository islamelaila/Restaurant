package com.spring.boot.mapper;
import com.spring.boot.dto.OrderDto;
import com.spring.boot.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

   Order toEntity(OrderDto orderDto);

   OrderDto toDto(Order order);

    List<Order> toEntityList(List<OrderDto> orderDtoList);

    List<OrderDto> toDtoList(List<Order> orderList);
}
