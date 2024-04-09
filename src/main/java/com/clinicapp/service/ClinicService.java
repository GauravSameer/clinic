package com.clinicapp.service;

import com.clinicapp.dto.ClinicDto;
import com.clinicapp.entity.Clinic;

import java.util.List;

public interface ClinicService {
    ClinicDto addClinic(ClinicDto clinicDto);

    void deleteClinic(Long id);

    Clinic getClinicById(Long id);

    List<Clinic> fetchAllClinic();

    Clinic updateClinicById(Long id, ClinicDto clinicDto);
}
