package com.baitaplon.bookstore.service.impl;

import com.baitaplon.bookstore.model.converter.UserConverter;
import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.UserEntity;
import com.baitaplon.bookstore.repository.UserRepository;
import com.baitaplon.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> fillAll(String key) {
        List<UserEntity> entities = userRepository.findAll();
        List<UserDTO> list = new ArrayList<>();
        for (UserEntity entity : entities) {
            list.add(UserConverter.toDto(entity));
        }
        return list;
    }

    @Override
    public UserDTO getById(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return UserConverter.toDto(userEntity);
    }

    @Override
    public UserDTO login(String username, String password) {
        UserEntity entity = userRepository.findByUsernameAndPassword(username, password).orElse(null);
        if (entity != null) {
//            if(passwordEncoder.matches(password, entity.getPassword())) {
                UserDTO userDTO = UserConverter.toDto(entity);
                return userDTO;
//            }
        }
        return null;
    }
}
