package com.clinicapp.service.impl;

import com.clinicapp.exception.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicapp.dto.ClinicDto;
import com.clinicapp.entity.Clinic;
import com.clinicapp.repository.ClinicRespository;
import com.clinicapp.service.ClinicService;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRespository clinicRespository;
    @Autowired
    private ModelMapper modelMapper;




    Clinic mapToEntity(ClinicDto clinicDto) {
        Clinic clinic = modelMapper.map(clinicDto, Clinic.class);
        return clinic;
    }

    ClinicDto mapToDto(Clinic clinic) {
        ClinicDto dto = modelMapper.map(clinic, ClinicDto.class);
        return dto;
    }


    @Override
    public ClinicDto addClinic(ClinicDto clinicDto) {
        Clinic clinic = mapToEntity(clinicDto);
        Clinic saveClinic = clinicRespository.save(clinic);
        ClinicDto dto = mapToDto(saveClinic);
        return dto;
    }

    @Override
    public void deleteClinic(Long id) {
        clinicRespository.deleteById(id);

    }

    @Override
    public Clinic getClinicById(Long id) {
        Clinic ClinicById = clinicRespository.findById(id).orElseThrow(() -> new ResourceNotFound("clinic not found with id" + id));
        return ClinicById;
    }

    @Override
    public List<Clinic> fetchAllClinic() {
        return clinicRespository.findAll();
    }

    @Override
    public Clinic updateClinicById(Long id, ClinicDto clinicDto) {
        Optional<Clinic> optionalClinic = clinicRespository.findById(id);
        if (optionalClinic.isPresent()) {
            Clinic existingClinic = optionalClinic.get();
            existingClinic.setClinicName(clinicDto.getClinicName());
            existingClinic.setClinicAddress(clinicDto.getClinicAddress());
            return clinicRespository.save(existingClinic);
        }
        return null;
    }
}
