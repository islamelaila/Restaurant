package com.spring.boot.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.boot.model.Product;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        name = "Category DTO",
        description = " Category DTO Contains all information about category"

)
public class CategoryDto {


    private  long id ;

    @NotBlank(message = "Category should not be empty")
    @Schema(
            name = "Category Name",
            description = "Category Name",
            example = "Food"
    )
    private String name;

    private String logo ;

    private String flag ;

    private List<Product> products;






}
