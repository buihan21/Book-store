package com.baitaplon.bookstore.service;

import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserDTO> fillAll(String key);
    UserDTO getById(Integer id);

    UserDTO login(String username, String password);
}
