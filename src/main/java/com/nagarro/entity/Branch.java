package com.nagarro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "branch", schema = "vaccnow")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "available_vaccine")
    private Long availableVaccine;

    @Column(name = "applied_vaccine")
    private Long appliedVaccine;

    public Branch(String branchName, Long availableVaccine, Long appliedVaccine) {
        this.branchName = branchName;
        this.availableVaccine = availableVaccine;
        this.appliedVaccine = appliedVaccine;
    }
}
