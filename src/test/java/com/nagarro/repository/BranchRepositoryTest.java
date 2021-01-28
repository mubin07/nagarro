package com.nagarro.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nagarro.entity.Branch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BranchRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BranchRepository branchRepository;

    @Test
    public void whenFindAll_thenReturnAllBranches() {
        // command line runner has 5 branches initialized while system boot strap
        List<Branch> branchList = branchRepository.findAll();
        assertThat(branchList.size()).isEqualTo(5);
    }

    @Test
    public void whenFindByBranchId_thenReturnBranchWithTheId() {
        Branch branch = branchRepository.findById(1L).get();
        assertThat(branch.getBranchId()).isEqualTo(1L);
    }

    @Test
    public void whenFindByInvalidBranchId_thenReturnFalse() {
        boolean isPresent = branchRepository.findById(6L).isPresent();
        assertThat(isPresent).isEqualTo(false);
    }

    @Test
    public void whenFindByBranchName_thenReturnBranchWithTheName() {
        Branch branch = branchRepository.findByName("Branch 01");
        assertThat(branch.getBranchName()).isEqualTo("Branch 01");
    }

    @Test
    public void whenFindByInvalidBranchName_thenReturnNull() {
        Branch branch = branchRepository.findByName("Branch 06");
        assertThat(branch).isEqualTo(null);
    }
}
