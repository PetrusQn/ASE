package com.dhbw.advsoft.project.wms.domain.repositories;

import com.dhbw.advsoft.project.wms.domain.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
