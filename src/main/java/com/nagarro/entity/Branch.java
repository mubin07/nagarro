package com.nagarro.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "branch", schema = "vaccnow")
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

    public Branch() {
    }

    public Branch(final Long branchId, final String branchName, final Long availableVaccine, final Long appliedVaccine) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.availableVaccine = availableVaccine;
        this.appliedVaccine = appliedVaccine;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(final Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(final String branchName) {
        this.branchName = branchName;
    }

    public Long getAvailableVaccine() {
        return availableVaccine;
    }

    public void setAvailableVaccine(final Long availableVaccine) {
        this.availableVaccine = availableVaccine;
    }

    public Long getAppliedVaccine() {
        return appliedVaccine;
    }

    public void setAppliedVaccine(final Long appliedVaccine) {
        this.appliedVaccine = appliedVaccine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchId, branch.branchId) &&
                Objects.equals(branchName, branch.branchName) &&
                Objects.equals(availableVaccine, branch.availableVaccine) &&
                Objects.equals(appliedVaccine, branch.appliedVaccine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, branchName, availableVaccine, appliedVaccine);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", availableVaccine=" + availableVaccine +
                ", appliedVaccine=" + appliedVaccine +
                '}';
    }
}
