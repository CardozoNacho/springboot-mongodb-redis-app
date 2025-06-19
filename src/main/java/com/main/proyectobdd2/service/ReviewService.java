package com.main.proyectobdd2.service;


import com.main.proyectobdd2.model.Review;
import com.main.proyectobdd2.repository.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieReviewService movieReviewService;


    public List<Review> getReviewsByReviewId(ObjectId id) {
        Review review = reviewRepository.findById(id);
        if (review == null) return List.of();
        ObjectId movieId = review.getMovieId();
        return movieReviewService.getReviewsByMovieId(movieId); // ✅ esto pasa por el proxy
    }

    public Review save(Review review){
        return reviewRepository.save(review);
    }

//    @Cacheable("BddCrud")
//    public Review get(ObjectId id){
//        return reviewRepository.findById(id);
//    }
@Cacheable("BddCrud")
public Review get(ObjectId id) {
    Review review = reviewRepository.findById(id);

    if (review != null) {
        // 🔥 Esto activa el cache de todas las reviews de la película
        movieReviewService.getReviewsByMovieId(review.getMovieId());
    }

    return review;
}


    @CacheEvict(value = "BddCrud", allEntries = true)
    public Review update(ObjectId id, Review review){
        review.setId(id);
        return reviewRepository.save(review);
    }

    @CacheEvict(value = "BddCrud", allEntries = true)
    public void delete(ObjectId id){
        reviewRepository.deleteById(id);
    }
}
