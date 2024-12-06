package com.example.company.Company.Controller;

import com.example.company.Company.Entiry.Review;
import com.example.company.Company.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    @Autowired
    ReviewService service;

    @GetMapping("/reviews")
    public List<Review> getAll(@PathVariable Long companyId) {
       return service.getAllReviews(companyId);
    }
    @GetMapping("/reviews/{reviewId}")
    public Review getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return service.getReview(companyId, reviewId);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> Add(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isReviewSaved =
                service.addReview(companyId, review);
        if (isReviewSaved)
            return new ResponseEntity<>("added Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("added Not Successfully", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> update(@PathVariable Long companyId, @PathVariable Long reviewId,
                                         @RequestBody Review review){
        boolean reviewUpdated = service.update(companyId,reviewId,review);
        if(reviewUpdated)
            return new ResponseEntity<>("updated successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Incorrect update",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> delete(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean reviewdeleted = service.delete(companyId,reviewId);
        if(reviewdeleted)
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Incorrect",HttpStatus.NOT_FOUND);
    }
}