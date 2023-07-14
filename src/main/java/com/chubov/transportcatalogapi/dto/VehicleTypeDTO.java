package com.chubov.transportcatalogapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class VehicleTypeDTO {
    //  DTO для сущности VehicleType

    @NotNull(message = "Должно присутствовать поле typeName!")
    @NotEmpty(message = "Поле typeName не должно быть пустым! Example: Седан")
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
