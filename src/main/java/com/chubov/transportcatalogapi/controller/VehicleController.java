package com.chubov.transportcatalogapi.controller;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VehicleController {
    //  Main controller

    private final VehicleRepositoryService vehicleRepositoryService;

    @Autowired
    public VehicleController(VehicleRepositoryService vehicleRepositoryService) {
        this.vehicleRepositoryService = vehicleRepositoryService;
    }


    //  Endpoint for filter
    @PostMapping("/filter")
    @ResponseBody
    List<Vehicle> filter(@RequestBody Map<String, String> filters) {
        return vehicleRepositoryService.filter(filters);
    }
}
