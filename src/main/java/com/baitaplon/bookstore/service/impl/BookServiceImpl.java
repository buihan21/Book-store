package com.baitaplon.bookstore.service.impl;

import com.baitaplon.bookstore.exception.ResourceNotFoundException;
import com.baitaplon.bookstore.model.converter.BookConverter;
import com.baitaplon.bookstore.model.dto.BookDTO;
import com.baitaplon.bookstore.model.entity.BookEntity;
import com.baitaplon.bookstore.model.entity.CategoryEntity;
import com.baitaplon.bookstore.repository.BookRepository;
import com.baitaplon.bookstore.repository.CategoryRepository;
import com.baitaplon.bookstore.service.IBookService;
import com.baitaplon.bookstore.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.awt.print.Book;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    private BookConverter bookConverter = new BookConverter();

    @Override
    public List<BookDTO> getAllBook() {
        List<BookEntity> entities = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (BookEntity entity : entities) {
            bookDTOList.add(BookConverter.toDto(entity));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> getAllAvailableBooks() {
        List<BookEntity> entities = bookRepository.findByAvailable(1);
        return entities.stream().map(BookConverter::toDto).collect(Collectors.toList());
    }

    //    @Override
//    public List<BookDTO> searchBookByNameOrAuthor(String keyword) {
//        List<BookEntity> bookEntityList = bookRepository.searchBookByNameOrAuthor(keyword);
//        List<BookDTO> bookDTOList = new ArrayList<>();
//        for (BookEntity entity : bookEntityList) {
//            bookDTOList.add(BookConverter.toDto(entity));
//        }
//        return bookDTOList;
//    }
//
//    @Override
//    public List<BookDTO> findAllByCategory(Integer categoryId) {
//        List<BookEntity> bookEntityList = bookRepository.findAllByCategory(categoryId);
//        List<BookDTO> bookDTOList = new ArrayList<>();
//        for (BookEntity entity : bookEntityList) {
//            bookDTOList.add(BookConverter.toDto(entity));
//        }
//        return bookDTOList;
//    }
//
    @Override
    public BookDTO findOne(Integer id) {
        BookEntity entity = bookRepository.findById(id).orElse(null);
                //.orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
    if(entity == null){
        return new BookDTO();
    }
        return BookConverter.toDto(entity);
    }

    @Override
    public void editBook(BookDTO bookDTO, CategoryEntity categoryEntity) {
        bookRepository.save(BookConverter.toEntity(bookDTO, categoryEntity));
    }

    @Override
    public void saveBook(BookDTO bookDTO, CategoryEntity categoryEntity) {
        BookEntity book = BookConverter.toEntity(bookDTO, categoryEntity);
        bookRepository.save(book);
    }

//    @Override
//    public BookDTO saveBook(BookDTO bookDTO, Integer bookId) {
//        List<BookEntity> listBook = bookRepository.findAll();
//        for (BookEntity book : listBook) {
//            if (book.getId() == bookId) {
//                return null;
//            }
//        }
//        return null;
//    }

//    @Override
//    public BookDTO saveBook(BookDTO bookDTO, Integer categoryId) {
//        BookEntity entity = new BookEntity();
//        BookEntity oldBook = bookRepository.findOneByNameAndAuthor(bookDTO.getName(), bookDTO.getAuthor());
//
//        // create new book
//        if (bookDTO.getId() == null) {
//            if (oldBook != null) {
//                return null;
//            }
//            entity = save(bookDTO, categoryId);
//            //entity = BookConverter.toEntity(saveBook(bookDTO, categoryId));
//        }
//
//        // edit book
//        else {
//            if (oldBook == null || (oldBook != null && oldBook.getId().equals(bookDTO.getId()))){
//                entity = update(bookDTO);
//                if (!categoryId.equals(entity.getCategory().getId())) {
//                    CategoryEntity category = categoryRepository.findById(categoryId)
//                            .orElseThrow(() -> new ResourceNotFoundException("Post", "id", categoryId));
//                    entity.setCategory(category);
//                }
//            }
//            else {
//                return null;
//            }
//        }
//        entity = bookRepository.save(entity);
//        return BookConverter.toDto(entity);
//    }



    @Override
    public String saveImage(MultipartFile file) throws IOException {
        String uploadDir = "upload/bookImage/";
        Path pathFile = FileUploadUtils.saveFile(uploadDir, file);
        String pathStr = pathFile.toString().replace("\\", "/");
        return pathStr;
    }

//    private BookEntity save(BookDTO bookDTO, Integer categoryId) {
//        BookEntity entity = BookConverter.toEntity(bookDTO);
//        CategoryEntity category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", categoryId));
//        entity.setCategory(category);
//        entity.setStatus(0);
//        return entity;
//    }

//    private BookEntity update(BookDTO bookDTO) {
//        BookEntity oldBook = bookRepository.findById(bookDTO.getId())
//                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", bookDTO.getId()));
//        BookEntity newBook = BookConverter.toEntity(oldBook, bookDTO);
//        return newBook;
//    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
