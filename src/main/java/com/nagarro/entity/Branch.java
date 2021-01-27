package com.nagarro.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "branch", schema = "vaccnow")
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "available_vaccine")
    private Long availableVaccine;

    @Column(name = "applied_vaccine")
    private Long appliedVaccine;

}
