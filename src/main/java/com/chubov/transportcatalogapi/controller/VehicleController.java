package com.chubov.transportcatalogapi.controller;

import com.chubov.transportcatalogapi.dto.VehicleDTO;
import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import com.chubov.transportcatalogapi.util.Mapper.ModelMapperWrapper;
import com.chubov.transportcatalogapi.util.customExeption.VehicleNotCreatedException;
import com.chubov.transportcatalogapi.util.validator.UniqueVehicleValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehicle/")
public class VehicleController {
    //  Vehicle controller

    private final VehicleRepositoryService vehicleRepositoryService;

    private final ModelMapperWrapper modelMapper;
    private final UniqueVehicleValidator validator;

    @Autowired
    public VehicleController(VehicleRepositoryService vehicleRepositoryService, ModelMapperWrapper modelMapper, UniqueVehicleValidator validator) {
        this.vehicleRepositoryService = vehicleRepositoryService;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    //  Endpoints


    //  About: Endpoint for returning all values of type List<Vehicle> from DB
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    List<VehicleDTO> getAll() {
        return vehicleRepositoryService.getAll().stream().map(modelMapper::convertToVehicleDTO).toList();
    }

    //  About: Endpoint for returning one object of type Vehicle from DB
    //  {
    //      "vehicleId":3
    //  }
    @PostMapping("/get-one")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    VehicleDTO getOne(@RequestBody Map<String, String> id) {
        return modelMapper.convertToVehicleDTO(vehicleRepositoryService.getOneById(id));
    }

    //  About: Endpoint for add new Vehicle to DB
    //  Exception checking included
    @PostMapping("/add")
    ResponseEntity<HttpStatus> addVehicle(@RequestBody @Valid VehicleDTO vehicleDTO, BindingResult bindingResult) {
        //  Converting from vehicleDto to vehicle and ...
        //  Checking this object by a unique state number in the database. Using UniqueVehicleValidator
        vehicleDTO.setVehicleId(null);
        Vehicle vehicle = modelMapper.convertToVehicleCustom(vehicleDTO);
        validator.validate(vehicle, bindingResult);

        //  Обработка ошибок связанных с валидацией данных
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append("; ");
            }
            //  Этот exception перехватиться GlobalExceptionHandler и выведит кастомный ответ
            throw new VehicleNotCreatedException(errorMessage.toString());
        }

        //  Добваление нового транспорта в БД
        vehicleRepositoryService.save(vehicle);

        //  Status-code: 200 при успешном добавлении транспорта в БД
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    //  About: Endpoint to update machine data in DB
    //  Exception checking included
    @PutMapping("/update")
    ResponseEntity<HttpStatus> update(@RequestBody @Valid VehicleDTO vehicleDTO, BindingResult bindingResult) {
        //  Converting from vehicleDto to vehicle and ...
        Vehicle newVehicle = modelMapper.convertToVehicleCustom(vehicleDTO);

        //  Обработка ошибок связанных с валидацией данных
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append("; ");
            }
            //  Этот exception перехватиться GlobalExceptionHandler и выведит кастомный ответ
            throw new VehicleNotCreatedException(errorMessage.toString());
        }

        //  Добваление обновление транспортного ср-ва в БД
        vehicleRepositoryService.update(newVehicle);

        //  Status-code: 200 при успешном обновлении транспорта в БД
        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    //  About: Endpoint for returning filtered values of type List<VehicleDTO> fromDB
    //  Example json Input:
    //  Map<String, String> filters
    //  {
    //      "category" : "D",
    //      "type" : "Седан"
    //  }
    @PostMapping("/filter")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<VehicleDTO> filter(@RequestBody Map<String, String> filters) {
        return vehicleRepositoryService.filter(filters).stream().map(modelMapper::convertToVehicleDTO).collect(Collectors.toList());
    }


}
