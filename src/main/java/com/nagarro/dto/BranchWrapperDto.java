package com.nagarro.dto;

import com.nagarro.entity.Branch;

import java.util.List;

public class BranchWrapperDto {

    private List<Branch> branchList;

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }
}
