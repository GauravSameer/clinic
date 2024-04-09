package com.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicapp.entity.Clinic;

public interface ClinicRespository extends JpaRepository<Clinic, Long> {

}
