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

    //  Метод возвращает Optional<Vehicle> при условии что нашолся с таким stateNumber
    Optional<Vehicle> findOneByStateNumber(String stateNumber);

    //  Метод выполняет добавление Vehicle в БД
    void save(Vehicle vehicle);

    //  Метод выполняет обновление Vehicle в БД
    void update(Vehicle newVehicle);

    //  Метод выполняет поиск одного Vehicle в БД по vehicleId
    Vehicle getOneById(Map<String, String> id);
}
