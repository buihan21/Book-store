package com.baitaplon.bookstore.model.converter;

import com.baitaplon.bookstore.model.dto.BookDTO;
import com.baitaplon.bookstore.model.dto.OrderDetailDTO;
import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.BookEntity;
import com.baitaplon.bookstore.model.entity.OrderDetailEntity;
import com.baitaplon.bookstore.model.entity.UserEntity;
import com.baitaplon.bookstore.repository.BookRepository;
import com.baitaplon.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailConverter {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    public OrderDetailDTO toDto(OrderDetailEntity entity) {
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setId(entity.getId());
        dto.setIdUser(entity.getUser().getId());
        dto.setIdBook(entity.getBook().getId());
        dto.setStatus(entity.getStatus());
        dto.setQuantity(entity.getQuantity());
        return dto;
    }

    public OrderDetailEntity toEntity(OrderDetailDTO dto, UserDTO userDTO, BookDTO bookDTO) {
        OrderDetailEntity entity = new OrderDetailEntity();
        UserEntity userEntity = UserConverter.toEntity(userDTO);
        entity.setUser(userEntity);

        BookEntity bookEntity = BookConverter.toEntity(bookDTO);
        entity.setBook(bookEntity);

        entity.setStatus(dto.getStatus());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }
}
