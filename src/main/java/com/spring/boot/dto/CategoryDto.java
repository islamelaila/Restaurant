package com.spring.boot.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.boot.model.Product;
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
public class CategoryDto {


    private  long id ;

    @NotBlank(message = "Category should not be empty")
    private String name;

    private String logo ;

    private String flag ;
    private List<Product> products;






}
