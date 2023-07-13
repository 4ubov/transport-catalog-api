package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.repository.VehicleCategoryRepository;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleCategoryRepositoryServiceImpl implements VehicleRepositoryService {
    //  Vehicle Category Service class (business logic)

    private final VehicleCategoryRepository categoryRepository;

    @Autowired
    public VehicleCategoryRepositoryServiceImpl(VehicleCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Vehicle> getAll() {
        return null;
    }
}
