package com.dhbw.advsoft.project.wms.domain.repositories;

import com.dhbw.advsoft.project.wms.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
