package com.baitaplon.bookstore.service;

import com.baitaplon.bookstore.model.dto.BookDTO;
import com.baitaplon.bookstore.model.entity.CategoryEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IBookService {
    List<BookDTO> getAllBook();
   // List<BookDTO> searchBookByNameOrAuthor(String keyword);
    //List<BookDTO> findAllByCategory(Integer categoryId);
    List<BookDTO> getAllAvailableBooks();
    BookDTO findOne(Integer id);
    //BookDTO saveBook(BookDTO bookDTO, Integer bookId);
    void editBook(BookDTO bookDTO, CategoryEntity categoryEntity);
    void saveBook(BookDTO bookDTO, CategoryEntity categoryEntity);
    String saveImage(MultipartFile file) throws IOException;
    void delete(Integer id);
}
