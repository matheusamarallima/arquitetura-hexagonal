package org.matheus.arquiteturahexagonal.infrastructure.repositories;

import org.matheus.arquiteturahexagonal.domain.Product;
import org.matheus.arquiteturahexagonal.domain.ports.repositories.ProductRepositoryPort;
import org.matheus.arquiteturahexagonal.infrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepository implements ProductRepositoryPort {

    private final SpringProductRepository springProductRepository;
    public ProductRepository(SpringProductRepository springProductRepository) {
        this.springProductRepository = springProductRepository;
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> allProducts = springProductRepository.findAll();
        return allProducts.stream().map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    @Override
    public Product searchBySku(String sku) {
        Optional<ProductEntity> optionalProductEntity = springProductRepository.findBySku(sku);
        if(optionalProductEntity.isPresent()){
            return optionalProductEntity.get().toProduct();
        }
        throw new RuntimeException("Does not exist");
    }

    @Override
    public void save(Product product) {
        ProductEntity productEntity;
        if(Objects.isNull(product.getCod())){
            productEntity = new ProductEntity(product);
        }else {
            productEntity = springProductRepository.findById(product.getCod()).get();
            productEntity.update(product);
        }
    }
}
