package com.baitaplon.bookstore.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class UserDTO {
    private Integer id;
    @NotEmpty
    @Email(message = "Email invalidate")
    private String email;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 30, message = "Tên đăng nhập phải có tối thiểu 6 ký tự và tối đa 30 ký tự")
    private String username;
//    @NotEmpty
//    @NotBlank
//    @Size(min=3, max = 15, message = "Mật khẩu phải có tối thiểu 6 ký tự và tối đa 30 ký tự")
//    private String password;

    private String role;
}
