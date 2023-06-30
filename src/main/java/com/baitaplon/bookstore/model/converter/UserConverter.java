package com.baitaplon.bookstore.model.converter;

import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserConverter {

    public static UserDTO toDto(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        //dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());
        return dto;
    }

    public static UserEntity toEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        return entity;
    }

}
