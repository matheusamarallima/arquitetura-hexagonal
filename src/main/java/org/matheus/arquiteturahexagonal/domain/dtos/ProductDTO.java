package org.matheus.arquiteturahexagonal.domain.dtos;

import java.util.UUID;

public record ProductDTO(UUID cod, String SKU, String name, Double price, Double quant) {
}
