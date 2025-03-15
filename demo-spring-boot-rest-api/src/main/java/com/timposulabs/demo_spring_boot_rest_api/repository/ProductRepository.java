package com.timposulabs.demo_spring_boot_rest_api.repository;

import com.timposulabs.demo_spring_boot_rest_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
