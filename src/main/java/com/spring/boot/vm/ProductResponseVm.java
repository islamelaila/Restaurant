package com.spring.boot.vm;

import com.spring.boot.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseVm {

   private List<ProductDto> products;

   private long totalProducts;




}
