package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface VehicleRepositoryService {
    //  Интерфейс для описания методов сервиса (VehicleRepositoryService)

    //  Метод для вывода всех значений
    List<Vehicle> getAll();

    //  Метод для вывода отфильтрованных значений
    List<Vehicle> filter(Map<String, String> filters);

    Optional<Vehicle> findOneByStateNumber(String stateNumber);

    void save(Vehicle vehicle);
}
