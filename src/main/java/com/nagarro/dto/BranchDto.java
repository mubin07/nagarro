package com.nagarro.dto;

import java.util.Objects;

public class BranchDto {

    private Long branchId;

    private String branchName;

    private Long availableVaccine;

    private Long appliedVaccine;

    public BranchDto(Long branchId, String branchName, Long availableVaccine, Long appliedVaccine) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.availableVaccine = availableVaccine;
        this.appliedVaccine = appliedVaccine;
    }

    public Long getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public Long getAvailableVaccine() {
        return availableVaccine;
    }

    public Long getAppliedVaccine() {
        return appliedVaccine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchDto branchDto = (BranchDto) o;
        return Objects.equals(branchId, branchDto.branchId) &&
                Objects.equals(branchName, branchDto.branchName) &&
                Objects.equals(availableVaccine, branchDto.availableVaccine) &&
                Objects.equals(appliedVaccine, branchDto.appliedVaccine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, branchName, availableVaccine, appliedVaccine);
    }

    @Override
    public String toString() {
        return "BranchDto{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", availableVaccine=" + availableVaccine +
                ", appliedVaccine=" + appliedVaccine +
                '}';
    }
}
