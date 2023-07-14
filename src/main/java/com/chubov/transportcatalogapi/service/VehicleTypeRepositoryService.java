package com.chubov.transportcatalogapi.service;

import com.chubov.transportcatalogapi.model.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VehicleTypeRepositoryService {
    //  Интерфейс для описания методов сервиса (VehicleTypeRepositoryService)

    //  Метод для вывода всех значений
    List<VehicleType> getAll();

    //  Метод для возвращения сущности при условии что найдено по typeName
    Optional<VehicleType> getOneByTypeName(String type);

    //  Метод для возвращения сущности при условии что найдено по typeId
    VehicleType findById(Long id);
}
