package com.sew.rewardsapp.pojo;

import com.sew.rewardsapp.enums.Category;

/**
 * Created by siddharthkumar on 22/1/18.
 */

public class RewardItem {

    private String id;
    private String name;
    private Category category;
    private ItemType itemType;
    private Double price;
    private Double maxDiscount;
    private String description;
    private String imageName;


    public RewardItem(String name, Double price, ItemType itemType, String imageName) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.imageName = imageName;
    }

    public RewardItem(String id, String name, Category category, Double price, ItemType itemType, Double maxDiscount, String description, String imageName) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.itemType = itemType;
        this.maxDiscount = maxDiscount;
        this.description = description;
        this.imageName = imageName;
    }

    public RewardItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
