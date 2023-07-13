package com.chubov.transportcatalogapi.repository;

import com.chubov.transportcatalogapi.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    //  Repository для работы с данными из БД сущности VehicleType
}
