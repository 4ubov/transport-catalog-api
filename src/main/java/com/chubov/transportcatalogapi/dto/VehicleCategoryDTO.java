package com.chubov.transportcatalogapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class VehicleCategoryDTO {
    //  DTO для сущности VehicleCategory

    @NotNull(message = "Должно присутствовать поле categoryName!")
    @NotEmpty(message = "Поле categoryName не должно быть пустым! Example: C")
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
