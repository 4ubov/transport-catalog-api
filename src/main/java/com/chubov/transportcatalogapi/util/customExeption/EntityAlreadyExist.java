package com.chubov.transportcatalogapi.util.customExeption;

public class EntityAlreadyExist extends RuntimeException {
    public EntityAlreadyExist(String message) {
        //  Custom exception for catching when Entity already exist format (entity1.equals(entity2))
        super(message);
    }
}
