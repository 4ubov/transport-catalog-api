package com.chubov.transportcatalogapi.util.Mapper;

import com.chubov.transportcatalogapi.dto.VehicleCategoryDTO;
import com.chubov.transportcatalogapi.dto.VehicleDTO;
import com.chubov.transportcatalogapi.dto.VehicleTypeDTO;
import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.model.VehicleCategory;
import com.chubov.transportcatalogapi.model.VehicleType;
import com.chubov.transportcatalogapi.service.VehicleCategoryRepositoryService;
import com.chubov.transportcatalogapi.service.VehicleTypeRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperWrapper {

    private final ModelMapper modelMapper;

    private final VehicleTypeRepositoryService typeRepositoryService;
    private final VehicleCategoryRepositoryService categoryRepositoryService;

    @Autowired
    public ModelMapperWrapper(ModelMapper modelMapper, VehicleTypeRepositoryService vehicleTypeRepositoryService,
                              VehicleCategoryRepositoryService vehicleCategoryRepositoryService) {
        this.modelMapper = modelMapper;
        this.typeRepositoryService = vehicleTypeRepositoryService;
        this.categoryRepositoryService = vehicleCategoryRepositoryService;
    }

    //  ModelMapper methods. Converters.

    //  ModelMappers for Vehicle and VehicleDTO
    public Vehicle convertToVehicle(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }

    public VehicleDTO convertToVehicleDTO(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    //  Custom impl cause default impl don't map fields (vehicleCategory, vehicleType), it set null
    //  This impl work correct. Just Convert from VehicleDto to Vehicle
    public Vehicle convertToVehicleCustom(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(vehicleDTO.getVehicleId());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYearOfRealise(vehicleDTO.getYearOfRealise());
        vehicle.setStateNumber(vehicleDTO.getStateNumber());
        vehicle.setHasTrailer(vehicleDTO.getHasTrailer());
        vehicle.setType(typeRepositoryService.getOneByTypeName(vehicleDTO.getType()).get());
        vehicle.setCategory(categoryRepositoryService.getOneByCategoryName(vehicleDTO.getCategory()).get());
        return vehicle;
    }



    //  ModelMappers for VehicleCategory and VehicleCategoryDTO
    public VehicleCategory convertToVehicleCategory(VehicleCategoryDTO vehicleCategoryDTO) {
        return modelMapper.map(vehicleCategoryDTO, VehicleCategory.class);
    }

    public VehicleCategoryDTO convertToVehicleCategoryDTO(VehicleCategory vehicleCategory) {
        return modelMapper.map(vehicleCategory, VehicleCategoryDTO.class);
    }


    //  ModelMappers for VehicleType and VehicleTypeDTO
    public VehicleType convertToVehicleType(VehicleTypeDTO vehicleTypeDTO) {
        return modelMapper.map(vehicleTypeDTO, VehicleType.class);
    }

    public VehicleTypeDTO convertToVehicleTypeDTO(VehicleType vehicleType) {
        return modelMapper.map(vehicleType, VehicleTypeDTO.class);
    }
}
