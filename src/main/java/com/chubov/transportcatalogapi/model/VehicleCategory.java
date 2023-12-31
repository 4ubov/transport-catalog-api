package com.chubov.transportcatalogapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_category")
public class VehicleCategory {
    //  Сущность описывающая Категорию транспорта

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    Long categoryId;

    @Column(name = "category_name")
    String categoryName;


    //  Constructors

    public VehicleCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    //  No args constructor
    public VehicleCategory() {
    }


    //  Getter and Setter

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
