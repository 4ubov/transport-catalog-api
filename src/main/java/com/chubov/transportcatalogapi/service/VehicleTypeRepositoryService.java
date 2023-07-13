package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleTypeRepositoryService {
    List<VehicleType> getAll();
}
