package com.bashkarsampath.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bashkarsampath.app.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}