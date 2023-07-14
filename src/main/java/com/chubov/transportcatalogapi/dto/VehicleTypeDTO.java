package com.chubov.transportcatalogapi.dto;

import org.springframework.stereotype.Component;

@Component
public class VehicleTypeDTO {
    //  DTO для сущности VehicleType

    String typeName;


    //  Constructors
    public VehicleTypeDTO(String typeName) {
        this.typeName = typeName;
    }

    //  No args constructor
    public VehicleTypeDTO() {
    }


    //  Getter and Setter


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
