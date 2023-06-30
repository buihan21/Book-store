package com.baitaplon.bookstore.model.converter;

import com.baitaplon.bookstore.model.dto.BookDTO;
import com.baitaplon.bookstore.model.dto.ReviewDTO;
import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.BookEntity;
import com.baitaplon.bookstore.model.entity.ReviewEntity;
import com.baitaplon.bookstore.model.entity.UserEntity;
import com.baitaplon.bookstore.repository.BookRepository;
import com.baitaplon.bookstore.repository.UserRepository;
import com.baitaplon.bookstore.service.IBookService;
import com.baitaplon.bookstore.service.IReviewService;
import com.baitaplon.bookstore.service.IUserService;
import com.baitaplon.bookstore.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {
    public ReviewDTO toDto(ReviewEntity entity) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(entity.getId());
//        dto.setUser(entity.getUser());
//        dto.setBook(entity.getBook());
        dto.setIdBook(entity.getBook().getId());
        dto.setIdUser(entity.getUser().getId());
        dto.setRate(entity.getRate());
        dto.setComment(entity.getComment());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    //private UserConverter userConverter;

    public ReviewEntity toEntity(ReviewDTO dto, UserDTO userDTO, BookDTO bookDTO) {
        ReviewEntity entity = new ReviewEntity();

        UserEntity userEntity = UserConverter.toEntity(userDTO);
        entity.setUser(userEntity);

        BookEntity bookEntity = BookConverter.toEntity(bookDTO);
        entity.setBook(bookEntity);

        entity.setComment(dto.getComment());
        entity.setRate(dto.getRate());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }


}
