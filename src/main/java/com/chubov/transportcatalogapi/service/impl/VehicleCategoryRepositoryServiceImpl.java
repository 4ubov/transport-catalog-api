package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.VehicleCategory;
import com.chubov.transportcatalogapi.model.VehicleType;
import com.chubov.transportcatalogapi.repository.vehicleCategory.VehicleCategoryRepository;
import com.chubov.transportcatalogapi.service.VehicleCategoryRepositoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    //  Возвращает объект VehicleCategory если найден в БД по categoryName
    @Override
    public Optional<VehicleCategory> getOneByCategoryName(String type) {
        Optional<VehicleCategory> vehicleCategory = categoryRepository.findByCategoryName(type);
        if(vehicleCategory.isPresent()){
            return vehicleCategory;
        }
        else{
            throw new EntityNotFoundException("VehicleCategory Entity with entered name not found!");
        }
    }

    //  Возвращает объект VehicleCategory если найден в БД по categoryId
    @Override
    public VehicleCategory findById(Long id) {
        Optional<VehicleCategory> vehicleCategory = categoryRepository.findById(id);
        if(vehicleCategory.isPresent()){
            return vehicleCategory.get();
        }
        else{
            throw new EntityNotFoundException("VehicleCategory Entity with entered ID not found!");
        }
    }
}
