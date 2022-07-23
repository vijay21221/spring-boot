package com.vlearn.restaurantcatalogservice.domains;

import java.util.List;

public class Menu {

    private String menuId;

    private List<String> menuItems;

    public Menu() {

    }

    public Menu(String menuId, List<String> menuItems) {
        this.menuId = menuId;
        this.menuItems = menuItems;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public List<String> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<String> menuItems) {
        this.menuItems = menuItems;
    }
}
