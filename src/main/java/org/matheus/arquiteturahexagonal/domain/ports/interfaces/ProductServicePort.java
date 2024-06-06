package org.matheus.arquiteturahexagonal.domain.ports.interfaces;

import org.matheus.arquiteturahexagonal.domain.dtos.ProductDTO;
import org.matheus.arquiteturahexagonal.domain.dtos.SupplyDTO;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface ProductServicePort {

    List<ProductDTO> searchProducts();

    void createProduct(ProductDTO productDTO);
    void updateSupply(String sku, SupplyDTO supplyDTO) throws HttpClientErrorException.NotFound;
}
