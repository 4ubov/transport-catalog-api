package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.repository.VehicleRepository;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleRepositoryServiceImpl implements VehicleRepositoryService {
    //  Vehicle Service class (business logic)

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleRepositoryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAll() {
        return null;
    }
}
