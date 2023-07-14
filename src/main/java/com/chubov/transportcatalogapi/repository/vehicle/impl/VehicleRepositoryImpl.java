package com.chubov.transportcatalogapi.repository.vehicle.impl;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.model.VehicleCategory;
import com.chubov.transportcatalogapi.model.VehicleType;
import com.chubov.transportcatalogapi.repository.vehicle.CustomizedVehicleFilter;
import com.chubov.transportcatalogapi.repository.vehicleCategory.VehicleCategoryRepository;
import com.chubov.transportcatalogapi.repository.vehicleType.VehicleTypeRepository;
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

    //  Реализация метода фильтрации
    //  Example Input:
    //  Map<String, String> filters
    //  {
    //      "category" : "D",
    //      "type" : "Седан"
    //  }
    @Override
    public List<Vehicle> findByFilters(Map<String, String> filters) {

        // Формирование составного запроса с учетом переданных значений фильтров
        String query = "SELECT v FROM Vehicle v WHERE 1=1";

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            //  Частные случании для связных сущностей (VehicleCategory, VehicleType)
            if (fieldName.equals("category")) {
                //  Код для маппинга из categoryName to categoryId для будущей фильтрации
                //  From input : "category" : "D"  --> to "category" : "4"
                Optional<VehicleCategory> vehicleCategory = categoryRepository.findByCategoryName(value);
                if (vehicleCategory.isPresent()) {
                    value = vehicleCategory.get().getCategoryId().toString();
                    filters.put(fieldName, value);
                } else {
                    //  Обработать ошибку надо что нет такого объекта в бд
                    throw new EntityNotFoundException();
                }
                query += " AND v.category.categoryId = :category";

            } else if (fieldName.equals("type")) {
                //  Код для маппинга из categoryName to categoryId для будущей фильтрации
                //  From input : "type" : "Седан"  --> to "type" : "2"
                Optional<VehicleType> vehicleType = typeRepository.findByTypeName(value);
                if (vehicleType.isPresent()) {
                    value = vehicleType.get().getTypeId().toString();
                    filters.put(fieldName, value);
                } else {
                    //  Обработать ошибку надо что нет такого объекта в бд
                    throw new EntityNotFoundException();
                }
                query += " AND v.type.typeId = :type";

            } else {
                //  Добавление составного запроса для обыных полей (не связых сущностей)
                query += " AND v." + fieldName + " = :" + fieldName;
            }
        }

        // Создание составного запроса и применение значений фильтров

        TypedQuery<Vehicle> typedQuery = entityManager.createQuery(query, Vehicle.class);

        //  Подстановка значений полей в составной запрос
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            typedQuery.setParameter(fieldName, value);
        }

        return typedQuery.getResultList();
    }

}
