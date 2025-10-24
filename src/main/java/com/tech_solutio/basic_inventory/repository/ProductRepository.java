package com.tech_solutio.basic_inventory.repository;

import com.tech_solutio.basic_inventory.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
