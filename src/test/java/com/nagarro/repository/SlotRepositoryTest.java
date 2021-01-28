package com.nagarro.repository;

import com.nagarro.entity.Slot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SlotRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SlotRepository slotRepository;

    @Test
    public void whenFindAll_thenReturnAllSchedules() {
        // command line runner has 48 slots initialized while system boot strap
        List<Slot> slotList = slotRepository.findAll();
        assertThat(slotList.size()).isEqualTo(48);
    }

    @Test
    public void whenFindBySlotId_thenReturnSlotWithTheId() {
        Slot slot = slotRepository.findById("M1").get();
        assertThat(slot.getSlotId()).isEqualTo("M1");
    }

    @Test
    public void whenFindByInvalidSlotId_thenReturnFalse() {
        boolean isPresent = slotRepository.findById("M13").isPresent();
        assertThat(isPresent).isEqualTo(false);
    }

}
