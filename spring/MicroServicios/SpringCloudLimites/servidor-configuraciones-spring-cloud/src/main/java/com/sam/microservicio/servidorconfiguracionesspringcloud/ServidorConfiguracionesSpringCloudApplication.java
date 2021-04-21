package com.sam.microservicio.servidorconfiguracionesspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServidorConfiguracionesSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorConfiguracionesSpringCloudApplication.class, args);
	}

}
