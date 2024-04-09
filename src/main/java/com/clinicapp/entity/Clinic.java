package com.clinicapp.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinicId;
    private String clinicName;
    private String clinicAddress;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "clinic_id")
//    private List<Service> servicesOffered;
}


