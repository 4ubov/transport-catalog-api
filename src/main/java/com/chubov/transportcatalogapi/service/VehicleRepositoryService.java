package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface VehicleRepositoryService {
    List<Vehicle> getAll();

    List<Vehicle> filter(Map<String, String> filters);
}
