package com.nagarro.repository;

import com.nagarro.entity.Schedule;
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
public class ScheduleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    public void whenFindAll_thenReturnAllSchedules() {
        // command line runner has 20 schedule initialized while system boot strap
        List<Schedule> scheduleList = scheduleRepository.findAll();
        assertThat(scheduleList.size()).isEqualTo(20);
    }

    @Test
    public void whenFindByScheduleId_thenReturnScheduleWithTheId() {
        Schedule schedule = scheduleRepository.findById(1L).get();
        assertThat(schedule.getScheduleId()).isEqualTo(1L);
    }

    @Test
    public void whenFindByInvalidScheduleId_thenReturnFalse() {
        boolean isPresent = scheduleRepository.findById(21L).isPresent();
        assertThat(isPresent).isEqualTo(false);
    }

    @Test
    public void whenFindBySchedule_thenReturnSchedule() {
        Schedule schedule = scheduleRepository.findBySchedule(1L, LocalDate.now(), "M1");
        assertThat(schedule).isNotNull();
    }

    @Test
    public void whenFindByNonExistentSchedule_thenReturnNull() {
        Schedule schedule = scheduleRepository.findBySchedule(1L, LocalDate.now(), "M5");
        assertThat(schedule).isNull();
    }


}
