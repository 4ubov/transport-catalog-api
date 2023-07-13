package com.chubov.transportcatalogapi.repository;

import com.chubov.transportcatalogapi.model.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long> {
    //  Repository для работы с данными из БД сущности VehicleCategory
    Optional<VehicleCategory> findByCategoryName(String value);
}
