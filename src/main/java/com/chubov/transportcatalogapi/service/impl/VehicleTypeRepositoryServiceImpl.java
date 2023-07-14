package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.VehicleType;
import com.chubov.transportcatalogapi.repository.vehicleType.VehicleTypeRepository;
import com.chubov.transportcatalogapi.service.VehicleTypeRepositoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeRepositoryServiceImpl implements VehicleTypeRepositoryService {
    //  Vehicle Type Service class (business logic) that implement VehicleTypeRepositoryService interface

    private final VehicleTypeRepository typeRepository;

    @Autowired
    public VehicleTypeRepositoryServiceImpl(VehicleTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    //  Возвращает все объекты класса VehicleType из таблицы VehicleType
    @Override
    public List<VehicleType> getAll() {
        return typeRepository.findAll();
    }


    //  Возвращает объект VehicleType если найден в БД по typeName
    @Override
    public Optional<VehicleType> getOneByTypeName(String type) {
        Optional<VehicleType> vehicleType = typeRepository.findByTypeName(type);
        if(vehicleType.isPresent()){
            return vehicleType;
        }
        else{
            throw new EntityNotFoundException("VehicleType Entity with entered name not found!");
        }
    }
}
