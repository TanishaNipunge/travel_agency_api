package com.agency.travifaiAgency.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documentation {
    private String businessLicense;
    private String gstVatCertificate;
    private String panTinCertificate;
    private String bankAccountDetails;
    private List<String> customerReviews;
}
