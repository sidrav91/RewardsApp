package com.sew.rewardsapp.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.sew.rewardsapp.enums.Category;

/**
 * Created by siddharthkumar on 22/1/18.
 */

public class RewardItem implements Parcelable{

    private String id;
    private String name;
    private Category category;
    private ItemType itemType;
    private Double price;
    private Double maxDiscount;
    private String description;
    private Integer imageResource;


    public RewardItem(String name, Double price, ItemType itemType, Integer imageName) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.imageResource = imageName;
    }

    public RewardItem(String id, String name, Category category, Double price, ItemType itemType, Double maxDiscount, String description, Integer imageName) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.itemType = itemType;
        this.maxDiscount = maxDiscount;
        this.description = description;
        this.imageResource = imageName;
    }

    public RewardItem() {
    }

    public static final Creator<RewardItem> CREATOR = new Creator<RewardItem>() {
        @Override
        public RewardItem createFromParcel(Parcel in) {
            return new RewardItem(in);
        }

        @Override
        public RewardItem[] newArray(int size) {
            return new RewardItem[size];
        }
    };

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

    public Integer getImageResource() {
        return imageResource;
    }

    public void setImageResource(Integer imageResource) {
        this.imageResource = imageResource;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "RewardItem{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", itemType=" + itemType +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(category.toString());
        parcel.writeDouble(price);
        parcel.writeString(itemType.toString());
        parcel.writeDouble(maxDiscount);
        parcel.writeString(description);
        parcel.writeInt(imageResource);
    }

    public RewardItem(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.category = Category.valueOf(in.readString());
        this.price = in.readDouble();
        this.itemType = ItemType.valueOf(in.readString());
        this.maxDiscount = in.readDouble();
        this.description = in.readString();
        this.imageResource = in.readInt();
    }
}
