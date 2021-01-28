package com.nagarro.repository;

import com.nagarro.entity.Branch;
import com.nagarro.entity.Slot;
import com.nagarro.entity.Vaccine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VaccineRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Test
    public void whenFindAll_thenReturnAllVaccines() {
        // command line runner has 20 vaccines appointment initialized while system boot strap
        List<Vaccine> vaccineList = vaccineRepository.findAll();
        assertThat(vaccineList.size()).isEqualTo(20);
    }

    @Test
    public void whenFindByVaccineId_thenReturnVaccineWithTheId() {
        Vaccine vaccine = vaccineRepository.findById(1L).get();
        assertThat(vaccine.getVaccineId()).isEqualTo(1L);
    }

    @Test
    public void whenFindByInvalidVaccineId_thenReturnFalse() {
        boolean isPresent = vaccineRepository.findById(21L).isPresent();
        assertThat(isPresent).isEqualTo(false);
    }

    @Test
    public void whenNoVaccinesAppliedFindAppliedVaccinePerBranch_thenReturnNone() {
        // do not apply any vaccine
        List<Vaccine> appliedVaccineList = vaccineRepository.findAppliedVaccinePerBranch(1L);
        assertThat(appliedVaccineList.size()).isEqualTo(0L);
    }

    @Test
    public void whenFindAppliedVaccinePerBranch_thenReturnAppliedVaccinesPerBranch() {
        // apply one vaccine for a branch
        applyOneVaccineForBranch1();

        List<Vaccine> appliedVaccineList = vaccineRepository.findAppliedVaccinePerBranch(1L);
        assertThat(appliedVaccineList.size()).isEqualTo(1L);
    }

    @Test
    public void whenNoVaccinesAppliedFindAppliedVaccinePerDay_thenReturnNone() {
        // do not apply any vaccine
        List<Vaccine> appliedVaccineList = vaccineRepository.findAppliedVaccinePerDay(LocalDate.now());
        assertThat(appliedVaccineList.size()).isEqualTo(0L);
    }

    @Test
    public void whenFindAppliedVaccinePerDay_thenReturnAppliedVaccinePerDay() {
        // apply one vaccine for a branch
        applyOneVaccineForBranch1();

        List<Vaccine> appliedVaccineList = vaccineRepository.findAppliedVaccinePerDay(LocalDate.now());
        assertThat(appliedVaccineList.size()).isEqualTo(1L);
    }

    @Test
    public void whenNoVaccinesAppliedFindAppliedVaccinePerPeriod_thenReturnNone() {
        List<Vaccine> appliedVaccineList = vaccineRepository.findAppliedVaccinePerPeriod(LocalDate.now().minusDays(1L), LocalDate.now());
        assertThat(appliedVaccineList.size()).isEqualTo(0L);
    }

    @Test
    public void whenFindAppliedVaccinePerPeriod_thenReturnVaccinesApplierPerPeriod() {
        // apply one vaccine for a branch
        applyOneVaccineForBranch1();

        // apply another vaccine for other branch
        applyOneVaccineForBranch2();

        List<Vaccine> appliedVaccineList = vaccineRepository.findAppliedVaccinePerPeriod(LocalDate.now().minusDays(1L), LocalDate.now());
        assertThat(appliedVaccineList.size()).isEqualTo(2L);
    }

    @Test
    public void whenSomeVaccineAppliedFindConfirmedVaccinePerPeriod_thenReturnConfirmedVaccinePerPeriod() {
        // apply one vaccine for a branch
        applyOneVaccineForBranch1();

        // apply another vaccine for other branch
        applyOneVaccineForBranch2();

        List<Vaccine> confirmedVaccineList = vaccineRepository.findConfirmedVaccinePerPeriod(LocalDate.now().minusDays(1L), LocalDate.now());
        assertThat(confirmedVaccineList.size()).isEqualTo(18L); //20 is the original vaccination count , 2 vaccines have been applied
    }

    @Test
    public void whenFindConfirmedVaccinePerPeriod_thenReturnConfirmedVaccinePerPeriod() {
        List<Vaccine> confirmedVaccineList = vaccineRepository.findConfirmedVaccinePerPeriod(LocalDate.now().minusDays(1L), LocalDate.now());
        assertThat(confirmedVaccineList.size()).isEqualTo(20L);
    }

    @Test
    public void whenFindBookedTimeSlotForDatePerInvalidBranch_thenReturnNone() {
        List<Slot> bookedSlotList = vaccineRepository.findBookedTimeSlotForDatePerBranch(6L, LocalDate.now());
        assertThat(bookedSlotList.size()).isEqualTo(0L);
    }

    @Test
    public void whenFindBookedTimeSlotForDatePerBranch_thenReturnBookedTimeSlotPerDatePerBranch() {
        List<Slot> bookedSlotList = vaccineRepository.findBookedTimeSlotForDatePerBranch(1L, LocalDate.now());
        assertThat(bookedSlotList.size()).isEqualTo(4L);
    }

    @Test
    public void whenFindUnAppliedVaccineByInvalidDate_thenReturnNone() {
        List<Vaccine> unAppliedVaccineList = vaccineRepository.findUnAppliedVaccineByDate(LocalDate.now().plusDays(1L));
        assertThat(unAppliedVaccineList.size()).isEqualTo(0L);
    }

    @Test
    public void whenFindUnAppliedVaccineByDate_thenReturnUnAppliedVaccineByDate() {
        List<Vaccine> unAppliedVaccineList = vaccineRepository.findUnAppliedVaccineByDate(LocalDate.now());
        assertThat(unAppliedVaccineList.size()).isEqualTo(20L);
    }

    @Test
    public void whenApplyVaccinesFindUnAppliedVaccineByDate_thenReturnUnAppliedVaccineByDate() {
        // apply one vaccine for a branch
        applyOneVaccineForBranch1();

        // apply another vaccine for other branch
        applyOneVaccineForBranch2();

        List<Vaccine> unAppliedVaccineList = vaccineRepository.findUnAppliedVaccineByDate(LocalDate.now());
        assertThat(unAppliedVaccineList.size()).isEqualTo(18L); //20 is the original vaccination count , 2 vaccines have been applied
    }

    private void applyOneVaccineForBranch1() {
        Vaccine vaccine = vaccineRepository.findById(1L).get();
        vaccine.setIsApplied(true);
        Branch branch = vaccine.getBranch();
        branch.setAppliedVaccine(branch.getAppliedVaccine() + 1);
        branchRepository.save(branch);
        vaccine.setBranch(branch);
        vaccine.setAppointmentDate(LocalDate.now());
        vaccineRepository.save(vaccine);
    }

    private void applyOneVaccineForBranch2() {
        Vaccine vaccine = vaccineRepository.findById(2L).get();
        vaccine.setIsApplied(true);
        Branch branch = vaccine.getBranch();
        branch.setAppliedVaccine(branch.getAppliedVaccine() + 1);
        branchRepository.save(branch);
        vaccine.setBranch(branch);
        vaccine.setAppointmentDate(LocalDate.now());
        vaccineRepository.save(vaccine);
    }

}
