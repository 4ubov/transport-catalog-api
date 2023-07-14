package com.chubov.transportcatalogapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.stereotype.Component;

@Component
public class VehicleDTO {
    //  DTO для сущности Vehicle

    private Long vehicleId;
    @NotNull(message = "Должно присутствовать поле brand!")
    @NotEmpty(message = "Поле brand не должно быть пустым! Example: BWM")
    private String brand;

    @NotNull(message = "Должно присутствовать поле model!")
    @NotEmpty(message = "Поле model не должно быть пустым! Example: M3")
    private String model;

    @NotNull(message = "Должно присутствовать поле category!")
    @NotEmpty(message = "Поле category не должно быть пустым! Example: A")
    private String category;

    @NotNull(message = "Должно присутствовать поле stateNumber!")
    @NotEmpty(message = "Поле brand не должно быть пустым! Example: А111АА58")
    private String stateNumber;

    @NotNull(message = "Должно присутствовать поле type!")
    @NotEmpty(message = "Поле brand не должно быть пустым! Example: Седан")
    private String type;

    @NotNull(message = "Должно присутствовать поле yearOfRealise!")
    private Integer yearOfRealise;

    @NotNull(message = "Должно присутствовать поле hasTrailer!")
    private Boolean hasTrailer;


    //  Constructors


    public VehicleDTO(Long vehicleId, String brand, String model, String category, String stateNumber, String type, Integer yearOfRealise, Boolean hasTrailer) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.stateNumber = stateNumber;
        this.type = type;
        this.yearOfRealise = yearOfRealise;
        this.hasTrailer = hasTrailer;
    }

    //  No args constructor
    public VehicleDTO() {
    }


    //  Getter and Setter


    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
