package com.dhbw.advsoft.project.wms.domain.repositories;

import com.dhbw.advsoft.project.wms.domain.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
