package com.baitaplon.bookstore.controller.admin;

import com.baitaplon.bookstore.model.converter.BookConverter;
import com.baitaplon.bookstore.model.dto.BookDTO;
import com.baitaplon.bookstore.model.dto.CategoryDTO;
import com.baitaplon.bookstore.model.entity.CategoryEntity;
import com.baitaplon.bookstore.repository.CategoryRepository;
import com.baitaplon.bookstore.service.IBookService;
import com.baitaplon.bookstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class BookApi {
    @Autowired
    private IBookService bookService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/allbooks")
    public List<BookDTO> getAllBook() {
        List<BookDTO> bookDTOList = bookService.getAllBook();
        return bookDTOList;
    }
    @GetMapping("/book")
    public List<BookDTO> getAllAvailableBooks() {
        List<BookDTO> bookDTOList = bookService.getAllAvailableBooks();
        return bookDTOList;
    }

    @GetMapping("/book/{id}")
    public BookDTO getById(@PathVariable("id") String id) {
        BookDTO bookDTO = bookService.findOne(Integer.valueOf(id));
        return bookDTO;
    }

    @PostMapping("/book/{id}")
    public void addBook(@RequestBody BookDTO bookDTO, @PathVariable String id) {
        CategoryEntity category = categoryService.getById(bookDTO.getCategoryId());
        bookDTO.setAvailable(1);
        bookService.saveBook(bookDTO, category);
    }

    @PutMapping ("/book/{id}")
    public void editBook(@RequestBody BookDTO bookDTO, @PathVariable String id) {
        CategoryEntity category = categoryService.getById(bookDTO.getCategoryId());
        bookService.editBook(bookDTO, category);
    }
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id) {
        BookDTO bookDTO = bookService.findOne(id);
        CategoryEntity category = categoryService.getById(bookDTO.getCategoryId());
        bookDTO.setAvailable(0);
        bookService.editBook(bookDTO, category);

    }
}