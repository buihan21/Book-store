package com.baitaplon.bookstore.repository;

import com.baitaplon.bookstore.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
   // Optional<UserEntity> findByUsername(String username);
    //Boolean existsByEmail(String email); //ktra email co ton tai hay chua
//    Boolean existsByUsername(String username); // ktra username da ton tai hay chua
//
//    @Query(value = "SELECT * FROM users WHERE username LIKE %:keyword%", nativeQuery = true)
//    List<UserEntity> searchUserByKeyWord(@Param("keyword") String keyword);
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

}
