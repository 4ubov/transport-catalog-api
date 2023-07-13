package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.VehicleCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleCategoryRepositoryService {
    List<VehicleCategory> getAll();
}
