package com.chubov.transportcatalogapi.repository;

import com.chubov.transportcatalogapi.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    //  Repository для работы с данными из БД сущности Vehicle
}
