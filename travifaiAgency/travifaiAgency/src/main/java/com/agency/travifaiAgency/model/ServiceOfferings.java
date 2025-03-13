package com.agency.travifaiAgency.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOfferings {
    private boolean domesticTravel;
    private boolean internationalTravel;
    private boolean hotelBooking;
    private boolean flightTicketing;
    private boolean visaAssistance;
    private boolean carRentals;
    private boolean localTours;
    private boolean customizedPackages;
    private boolean corporateTravel;
    private List<String> preferredMarkets;
}
