package org.matheus.arquiteturahexagonal.domain;

import lombok.Data;
import org.matheus.arquiteturahexagonal.domain.dtos.ProductDTO;

import java.util.UUID;

@Data
public class Product {

    private UUID cod;
    private String SKU;
    private String name;
    private Double price;
    private Double quant;

    public Product(ProductDTO productDTO) {
        this.cod = productDTO.cod();
        this.SKU = productDTO.SKU();
        this.name = productDTO.name();
        this.price = productDTO.price();
        this.quant = productDTO.quant();
    }

    public static ProductDTO toProductDTO(Product product) {
        ProductDTO dto = new ProductDTO(product.cod, product.SKU, product.name, product.price, product.quant);
        return dto;
    }

    public void updateProduct(double quant) {
        this.quant = quant;
    }
}
