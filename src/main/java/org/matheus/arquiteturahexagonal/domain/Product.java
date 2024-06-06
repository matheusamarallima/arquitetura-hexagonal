package org.matheus.arquiteturahexagonal.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Product {

    private UUID cod;
    private String SKU;
    private String name;
    private Double price;
    private Double quant;

}
