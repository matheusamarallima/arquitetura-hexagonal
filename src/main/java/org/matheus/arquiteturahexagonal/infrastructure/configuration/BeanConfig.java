package org.matheus.arquiteturahexagonal.infrastructure.configuration;


import org.matheus.arquiteturahexagonal.domain.adapters.services.OrderServiceImpl;
import org.matheus.arquiteturahexagonal.domain.ports.interfaces.ProductServicePort;
import org.matheus.arquiteturahexagonal.domain.ports.repositories.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProductServicePort productServicePort(ProductRepositoryPort productRepositoryPort){
        return new OrderServiceImpl(productRepositoryPort);
    }

}
