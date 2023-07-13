package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.Vehicle;

import java.util.List;

public interface VehicleRepositoryService {
    List<Vehicle> getAll();
}
