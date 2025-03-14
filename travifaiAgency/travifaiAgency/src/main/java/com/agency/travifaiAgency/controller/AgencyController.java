package com.agency.travifaiAgency.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.agency.travifaiAgency.dto.AgencyRegistrationRequest;
import com.agency.travifaiAgency.model.Agency;
import com.agency.travifaiAgency.service.AgencyService;

import jakarta.validation.Valid;

@Tag(name = "Travel Agency Management", description = "Operations related to travel agency registration and management")
@RestController
@RequestMapping("/agency")
@RequiredArgsConstructor
public class AgencyController {
    private static final Logger logger = LoggerFactory.getLogger(AgencyController.class);
    private final AgencyService agencyService;

    @Operation(
        summary = "Register a new travel agency", 
        description = "Registers a new agency with provided details and returns a success message"
    )
    @PostMapping("/register")
    public ResponseEntity<String> registerAgency(@Valid @RequestBody AgencyRegistrationRequest request) {
        logger.info("Received registration request for agency: {}", request.getAgencyName());
        agencyService.registerAgency(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Agency registered successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Agency>> getAllAgencies() {
        logger.info("Fetching all agencies");
        List<Agency> agencies = agencyService.getAllAgencies();
        return ResponseEntity.ok(agencies);
    }


    @Operation(
        summary = "Get agency details", 
        description = "Retrieves details of an existing travel agency by its name"
    )
    @GetMapping("/name/{agencyName}")
    public ResponseEntity<Agency> getAgency(@PathVariable String agencyName) {
        logger.info("Fetching details for agency: {}", agencyName);
        Agency agencyDetails = agencyService.getAgencyByName(agencyName);
        return ResponseEntity.ok(agencyDetails);
    }
    

    @Operation(
        summary = "Update an agency", 
        description = "Updates the details of an existing travel agency"
    )
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAgency(@PathVariable String id, @Valid @RequestBody AgencyRegistrationRequest request) {
        logger.info("Updating agency with ID: {}", id);
        agencyService.updateAgency(id, request);
        return ResponseEntity.ok("Agency updated successfully!");
    }

    @Operation(
        summary = "Delete an agency", 
        description = "Deletes an existing travel agency by its ID"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgency(@PathVariable String id) {
        logger.info("Deleting agency with ID: {}", id);
        agencyService.deleteAgency(id);
        return ResponseEntity.ok("Agency deleted successfully!");
    }
}
