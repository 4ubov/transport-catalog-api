package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleTypeRepositoryService {
    //  Интерфейс для описания методов сервиса (VehicleTypeRepositoryService)

    //  Метод для вывода всех значений
    List<VehicleType> getAll();
}
