package com.baitaplon.bookstore.service.impl;

import com.baitaplon.bookstore.model.converter.ReviewConverter;
import com.baitaplon.bookstore.model.dto.BookDTO;
import com.baitaplon.bookstore.model.dto.ReviewDTO;
import com.baitaplon.bookstore.model.dto.UserDTO;
import com.baitaplon.bookstore.model.entity.BookEntity;
import com.baitaplon.bookstore.model.entity.ReviewEntity;
import com.baitaplon.bookstore.repository.BookRepository;
import com.baitaplon.bookstore.repository.ReviewReponsitory;
import com.baitaplon.bookstore.service.IBookService;
import com.baitaplon.bookstore.service.IReviewService;
import com.baitaplon.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService {

    @Autowired
    private ReviewReponsitory reviewReponsitory;
    @Autowired
    private IUserService userService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private BookRepository bookRepository;

    private ReviewConverter reviewConverter = new ReviewConverter();
    @Override
    public List<ReviewDTO> getByBook(Integer idBook) {
        List<ReviewEntity> entities = reviewReponsitory.getByBookId(idBook);
        List<ReviewDTO> dtoList = new ArrayList<>();
        for (ReviewEntity entity : entities) {
            dtoList.add(reviewConverter.toDto(entity));

        }
        return dtoList;
    }

    @Override
    public List<ReviewDTO> getByUser(Integer idUser) {
        List<ReviewEntity> entities = reviewReponsitory.getByUserId(idUser);
        List<ReviewDTO> dtoList = new ArrayList<>();
        for (ReviewEntity entity : entities) {
            dtoList.add(reviewConverter.toDto(entity));
        }
        return dtoList;
    }

    @Override
    public void saveReview(ReviewDTO reviewDTO) {
        UserDTO userDTO = userService.getById(reviewDTO.getIdUser());
        BookDTO bookDTO = bookService.findOne(reviewDTO.getIdBook());
        ReviewEntity entity = reviewConverter.toEntity(reviewDTO, userDTO, bookDTO);
        reviewReponsitory.save(entity);
    }
}
