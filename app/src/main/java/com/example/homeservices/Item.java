package com.example.homeservices;
public class Item {
    private String name;
    private String mobile;
    private String address;
    private boolean selected;

    public Item(String name, String mobile, String address) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.selected = false;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}