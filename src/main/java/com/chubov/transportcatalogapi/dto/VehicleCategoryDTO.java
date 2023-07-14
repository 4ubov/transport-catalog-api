package com.chubov.transportcatalogapi.dto;

import org.springframework.stereotype.Component;

@Component
public class VehicleCategoryDTO {
    //  DTO для сущности VehicleCategory

    String categoryName;


    //  Constructors

    public VehicleCategoryDTO(String categoryName) {
        this.categoryName = categoryName;
    }

    //  No args constructor
    public VehicleCategoryDTO() {
    }


    //  Getter and Setter

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
