package com.chubov.transportcatalogapi.controller;

import com.chubov.transportcatalogapi.dto.VehicleDTO;
import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VehicleController {
    //  Main controller

    private final VehicleRepositoryService vehicleRepositoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public VehicleController(VehicleRepositoryService vehicleRepositoryService, ModelMapper modelMapper) {
        this.vehicleRepositoryService = vehicleRepositoryService;
        this.modelMapper = modelMapper;
    }


    //  About: Endpoint for returning filtered values of type List<Vehicle>
    //  Example json Input:
    //  Map<String, String> filters
    //  {
    //      "category" : "D",
    //      "type" : "Седан"
    //  }
    @PostMapping("/filter")
    @ResponseBody
    List<VehicleDTO> filter(@RequestBody Map<String, String> filters) {
        return vehicleRepositoryService.filter(filters).stream().map(this::convertToVehicleDTO).collect(Collectors.toList());
    }





    //  ModelMapper methods. Converters.
    private Vehicle convertToVehicle(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }

    private VehicleDTO convertToVehicleDTO(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDTO.class);
    }
}
