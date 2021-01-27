package com.nagarro.dto;

import lombok.Data;

@Data
public class BranchDto {

    private Long branchId;

    private String branchName;

    private Long availableVaccine;

    private Long appliedVaccine;

}
