package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.VehicleCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VehicleCategoryRepositoryService {
    //  Интерфейс для описания методов сервиса (VehicleCategoryRepositoryService)

    //  Метод для вывода всех значений
    List<VehicleCategory> getAll();

    //  Метод для возвращения сущности при условии что найдено по categoryName
    Optional<VehicleCategory> getOneByCategoryName(String category);
}
