package org.matheus.arquiteturahexagonal.domain.adapters.services;

import org.matheus.arquiteturahexagonal.domain.Product;
import org.matheus.arquiteturahexagonal.domain.dtos.ProductDTO;
import org.matheus.arquiteturahexagonal.domain.dtos.SupplyDTO;
import org.matheus.arquiteturahexagonal.domain.ports.interfaces.ProductServicePort;
import org.matheus.arquiteturahexagonal.domain.ports.repositories.ProductRepositoryPort;

import java.util.List;
import java.util.Objects;

public class OrderServiceImpl implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;

    public OrderServiceImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }


    @Override
    public List<ProductDTO> searchProducts() {
        List<Product> allproducts = productRepositoryPort.findAll();
        List<ProductDTO> productDTOS = allproducts.stream().map(Product::toProductDTO).toList();
        return productDTOS;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        productRepositoryPort.save(product);

    }

    @Override
    public void updateSupply(String sku, SupplyDTO supplyDTO) throws NotFoundException {
        Product product = productRepositoryPort.searchBySku(sku);
        if(Objects.isNull(product)){
            throw new NotFoundException("Não encontrado");
        }

        product.updateProduct(product.getQuant());

        productRepositoryPort.save(product);
    }
}
