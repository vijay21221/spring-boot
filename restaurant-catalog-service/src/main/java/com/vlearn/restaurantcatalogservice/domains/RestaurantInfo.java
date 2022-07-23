package com.vlearn.restaurantcatalogservice.domains;


public class RestaurantInfo {

    private String restaurantId;

    private String restaurantName;

    private String restaurantAddress;

    private Menu menu;

    public RestaurantInfo() {

    }

    public RestaurantInfo(String restaurantId, String restaurantName, String restaurantAddress, Menu menu) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.menu = menu;
    }


    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
}
