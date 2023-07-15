package com.chubov.transportcatalogapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    //  Сущность описывающая транспорт
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private VehicleCategory category;

    @Column(name = "state_number")
    private String stateNumber;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private VehicleType type;

    @Column(name = "year_of_realise")
    private Integer yearOfRealise;

    @Column(name = "is_has_trailer")
    private Boolean hasTrailer;


    //  Constructors


    public Vehicle(String brand, String model, VehicleCategory category, String stateNumber, VehicleType type, Integer yearOfRealise, Boolean hasTrailer) {
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.stateNumber = stateNumber;
        this.type = type;
        this.yearOfRealise = yearOfRealise;
        this.hasTrailer = hasTrailer;
    }

    //  No args constructor
    public Vehicle() {
    }

    // Equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return Objects.equals(brand, other.brand)
                && Objects.equals(model, other.model)
                && Objects.equals(category, other.category)
                && Objects.equals(stateNumber, other.stateNumber)
                && Objects.equals(type, other.type)
                && Objects.equals(yearOfRealise, other.yearOfRealise)
                && Objects.equals(hasTrailer, other.hasTrailer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, category, stateNumber, type, yearOfRealise, hasTrailer);
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

    public VehicleCategory getCategory() {
        return category;
    }

    public void setCategory(VehicleCategory category) {
        this.category = category;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
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
