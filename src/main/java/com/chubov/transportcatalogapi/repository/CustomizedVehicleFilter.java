package com.chubov.transportcatalogapi.repository;

import com.chubov.transportcatalogapi.model.Vehicle;

import java.util.List;
import java.util.Map;

public interface CustomizedVehicleFilter {
    List<Vehicle> findByFilters(Map<String, String> filters);
}

