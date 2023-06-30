package com.baitaplon.bookstore.controller.user;

import com.baitaplon.bookstore.model.dto.OrderDTO;
import com.baitaplon.bookstore.model.dto.OrderDetailDTO;
import com.baitaplon.bookstore.service.IOrderDetailService;
import com.baitaplon.bookstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OrderApi {
    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private IOrderService orderService;
    @PostMapping("/api/order/orderDetail")
    public void addOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO){
        orderDetailService.addOrderDetail(orderDetailDTO);
    }
    @PostMapping("/api/order/{idUser}")
    public void addOrder(@PathVariable String idUser) {
        orderService.addOrder(Integer.valueOf(idUser));
    }
}
