package com.timposulabs.demo_spring_boot_rest_api.dto;

import java.math.BigDecimal;

public record ProductDTO(Long id, String name, String description, BigDecimal price) {
}
