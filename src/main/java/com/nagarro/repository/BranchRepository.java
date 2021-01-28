package com.nagarro.repository;

import com.nagarro.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query("SELECT b from Branch b where b.branchName = :branchName")
    Branch findByName(@Param("branchName") String branchName);

}
