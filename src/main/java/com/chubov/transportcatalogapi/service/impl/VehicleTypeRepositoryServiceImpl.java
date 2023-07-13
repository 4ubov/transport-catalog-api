package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.VehicleType;
import com.chubov.transportcatalogapi.repository.VehicleTypeRepository;
import com.chubov.transportcatalogapi.service.VehicleTypeRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleTypeRepositoryServiceImpl implements VehicleTypeRepositoryService {
    //  Vehicle Type Service class (business logic)

    private final VehicleTypeRepository typeRepository;

    @Autowired
    public VehicleTypeRepositoryServiceImpl(VehicleTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<VehicleType> getAll() {
        return typeRepository.findAll();
    }
}
