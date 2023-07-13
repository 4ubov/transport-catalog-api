package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.VehicleCategory;

import java.util.List;

public interface VehicleCategoryRepositoryService {
    List<VehicleCategory> getAll();
}
