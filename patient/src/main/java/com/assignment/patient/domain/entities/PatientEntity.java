package com.assignment.patient.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="patient_details")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer patientId;

    @Column(name = "name")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private Long phoneNumber;

}
