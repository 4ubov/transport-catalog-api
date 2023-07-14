package com.chubov.transportcatalogapi.util.customExeption;

public class StateNumberAlreadyExistsException extends RuntimeException {
    public StateNumberAlreadyExistsException(String message)  {
        //  Custom exception for catching when bad url format
        super(message);
    }
}
