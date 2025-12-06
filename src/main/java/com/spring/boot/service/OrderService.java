package com.spring.boot.service;
import com.spring.boot.vm.RequestOrderVm;
import com.spring.boot.vm.ResponseOrderVm;

public interface OrderService {


   ResponseOrderVm requestOrder(RequestOrderVm requestOrderVm);

}
