package com.baitaplon.bookstore.repository;

import com.baitaplon.bookstore.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findOneByNameAndAuthor(String name, String author);
    List<BookEntity> findByAvailable(int available);
//    List<BookEntity> findAllByCategory(Integer category_id);
//    Optional<BookEntity> findOne(Integer id);
//
//    @Query(value = "SELECT * FROM book WHERE name LIKE %:keyword% OR author LIKE %:keyword%", nativeQuery = true)
//    List<BookEntity> searchBookByNameOrAuthor(@Param("keyword") String keyword);
}
