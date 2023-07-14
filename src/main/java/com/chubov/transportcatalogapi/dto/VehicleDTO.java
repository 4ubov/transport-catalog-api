package com.chubov.transportcatalogapi.dto;

import com.chubov.transportcatalogapi.model.VehicleCategory;
import com.chubov.transportcatalogapi.model.VehicleType;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class VehicleDTO {
    //  DTO для сущности Vehicle
    private String brand;

    private String model;

    private String categoryName;

    private String stateNumber;

    private String typeName;

    private Integer yearOfRealise;

    private Boolean hasTrailer;


    //  Constructors

    public VehicleDTO(String brand, String model, String categoryName, String stateNumber, String typeName, Integer yearOfRealise, Boolean hasTrailer) {
        this.brand = brand;
        this.model = model;
        this.categoryName = categoryName;
        this.stateNumber = stateNumber;
        this.typeName = typeName;
        this.yearOfRealise = yearOfRealise;
        this.hasTrailer = hasTrailer;
    }

    //  No args constructor
    public VehicleDTO() {
    }


    //  Getter and Setter


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getYearOfRealise() {
        return yearOfRealise;
    }

    public void setYearOfRealise(Integer yearOfRealise) {
        this.yearOfRealise = yearOfRealise;
    }

    public Boolean getHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(Boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }
}
