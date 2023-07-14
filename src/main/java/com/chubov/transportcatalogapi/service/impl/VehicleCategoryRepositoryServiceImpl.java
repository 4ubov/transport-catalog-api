package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.VehicleCategory;
import com.chubov.transportcatalogapi.repository.vehicleCategory.VehicleCategoryRepository;
import com.chubov.transportcatalogapi.service.VehicleCategoryRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleCategoryRepositoryServiceImpl implements VehicleCategoryRepositoryService {
    //  Vehicle Category Service class (business logic) that implement VehicleCategoryRepositoryService interface
    private final VehicleCategoryRepository categoryRepository;

    @Autowired
    public VehicleCategoryRepositoryServiceImpl(VehicleCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //  Возвращает все объекты класса VehicleCategory из таблицы VehicleCategory
    @Override
    public List<VehicleCategory> getAll() {
        return categoryRepository.findAll();
    }
}
