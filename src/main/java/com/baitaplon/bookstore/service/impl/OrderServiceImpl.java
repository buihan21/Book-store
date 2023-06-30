package com.baitaplon.bookstore.service.impl;

import com.baitaplon.bookstore.model.converter.OrderConverter;
import com.baitaplon.bookstore.model.converter.UserConverter;
import com.baitaplon.bookstore.model.dto.OrderDTO;
import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.OrderDetailEntity;
import com.baitaplon.bookstore.model.entity.OrderEntity;
import com.baitaplon.bookstore.model.entity.UserEntity;
import com.baitaplon.bookstore.repository.OrderDetailRepository;
import com.baitaplon.bookstore.repository.OrderRepository;
import com.baitaplon.bookstore.repository.UserRepository;
import com.baitaplon.bookstore.service.IOrderService;
import com.baitaplon.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;
    private OrderConverter orderConverter = new OrderConverter();
    @Override
    public void addOrder(Integer idUser) {
//        UserDTO userDTO = userService.getById(orderDTO.getIdUser());
//        OrderEntity entity = orderConverter.toEntity(orderDTO, userDTO);
//        orderRepository.save(entity);

        OrderEntity order = new OrderEntity();
        LocalDate today = LocalDate.now();
        Date dateSql = Date.valueOf(today);
        UserEntity userEntity = userRepository.findById(idUser).get();
        order.setUser(userEntity);
        //order.setUser(UserConverter.toEntity(userService.getById(idUser)));
        order.setDate(dateSql);
        order.setIsConfirmed(0);
        order = orderRepository.save(order);

        List<OrderDetailEntity> orderDetailEntities =
                orderDetailRepository.findAllByUserAndStatus(userEntity, 0);
        for (OrderDetailEntity orderDetail : orderDetailEntities) {
            System.out.println(orderDetail.getId());
            orderDetail.setOrder(order);
            orderDetail.setStatus(1);
            orderDetailRepository.save(orderDetail);
        }
    }
}
