package com.baitaplon.bookstore.controller.web;

import com.baitaplon.bookstore.model.dto.ReviewDTO;
import com.baitaplon.bookstore.model.entity.ReviewEntity;
import com.baitaplon.bookstore.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReviewApi {
    @Autowired
    private IReviewService reviewService;

    @GetMapping("/review/book/{idBook}")
    public List<ReviewDTO> getReviewByBook(@PathVariable(name = "idBook") String idBook) {
        List<ReviewDTO> listReview = reviewService.getByBook(Integer.valueOf(idBook));
        return listReview;
    }
    @GetMapping("/review/user/{idUser}")
    public List<ReviewDTO> getReviewByUser(@PathVariable(name = "idUser") String idUser) {
        List<ReviewDTO> listReview = reviewService.getByUser(Integer.valueOf(idUser));
        return listReview;
    }
    @PostMapping("/review")
    public void postReview(@RequestBody ReviewDTO reviewDTO) {
        reviewService.saveReview(reviewDTO);
    }
}
