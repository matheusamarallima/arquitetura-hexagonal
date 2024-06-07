package org.matheus.arquiteturahexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.matheus.arquiteturahexagonal.domain.Product;

import java.util.UUID;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID cod;
    private String sku;
    private String name;
    private Double price;
    private Double quant;

    public ProductEntity(Product product){
        this.sku = product.getSKU();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quant = product.getQuant();
    }

    public ProductEntity() {
    }

    public Product toProduct() {
        return new Product(this.cod, this.sku, this.name, this.price, this.quant);
    }

    public void update(Product produto) {
        this.sku = produto.getSKU();
        this.name = produto.getName();
        this.price = produto.getPrice();
        this.quant = produto.getQuant();
    }
}
