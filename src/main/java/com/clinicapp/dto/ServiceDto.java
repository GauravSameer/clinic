package com.clinicapp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private String serviceId;
    private String serviceName;
    private String serviceCode;
    private String serviceDescription;
    private double averagePrice;
    private boolean isActive;
}
