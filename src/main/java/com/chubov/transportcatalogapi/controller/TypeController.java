package com.chubov.transportcatalogapi.controller;

import com.chubov.transportcatalogapi.dto.VehicleCategoryDTO;
import com.chubov.transportcatalogapi.dto.VehicleTypeDTO;
import com.chubov.transportcatalogapi.service.VehicleTypeRepositoryService;
import com.chubov.transportcatalogapi.util.Mapper.ModelMapperWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeController {
    //  Type controller
    private final VehicleTypeRepositoryService vehicleTypeRepositoryService;
    private final ModelMapperWrapper modelMapper;

    @Autowired
    public TypeController(VehicleTypeRepositoryService vehicleTypeRepositoryService, ModelMapperWrapper modelMapper) {
        this.vehicleTypeRepositoryService = vehicleTypeRepositoryService;
        this.modelMapper = modelMapper;
    }


    //  Endpoints


    //  About: Endpoint for returning all values of type VehicleCategory from DB
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    List<VehicleTypeDTO> getAll() {
        return vehicleTypeRepositoryService.getAll().stream().map(modelMapper::convertToVehicleTypeDTO).toList();
    }

    //  About: Endpoint for returning one object of type VehicleCategory from DB
    @PostMapping("/get-one")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    VehicleTypeDTO getOne(@RequestBody Long id) {
        return modelMapper.convertToVehicleTypeDTO(vehicleTypeRepositoryService.findById(id));
    }
}
