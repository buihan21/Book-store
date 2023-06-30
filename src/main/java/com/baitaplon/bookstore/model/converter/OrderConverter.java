package com.baitaplon.bookstore.model.converter;

import com.baitaplon.bookstore.model.dto.OrderDTO;
import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    public OrderEntity toEntity(OrderDTO orderDTO, UserDTO userDTO) {
        OrderEntity entity = new OrderEntity();
        entity.setId(orderDTO.getId());
        entity.setDate(orderDTO.getDate());
        entity.setIsConfirmed(orderDTO.getIsConfirmed());
        entity.setUser(UserConverter.toEntity(userDTO));
        return entity;
    }
}
