package com.baitaplon.bookstore.repository;

import com.baitaplon.bookstore.model.entity.OrderDetailEntity;
import com.baitaplon.bookstore.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {
    //@Query(value = "SELECT * FROM order_detail WHERE id_user = ? AND status = ?", nativeQuery = true)
    List<OrderDetailEntity> findAllByUserAndStatus(UserEntity user, Integer status);
}
