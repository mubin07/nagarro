package com.nagarro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDto {

    private Long branchId;

    private String branchName;

    private Long availableVaccine;

    private Long appliedVaccine;

}
