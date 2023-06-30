package com.baitaplon.bookstore.service;

import com.baitaplon.bookstore.model.dto.ReviewDTO;

import java.util.List;

public interface IReviewService {
    List<ReviewDTO> getByBook(Integer idBook);
    List<ReviewDTO> getByUser(Integer idUser);

    void saveReview(ReviewDTO reviewDTO);
}
