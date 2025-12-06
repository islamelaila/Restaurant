package com.spring.boot.dto;
import com.spring.boot.model.Product;
import com.spring.boot.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private long id;
    private String code;
    private double totalPrice;
    private long totalNumber;

    List<Product> products;

    private Users user;
}
