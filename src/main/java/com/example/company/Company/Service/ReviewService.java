package com.example.company.Company.Service;

import com.example.company.Company.Entiry.Company;
import com.example.company.Company.Entiry.Review;
import com.example.company.Company.Inter.ReviewInter;
import com.example.company.Company.Repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements ReviewInter {
    @Autowired
    ReviewRepo repo;
    @Autowired
    CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return repo.findBycompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getAllById(companyId);
        if(company != null) {
            review.setCompany(company);
            repo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = repo.findBycompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean update(Long companyId, Long reviewId, Review review) {
        if(companyService.getAllById(companyId)!=null){
            review.setCompany(companyService.getAllById(companyId));
            review.setId(reviewId);
            repo.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean delete(Long companyId, Long reviewId) {
        if (companyService.getAllById(companyId) != null && repo.existsById(reviewId)) {
            Review review = repo.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(company, companyId);
            repo.deleteById(reviewId);
            return true;
        } else {
            return false;
        }
     }
    }

