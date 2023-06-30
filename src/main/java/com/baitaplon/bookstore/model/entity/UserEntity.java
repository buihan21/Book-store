package com.baitaplon.bookstore.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
                                            @UniqueConstraint(columnNames = "email")})
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(nullable = false, length = 45)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 70)
    private String email;

    @Column(nullable = false, length = 25)
    private String role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<ReviewEntity> reviewEntities = new ArrayList<>();
}
