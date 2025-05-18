package com.dhbw.advsoft.project.wms.domain.repositories;

import com.dhbw.advsoft.project.wms.domain.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
