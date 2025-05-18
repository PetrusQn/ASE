package com.dhbw.advsoft.project.wms.web.controllers;

import com.dhbw.advsoft.project.wms.common.Constants;
import com.dhbw.advsoft.project.wms.domain.models.Address;
import com.dhbw.advsoft.project.wms.domain.models.Item;
import com.dhbw.advsoft.project.wms.domain.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSIONPATH)
public class AdressController {
    private static final String BASEPATH = "/addresses";
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping(BASEPATH)
    public List<Address> getAllAddresses() { return addressRepository.findAll(); }

    @PostMapping(BASEPATH)
    public Address addAddress(@RequestBody Address adress) { return addressRepository.save(adress); }
}
