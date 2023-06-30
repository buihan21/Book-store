package com.baitaplon.bookstore.service.impl;

import com.baitaplon.bookstore.model.converter.OrderDetailConverter;
import com.baitaplon.bookstore.model.dto.BookDTO;
import com.baitaplon.bookstore.model.dto.OrderDetailDTO;
import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.OrderDetailEntity;
import com.baitaplon.bookstore.model.entity.ReviewEntity;
import com.baitaplon.bookstore.repository.OrderDetailRepository;
import com.baitaplon.bookstore.service.IBookService;
import com.baitaplon.bookstore.service.IOrderDetailService;
import com.baitaplon.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private IUserService userService;
    @Autowired
    private IBookService bookService;

    private OrderDetailConverter orderDetailConverter = new OrderDetailConverter();
    @Override
    public void addOrderDetail(OrderDetailDTO orderDetailDTO) {
        UserDTO userDTO = userService.getById(orderDetailDTO.getIdUser());
        BookDTO bookDTO = bookService.findOne(orderDetailDTO.getIdBook());
        OrderDetailEntity entity = orderDetailConverter.toEntity(orderDetailDTO, userDTO, bookDTO);
        orderDetailRepository.save(entity);
    }
}
