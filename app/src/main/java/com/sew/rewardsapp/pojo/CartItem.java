package com.sew.rewardsapp.pojo;

/**
 * Created by siddharthkumar on 31/1/18.
 */

public class CartItem {

    private String name;
    private Double purchasePrice;
    private Integer imageResource;
    private Integer pointsUsed;

    public CartItem(String name, Double purchasePrice, Integer imageResource, Integer pointsUsed) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.imageResource = imageResource;
        this.pointsUsed = pointsUsed;
    }

    public CartItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getImageResource() {
        return imageResource;
    }

    public void setImageResource(Integer imageResource) {
        this.imageResource = imageResource;
    }

    public Integer getPointsUsed() {
        return pointsUsed;
    }

    public void setPointsUsed(Integer pointsUsed) {
        this.pointsUsed = pointsUsed;
    }
}
