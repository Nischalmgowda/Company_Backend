package com.example.company.Company.Inter;

import com.example.company.Company.Entiry.Review;

import java.util.List;

public interface ReviewInter {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);

    Review getReview(Long CompanyId,Long reviewId);
    public boolean update(Long companyId,Long reviewId,Review review);

    boolean delete(Long companyId, Long reviewId);
}
