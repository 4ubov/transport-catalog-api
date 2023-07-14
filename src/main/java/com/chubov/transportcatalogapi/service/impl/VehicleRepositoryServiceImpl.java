package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.repository.vehicle.VehicleRepository;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VehicleRepositoryServiceImpl implements VehicleRepositoryService {
    //  Vehicle Service class (business logic) that implement VehicleRepositoryService interface

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleRepositoryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    //  Возвращает все объекты класса Vehicle из таблицы Vehicle
    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }


    //  Возвращает все объекты класса Vehicle из таблицы Vehicle, которые соответсвуют фильтрам
    @Override
    public List<Vehicle> filter(Map<String, String> filters) {
        // Проверка, содержит ли фильтр данные
        // Если фильтры отсутствуют, возвращаем все записи
        if (filters.isEmpty()) {
            return vehicleRepository.findAll();
        } else {
            // Выполнение фильтрации с использованием значений фильтров
            return vehicleRepository.findByFilters(filters);
        }
    }

    //  About: Возращает один объект Optional<Vehicle> из бд, выполняя поиск по stateNumber
    @Override
    public Optional<Vehicle> findOneByStateNumber(String stateNumber) {
        return vehicleRepository.findOneByStateNumber(stateNumber);
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
