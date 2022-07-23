package com.vlearn.restaurantcatalogservice.domains;

import java.util.List;

public class RatingInfo {

    private String userId;

    private List<Rating> ratingList;

    public RatingInfo() {

    }


    public RatingInfo(String userId, List<Rating> ratingList) {
        this.userId = userId;
        this.ratingList = ratingList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }


}
