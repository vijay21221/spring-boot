package com.vlearn.restaurantcatalogservice.domains;

import java.util.List;

public class RestaurantCatalog {
    private String username;

    private String userId;

    private List<CatalogItem> catalogItems;

    public RestaurantCatalog(String username, String userId, List catalogItems) {
        this.username = username;
        this.userId = userId;
        this.catalogItems = catalogItems;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

    public void setCatalogItems(List<CatalogItem> catalogItems) {
        this.catalogItems = catalogItems;
    }
}
