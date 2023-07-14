package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.VehicleCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleCategoryRepositoryService {
    //  Интерфейс для описания методов сервиса (VehicleCategoryRepositoryService)

    //  Метод для вывода всех значений
    List<VehicleCategory> getAll();
}
