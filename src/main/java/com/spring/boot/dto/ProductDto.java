package com.spring.boot.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.boot.model.Category;
import com.spring.boot.model.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProductDto {

    private Long id;

    @NotBlank(message = "Product should not be empty")
    private String name;

    private String imagePath;

    @NotBlank(message = "description should not be empty")
    private String description;

    private Double price;


    private Category category;


    List<Order> orders;


}
