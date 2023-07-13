package com.chubov.transportcatalogapi;

import com.chubov.transportcatalogapi.repository.impl.VehicleRepositoryImpl;
import com.chubov.transportcatalogapi.service.VehicleRepositoryService;
import com.chubov.transportcatalogapi.service.impl.VehicleRepositoryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransportCatalogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportCatalogApiApplication.class, args);
	}


}
