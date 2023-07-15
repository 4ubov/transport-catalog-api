package com.chubov.transportcatalogapi.service.impl;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.repository.vehicle.VehicleRepository;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import com.chubov.transportcatalogapi.util.customExeption.EntityAlreadyExist;
import com.chubov.transportcatalogapi.util.customExeption.StateNumberAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VehicleRepositoryServiceImpl implements VehicleRepositoryService {
    //  Vehicle Service class (business logic) that implement VehicleRepositoryService interface

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleRepositoryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    //  Возвращает все объекты класса Vehicle из таблицы Vehicle
    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }


    //  Возвращает все объекты класса Vehicle из таблицы Vehicle, которые соответсвуют фильтрам
    @Override
    public List<Vehicle> filter(Map<String, String> filters) {
        // Проверка, содержит ли фильтр данные
        // Если фильтры отсутствуют, возвращаем все записи
        if (filters.isEmpty()) {
            return vehicleRepository.findAll();
        } else {
            // Выполнение фильтрации с использованием значений фильтров
            return vehicleRepository.findByFilters(filters);
        }
    }

    //  About: Возращает один объект Optional<Vehicle> из бд, выполняя поиск по stateNumber
    @Override
    public Optional<Vehicle> findOneByStateNumber(String stateNumber) {
        return vehicleRepository.findOneByStateNumber(stateNumber);
    }

    //  About: Добавляет новый объек Vehicle в БД
    @Override
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    //  About: Обновляет сущность Vehicle в БД
    @Override
    public void update(Vehicle newVehicle) {
        Optional<Vehicle> oldVehicle = vehicleRepository.findById(newVehicle.getVehicleId());
        if (oldVehicle.isPresent()) {
            //  Проверка на то, если человек отправил не изменённый объект
            if (oldVehicle.get().equals(newVehicle)){
                throw new EntityAlreadyExist("Данный объект уже существует!");
            }
            oldVehicle.get().setBrand(newVehicle.getBrand());
            oldVehicle.get().setModel(newVehicle.getModel());
            oldVehicle.get().setYearOfRealise(newVehicle.getYearOfRealise());

            //  Валидация нового stateNumber, если он не такой же как и раньше и
            //  нашлась сущность с этим номером, то выдать исключение
            Optional<Vehicle> validatedStateNumber = findOneByStateNumber(newVehicle.getStateNumber());
            if (!newVehicle.getStateNumber().equals(oldVehicle.get().getStateNumber()) && validatedStateNumber.isPresent()) {
                throw new StateNumberAlreadyExistsException("Введённый stateNumber уже используется другим транспортом");
            }

            oldVehicle.get().setStateNumber(newVehicle.getStateNumber());
            oldVehicle.get().setHasTrailer(newVehicle.getHasTrailer());
            oldVehicle.get().setType(newVehicle.getType());
            oldVehicle.get().setCategory(newVehicle.getCategory());

            vehicleRepository.save(oldVehicle.get());
        } else {
            throw new EntityNotFoundException("Vehicle with entered id is not found!");
        }
    }

    //  About: Возвращает одну сущность Vehicle в БД по vehicleId
    @Override
    public Vehicle getOneById(Map<String, String> id) {
        System.out.println(id.get("vehicleId"));
        long longId;
        try{
            longId = Long.parseLong(id.get("vehicleId"));
        }
        catch (RuntimeException exception){
            throw new RuntimeException("Entered vehicleId is not correct type, it need be a digit");
        }
        Optional<Vehicle> vehicle = vehicleRepository.findById(longId);
        if (vehicle.isPresent()) {
            return vehicle.get();
        } else {
            throw new EntityNotFoundException("Vehicle Entity with entered id not found!");
        }
    }
}
