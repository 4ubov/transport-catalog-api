package com.chubov.transportcatalogapi.repository.vehicle;

import com.chubov.transportcatalogapi.model.Vehicle;

import java.util.List;
import java.util.Map;

public interface CustomizedVehicleFilter {
    //  Интерфейс для описания кастомного метода фильтрации в Vehicle репозитори

    //  Кастомный метод для фильтрации на основе выбранных фильтров
    List<Vehicle> findByFilters(Map<String, String> filters);
}

