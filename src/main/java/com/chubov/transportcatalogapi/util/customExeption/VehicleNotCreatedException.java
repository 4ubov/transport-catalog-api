package com.chubov.transportcatalogapi.util.customExeption;

public class VehicleNotCreatedException extends RuntimeException {
    public VehicleNotCreatedException(String message)  {
        //  Custom exception for catching when bad url format
        super(message);
    }
}
