package com.chubov.transportcatalogapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {
    //  Сущность описывающая Категорию транспорта

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    Long typeId;

    @Column(name = "type_name")
    String typeName;


    //  Constructors
    public VehicleType(String typeName) {
        this.typeName = typeName;
    }

    //  No args constructor
    public VehicleType() {
    }


    //  Getter and Setter


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
