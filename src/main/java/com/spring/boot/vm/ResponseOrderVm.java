package com.spring.boot.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderVm {

    private String code ;
    private Double totalPrice ;
    private Long totalNumber ;
}
