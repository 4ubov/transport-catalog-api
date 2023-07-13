package com.chubov.transportcatalogapi.repository.impl;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.model.VehicleCategory;
import com.chubov.transportcatalogapi.model.VehicleType;
import com.chubov.transportcatalogapi.repository.CustomizedVehicleFilter;
import com.chubov.transportcatalogapi.repository.VehicleCategoryRepository;
import com.chubov.transportcatalogapi.repository.VehicleTypeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class VehicleRepositoryImpl implements CustomizedVehicleFilter {
    //  Repository для работы с данными из БД сущности Vehicle

    private final VehicleCategoryRepository categoryRepository;
    private final VehicleTypeRepository typeRepository;

    @Autowired
    public VehicleRepositoryImpl(VehicleCategoryRepository categoryRepository, VehicleTypeRepository typeRepository) {
        this.categoryRepository = categoryRepository;
        this.typeRepository = typeRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    //  Реализация фильтрации
    //  {
    //      "category" : "D",
    //      "type" : "Седан"
    //  }
    @Override
    public List<Vehicle> findByFilters(Map<String, String> filters) {

        // Формирование запроса с учетом переданных значений фильтров
        String queryBuilder = "SELECT v FROM Vehicle v WHERE 1=1";

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            if (fieldName.equals("category")) {
                Optional<VehicleCategory> vehicleCategory = categoryRepository.findByCategoryName(value);
                if (vehicleCategory.isPresent()) {
                    value = vehicleCategory.get().getCategoryId().toString();
                    filters.put(fieldName, value);
                } else {
                    //  Обработать ошибку надо что нет такого объекта в бд
                    throw new EntityNotFoundException();
                }
                queryBuilder += " AND v.category.categoryId = :category";
            } else if (fieldName.equals("type")) {
                Optional<VehicleType> vehicleType = typeRepository.findByTypeName(value);
                if (vehicleType.isPresent()) {
                    value = vehicleType.get().getTypeId().toString();
                    filters.put(fieldName, value);
                } else {
                    //  Обработать ошибку надо что нет такого объекта в бд
                    throw new EntityNotFoundException();
                }
                queryBuilder += " AND v.type.typeId = :type";
            } else {
                queryBuilder += " AND v." + fieldName + " = :" + fieldName;
            }
        }

        // Создание запроса и применение значений фильтров

        TypedQuery<Vehicle> typedQuery = entityManager.createQuery(queryBuilder, Vehicle.class);

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            if (fieldName.equals("category") || fieldName.equals("type") || fieldName.equals("yearOfRealise")) {
                typedQuery.setParameter(fieldName, Integer.parseInt(value));
            } else if (fieldName.equals("hasTrailer")) {
                typedQuery.setParameter(fieldName, Boolean.parseBoolean(value));
            } else {
                typedQuery.setParameter(fieldName, value);
            }
        }

        return typedQuery.getResultList();
    }

}
