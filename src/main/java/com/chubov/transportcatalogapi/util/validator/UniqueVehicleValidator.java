package com.chubov.transportcatalogapi.util.validator;

import com.chubov.transportcatalogapi.model.Vehicle;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

@SuppressWarnings("NullableProblems")
@Component
public class UniqueVehicleValidator implements Validator {
    //  Класс ваидатор, для проверки на уникальность при добавлении объека Vehicle в БД

    private final VehicleRepositoryService vehicleRepositoryService;

    @Autowired
    public UniqueVehicleValidator(VehicleRepositoryService vehicleRepositoryService) {
        this.vehicleRepositoryService = vehicleRepositoryService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Vehicle.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Vehicle vehicle = (Vehicle) target;
        if (vehicleRepositoryService.findOneByStateNumber(vehicle.getStateNumber()).isPresent()) {
            errors.rejectValue("stateNumber", "", "Транспорт с таким гос. номером уже есть в БД!");
        }
    }
}
