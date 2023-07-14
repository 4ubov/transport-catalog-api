package com.chubov.transportcatalogapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransportCatalogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportCatalogApiApplication.class, args);
    }

    //  Bean for ModelMapper
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
    

}
