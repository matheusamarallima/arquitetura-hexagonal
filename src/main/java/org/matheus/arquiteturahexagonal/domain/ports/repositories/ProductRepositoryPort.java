package org.matheus.arquiteturahexagonal.domain.ports.repositories;

import org.matheus.arquiteturahexagonal.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {

    List<Product> findAll();

    Product searchBySku(String sku);

    void save(Product product);
}
