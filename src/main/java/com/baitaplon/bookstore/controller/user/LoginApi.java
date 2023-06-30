package com.baitaplon.bookstore.controller.user;

import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginApi {
    @Autowired
    private IUserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestParam String username, @RequestParam String password) {
        UserDTO userDTO = userService.login(username, password);
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userDTO);
    }
}
