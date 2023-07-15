package com.chubov.transportcatalogapi.util.customExeption;

public class BadIdFormatException extends RuntimeException {
    public BadIdFormatException(String message) {
        //  Custom exception for catching when Id not a Long values ("id":"34g")
        super(message);
    }
}
