package com.vlearn.restaurantratingservice.domains;

public class Rating {

    private String restaurantId;

    private int rating;

    public Rating(String restaurantId, int rating) {
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
