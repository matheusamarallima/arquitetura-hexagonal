package org.matheus.arquiteturahexagonal.adapter.controllers;

import org.matheus.arquiteturahexagonal.domain.adapters.services.NotFoundException;
import org.matheus.arquiteturahexagonal.domain.dtos.ProductDTO;
import org.matheus.arquiteturahexagonal.domain.dtos.SupplyDTO;
import org.matheus.arquiteturahexagonal.domain.ports.interfaces.ProductServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @PostMapping
    void createProduct(@RequestBody ProductDTO productDTO){
        productServicePort.createProduct(productDTO);
    }

    @GetMapping
    List<ProductDTO> getProducts(){
        return productServicePort.searchProducts();
    }

    @PutMapping(value = "/{sku}")
    void updateProduct(@PathVariable String sku, @RequestBody SupplyDTO supplyDTO) throws NotFoundException {
        productServicePort.updateSupply(sku, supplyDTO);
    }
}
