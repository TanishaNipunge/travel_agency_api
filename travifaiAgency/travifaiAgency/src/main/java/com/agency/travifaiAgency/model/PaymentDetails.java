package com.agency.travifaiAgency.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
     private List<String> preferredPaymentModes;
    private String refundPolicy;
}
