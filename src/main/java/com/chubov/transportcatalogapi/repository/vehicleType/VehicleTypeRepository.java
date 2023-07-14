package com.chubov.transportcatalogapi.repository.vehicleType;

import com.chubov.transportcatalogapi.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    //  Repository для работы с данными из БД сущности VehicleType

    //  Метод для поска сущности VehicleType в БД по значнию поля typeName
    Optional<VehicleType> findByTypeName(String name);
}
