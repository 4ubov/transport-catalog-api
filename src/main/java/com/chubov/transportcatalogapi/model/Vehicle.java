package com.chubov.transportcatalogapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    //  Сущность описывающая Автомобиль

    @Id
    @Column(name = "vehicle_id")
    Long vehicleId;

    @Column(name = "brand")
    String brand;

    @Column(name = "model")
    String model;

    @ManyToOne(fetch = FetchType.LAZY)
    VehicleCategory transportCategory;

    @Column(name = "state_number")
    String stateNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    VehicleType transportType;

    @Column(name = "year_of_realise")
    Integer yearOfRealise;

    @Column(name = "is_has_trailer")
    boolean isHasTrailer;


    //  Constructors

    public Vehicle(String brand, String model, VehicleCategory transportCategory, String stateNumber,
                   VehicleType transportType, Integer yearOfRealise, boolean isHasTrailer) {
        this.brand = brand;
        this.model = model;
        this.transportCategory = transportCategory;
        this.stateNumber = stateNumber;
        this.transportType = transportType;
        this.yearOfRealise = yearOfRealise;
        this.isHasTrailer = isHasTrailer;
    }

    //  No args constructor
    public Vehicle() {
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

    public VehicleCategory getTransportCategory() {
        return transportCategory;
    }

    public void setTransportCategory(VehicleCategory transportCategory) {
        this.transportCategory = transportCategory;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public VehicleType getTransportType() {
        return transportType;
    }

    public void setTransportType(VehicleType transportType) {
        this.transportType = transportType;
    }

    public Integer getYearOfRealise() {
        return yearOfRealise;
    }

    public void setYearOfRealise(Integer yearOfRealise) {
        this.yearOfRealise = yearOfRealise;
    }

    public boolean isHasTrailer() {
        return isHasTrailer;
    }

    public void setHasTrailer(boolean hasTrailer) {
        isHasTrailer = hasTrailer;
    }
}
