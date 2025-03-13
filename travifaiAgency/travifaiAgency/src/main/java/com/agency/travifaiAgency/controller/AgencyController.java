package com.agency.travifaiAgency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agency.travifaiAgency.dto.AgencyRegistrationRequest;
import com.agency.travifaiAgency.service.AgencyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAgency(@Valid @RequestBody AgencyRegistrationRequest request) {
        agencyService.registerAgency(request);
        return ResponseEntity.ok("Agency registered successfully!");
    }
}
