package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.VehicleType;

import java.util.List;

public interface VehicleTypeRepositoryService {
    List<VehicleType> getAll();
}
