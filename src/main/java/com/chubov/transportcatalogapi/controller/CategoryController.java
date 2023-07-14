package com.chubov.transportcatalogapi.controller;

import com.chubov.transportcatalogapi.dto.VehicleCategoryDTO;
import com.chubov.transportcatalogapi.dto.VehicleDTO;
import com.chubov.transportcatalogapi.repository.vehicleCategory.VehicleCategoryRepository;
import com.chubov.transportcatalogapi.service.VehicleCategoryRepositoryService;
import com.chubov.transportcatalogapi.util.Mapper.ModelMapperWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    //  Category controller
    private final VehicleCategoryRepositoryService vehicleCategoryRepositoryService;
    private final ModelMapperWrapper modelMapper;

    @Autowired
    public CategoryController(VehicleCategoryRepositoryService vehicleCategoryRepositoryService, ModelMapperWrapper modelMapper) {
        this.vehicleCategoryRepositoryService = vehicleCategoryRepositoryService;
        this.modelMapper = modelMapper;
    }

    //  Endpoints


    //  About: Endpoint for returning all values of type VehicleCategory from DB
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    List<VehicleCategoryDTO> getAll() {
        return vehicleCategoryRepositoryService.getAll().stream().map(modelMapper::convertToVehicleCategoryDTO).toList();
    }

    //  About: Endpoint for returning one object of type VehicleCategory from DB
    @PostMapping("/get-one")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    VehicleCategoryDTO getOne(@RequestBody Long id) {
        return modelMapper.convertToVehicleCategoryDTO(vehicleCategoryRepositoryService.findById(id));
    }
}
