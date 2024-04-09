package com.clinicapp.controller;

import com.clinicapp.entity.Clinic;
import jakarta.persistence.EntityNotFoundException;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.clinicapp.dto.ClinicDto;
import com.clinicapp.service.ClinicService;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;
    //http://localhost:8081/clinic/addClinic
    @PostMapping("/addClinic")
    public ResponseEntity<ClinicDto> post(@ParameterObject @RequestBody ClinicDto clinicDto) {
        ClinicDto dto = clinicService.addClinic(clinicDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //http://localhost:8081/clinic/AllClinic
    @GetMapping("/AllClinic")
    public List<Clinic> getAllClinic() {
        return clinicService.fetchAllClinic();
    }
    //http://localhost:8081/clinic/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClinic(@PathVariable Long id) {
        try{
            clinicService.deleteClinic(id);
            return new ResponseEntity<>("clinic with id" + id + "deleted successfully", HttpStatus.OK);
        } catch(EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    //http://localhost:8081/clinic/1
    @GetMapping("/{id}")
    public ResponseEntity<?> getClinicById(@PathVariable Long id) {
        Clinic clinic = clinicService.getClinicById(id);
        if (clinic == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clinic);
    }
    //http://localhost:8081/clinic/1
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClinic(@PathVariable Long id, @RequestBody ClinicDto clinicDto) {
        Clinic updateClinic = clinicService.updateClinicById(id, clinicDto);
        if (updateClinic == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updateClinic);
    }

}
