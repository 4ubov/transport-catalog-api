package com.chubov.transportcatalogapi.repository.vehicle;

import com.chubov.transportcatalogapi.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>, CustomizedVehicleFilter {
    //  Repository для работы с данными из БД сущности Vehicle

    //  About: Возращает один объект Optional<Vehicle> из бд, выполняя поиск по stateNumber
    Optional<Vehicle> findOneByStateNumber(String stateNumber);

}
