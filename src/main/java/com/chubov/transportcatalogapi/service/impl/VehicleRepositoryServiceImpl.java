package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.repository.VehicleRepository;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepositoryServiceImpl implements VehicleRepositoryService {
    //  Vehicle Service class (business logic)

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleRepositoryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> filter(Map<String, String> filters) {
        // Проверка, содержит ли фильтр данные
        if (filters.isEmpty()) {
            return vehicleRepository.findAll(); // Если фильтры отсутствуют, возвращаем все записи
        } else {
            // Выполнение фильтрации с использованием значений фильтров
            return vehicleRepository.findByFilters(filters);
        }


    }
}
