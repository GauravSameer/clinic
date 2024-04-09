package com.clinicapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicDto {
    private String clinicId;
    private String clinicName;
    private String clinicAddress;
//    private String businessName;
//    private String city;
//    private String state;
//    private String country;
//    private String zipCode;
//    private double latitude;
//    private double longitude;
//    private Date dateCreated;
//    private List<ServiceDto> servicesOffered;
}
