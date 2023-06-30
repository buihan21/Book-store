package com.baitaplon.bookstore.repository;

import com.baitaplon.bookstore.model.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ReviewReponsitory extends JpaRepository<ReviewEntity, Integer> {
    @Query(value = "SELECT * FROM review WHERE id_book = ?", nativeQuery = true)
    List<ReviewEntity> getByBookId(@Param("id_book") Integer idBook);

    @Query(value = "SELECT * FROM review WHERE id_user = ?", nativeQuery = true)
    List<ReviewEntity> getByUserId(@Param("id_user") Integer idUser);
}
