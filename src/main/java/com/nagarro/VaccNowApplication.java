package com.nagarro;

import com.nagarro.constants.PaymentMethod;
import com.nagarro.entity.Branch;
import com.nagarro.entity.Schedule;
import com.nagarro.entity.Slot;
import com.nagarro.entity.Vaccine;
import com.nagarro.repository.BranchRepository;
import com.nagarro.repository.ScheduleRepository;
import com.nagarro.repository.SlotRepository;
import com.nagarro.repository.VaccineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VaccNowApplication implements CommandLineRunner {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(VaccNowApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VaccNowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize the branch
        LOGGER.info("Initializing the branch data");
        Branch branch1 = new Branch("Branch 01", 10L, 0L);
        Branch branch2 = new Branch("Branch 02", 20L, 0L);
        Branch branch3 = new Branch("Branch 03", 30L, 0L);
        Branch branch4 = new Branch("Branch 04", 40L, 0L);
        Branch branch5 = new Branch("Branch 05", 50L, 0L);

        List<Branch> branchList = new ArrayList<>();
        branchList.add(branch1);
        branchList.add(branch2);
        branchList.add(branch3);
        branchList.add(branch4);
        branchList.add(branch5);

        branchRepository.saveAll(branchList);

        LOGGER.info("Initializing the schedule data");
        Schedule schedule1 = new Schedule(1L, LocalDate.now(), "M1");
        Schedule schedule2 = new Schedule(2L, LocalDate.now(), "M1");
        Schedule schedule3 = new Schedule(3L, LocalDate.now(), "M1");
        Schedule schedule4 = new Schedule(4L, LocalDate.now(), "M1");
        Schedule schedule5 = new Schedule(5L, LocalDate.now(), "M1");

        Schedule schedule6 = new Schedule(1L, LocalDate.now(), "M2");
        Schedule schedule7 = new Schedule(2L, LocalDate.now(), "M2");
        Schedule schedule8 = new Schedule(3L, LocalDate.now(), "M2");
        Schedule schedule9 = new Schedule(4L, LocalDate.now(), "M2");
        Schedule schedule10 = new Schedule(5L, LocalDate.now(), "M2");

        Schedule schedule11 = new Schedule(1L, LocalDate.now(), "M3");
        Schedule schedule12 = new Schedule(2L, LocalDate.now(), "M3");
        Schedule schedule13 = new Schedule(3L, LocalDate.now(), "M3");
        Schedule schedule14 = new Schedule(4L, LocalDate.now(), "M3");
        Schedule schedule15 = new Schedule(5L, LocalDate.now(), "M3");

        Schedule schedule16 = new Schedule(1L, LocalDate.now(), "M4");
        Schedule schedule17 = new Schedule(2L, LocalDate.now(), "M4");
        Schedule schedule18 = new Schedule(3L, LocalDate.now(), "M4");
        Schedule schedule19 = new Schedule(4L, LocalDate.now(), "M4");
        Schedule schedule20 = new Schedule(5L, LocalDate.now(), "M4");

        List<Schedule> scheduleList = new ArrayList<>();
        scheduleList.add(schedule1);
        scheduleList.add(schedule2);
        scheduleList.add(schedule3);
        scheduleList.add(schedule4);
        scheduleList.add(schedule5);
        scheduleList.add(schedule6);
        scheduleList.add(schedule7);
        scheduleList.add(schedule8);
        scheduleList.add(schedule9);
        scheduleList.add(schedule10);
        scheduleList.add(schedule11);
        scheduleList.add(schedule12);
        scheduleList.add(schedule13);
        scheduleList.add(schedule14);
        scheduleList.add(schedule15);
        scheduleList.add(schedule16);
        scheduleList.add(schedule17);
        scheduleList.add(schedule18);
        scheduleList.add(schedule19);
        scheduleList.add(schedule20);

        scheduleRepository.saveAll(scheduleList);

        LOGGER.info("Initializing the slot data");
        LocalTime localTime = LocalTime.of(9, 0, 0);
        Slot slot1 = new Slot("M1", localTime, localTime.plusMinutes(15));
        Slot slot2 = new Slot("M2", localTime.plusMinutes(15), localTime.plusMinutes(30));
        Slot slot3 = new Slot("M3", localTime.plusMinutes(30), localTime.plusMinutes(45));
        Slot slot4 = new Slot("M4", localTime.plusMinutes(45), localTime.plusMinutes(60));
        Slot slot5 = new Slot("M5", localTime.plusMinutes(60), localTime.plusMinutes(75));
        Slot slot6 = new Slot("M6", localTime.plusMinutes(75), localTime.plusMinutes(90));
        Slot slot7 = new Slot("M7", localTime.plusMinutes(90), localTime.plusMinutes(105));
        Slot slot8 = new Slot("M8", localTime.plusMinutes(105), localTime.plusMinutes(120));
        Slot slot9 = new Slot("M9", localTime.plusMinutes(120), localTime.plusMinutes(135));
        Slot slot10 = new Slot("M10", localTime.plusMinutes(135), localTime.plusMinutes(150));
        Slot slot11 = new Slot("M11", localTime.plusMinutes(150), localTime.plusMinutes(165));
        Slot slot12 = new Slot("M12", localTime.plusMinutes(165), localTime.plusMinutes(180));

        localTime = LocalTime.of(12, 0, 0);
        Slot slot13 = new Slot("A1", localTime, localTime.plusMinutes(15));
        Slot slot14 = new Slot("A2", localTime.plusMinutes(15), localTime.plusMinutes(30));
        Slot slot15 = new Slot("A3", localTime.plusMinutes(30), localTime.plusMinutes(45));
        Slot slot16 = new Slot("A4", localTime.plusMinutes(45), localTime.plusMinutes(60));
        Slot slot17 = new Slot("A5", localTime.plusMinutes(60), localTime.plusMinutes(75));
        Slot slot18 = new Slot("A6", localTime.plusMinutes(75), localTime.plusMinutes(90));
        Slot slot19 = new Slot("A7", localTime.plusMinutes(90), localTime.plusMinutes(105));
        Slot slot20 = new Slot("A8", localTime.plusMinutes(105), localTime.plusMinutes(120));
        Slot slot21 = new Slot("A9", localTime.plusMinutes(120), localTime.plusMinutes(135));
        Slot slot22 = new Slot("A10", localTime.plusMinutes(135), localTime.plusMinutes(150));
        Slot slot23 = new Slot("A11", localTime.plusMinutes(150), localTime.plusMinutes(165));
        Slot slot24 = new Slot("A12", localTime.plusMinutes(165), localTime.plusMinutes(180));

        localTime = LocalTime.of(15, 0, 0);
        Slot slot25 = new Slot("E1", localTime, localTime.plusMinutes(15));
        Slot slot26 = new Slot("E2", localTime.plusMinutes(15), localTime.plusMinutes(30));
        Slot slot27 = new Slot("E3", localTime.plusMinutes(30), localTime.plusMinutes(45));
        Slot slot28 = new Slot("E4", localTime.plusMinutes(45), localTime.plusMinutes(60));
        Slot slot29 = new Slot("E5", localTime.plusMinutes(60), localTime.plusMinutes(75));
        Slot slot30 = new Slot("E6", localTime.plusMinutes(75), localTime.plusMinutes(90));
        Slot slot31 = new Slot("E7", localTime.plusMinutes(90), localTime.plusMinutes(105));
        Slot slot32 = new Slot("E8", localTime.plusMinutes(105), localTime.plusMinutes(120));
        Slot slot33 = new Slot("E9", localTime.plusMinutes(120), localTime.plusMinutes(135));
        Slot slot34 = new Slot("E10", localTime.plusMinutes(135), localTime.plusMinutes(150));
        Slot slot35 = new Slot("E11", localTime.plusMinutes(150), localTime.plusMinutes(165));
        Slot slot36 = new Slot("E12", localTime.plusMinutes(165), localTime.plusMinutes(180));

        localTime = LocalTime.of(18, 0, 0);
        Slot slot37 = new Slot("N1", localTime, localTime.plusMinutes(15));
        Slot slot38 = new Slot("N2", localTime.plusMinutes(15), localTime.plusMinutes(30));
        Slot slot39 = new Slot("N3", localTime.plusMinutes(30), localTime.plusMinutes(45));
        Slot slot40 = new Slot("N4", localTime.plusMinutes(45), localTime.plusMinutes(60));
        Slot slot41 = new Slot("N5", localTime.plusMinutes(60), localTime.plusMinutes(75));
        Slot slot42 = new Slot("N6", localTime.plusMinutes(75), localTime.plusMinutes(90));
        Slot slot43 = new Slot("N7", localTime.plusMinutes(90), localTime.plusMinutes(105));
        Slot slot44 = new Slot("N8", localTime.plusMinutes(105), localTime.plusMinutes(120));
        Slot slot45 = new Slot("N9", localTime.plusMinutes(120), localTime.plusMinutes(135));
        Slot slot46 = new Slot("N10", localTime.plusMinutes(135), localTime.plusMinutes(150));
        Slot slot47 = new Slot("N11", localTime.plusMinutes(150), localTime.plusMinutes(165));
        Slot slot48 = new Slot("N12", localTime.plusMinutes(165), localTime.plusMinutes(180));

        List<Slot> slotList = new ArrayList<>();
        slotList.add(slot1);
        slotList.add(slot2);
        slotList.add(slot3);
        slotList.add(slot4);
        slotList.add(slot5);
        slotList.add(slot6);
        slotList.add(slot7);
        slotList.add(slot8);
        slotList.add(slot9);
        slotList.add(slot10);
        slotList.add(slot11);
        slotList.add(slot12);
        slotList.add(slot13);
        slotList.add(slot14);
        slotList.add(slot15);
        slotList.add(slot16);
        slotList.add(slot17);
        slotList.add(slot18);
        slotList.add(slot19);
        slotList.add(slot20);
        slotList.add(slot21);
        slotList.add(slot22);
        slotList.add(slot23);
        slotList.add(slot24);
        slotList.add(slot25);
        slotList.add(slot26);
        slotList.add(slot27);
        slotList.add(slot28);
        slotList.add(slot29);
        slotList.add(slot30);
        slotList.add(slot31);
        slotList.add(slot32);
        slotList.add(slot33);
        slotList.add(slot34);
        slotList.add(slot35);
        slotList.add(slot36);
        slotList.add(slot37);
        slotList.add(slot38);
        slotList.add(slot39);
        slotList.add(slot40);
        slotList.add(slot41);
        slotList.add(slot42);
        slotList.add(slot43);
        slotList.add(slot44);
        slotList.add(slot45);
        slotList.add(slot46);
        slotList.add(slot47);
        slotList.add(slot48);

        slotRepository.saveAll(slotList);

        LOGGER.info("Initializing the vaccine data");
        Vaccine vaccine1 = new Vaccine("a1@gmail.com", branch1, LocalDate.now(), LocalDateTime.now(), slot1, PaymentMethod.CASH, false);
        Vaccine vaccine2 = new Vaccine("a2@gmail.com", branch2, LocalDate.now(), LocalDateTime.now(), slot1, PaymentMethod.CASH, false);
        Vaccine vaccine3 = new Vaccine("a3@gmail.com", branch3, LocalDate.now(), LocalDateTime.now(), slot1, PaymentMethod.CASH, false);
        Vaccine vaccine4 = new Vaccine("a4@gmail.com", branch4, LocalDate.now(), LocalDateTime.now(), slot1, PaymentMethod.CASH, false);
        Vaccine vaccine5 = new Vaccine("a5@gmail.com", branch5, LocalDate.now(), LocalDateTime.now(), slot1, PaymentMethod.CASH, false);

        Vaccine vaccine6 = new Vaccine("b1@gmail.com", branch1, LocalDate.now(), LocalDateTime.now(), slot2, PaymentMethod.CASH, false);
        Vaccine vaccine7 = new Vaccine("b2@gmail.com", branch2, LocalDate.now(), LocalDateTime.now(), slot2, PaymentMethod.CASH, false);
        Vaccine vaccine8 = new Vaccine("b3@gmail.com", branch3, LocalDate.now(), LocalDateTime.now(), slot2, PaymentMethod.CASH, false);
        Vaccine vaccine9 = new Vaccine("b4@gmail.com", branch4, LocalDate.now(), LocalDateTime.now(), slot2, PaymentMethod.CASH, false);
        Vaccine vaccine10 = new Vaccine("b5@gmail.com", branch5, LocalDate.now(), LocalDateTime.now(), slot2, PaymentMethod.CASH, false);

        Vaccine vaccine11 = new Vaccine("c1@gmail.com", branch1, LocalDate.now(), LocalDateTime.now(), slot3, PaymentMethod.CASH, false);
        Vaccine vaccine12 = new Vaccine("c2@gmail.com", branch2, LocalDate.now(), LocalDateTime.now(), slot3, PaymentMethod.CASH, false);
        Vaccine vaccine13 = new Vaccine("c3@gmail.com", branch3, LocalDate.now(), LocalDateTime.now(), slot3, PaymentMethod.CASH, false);
        Vaccine vaccine14 = new Vaccine("c4@gmail.com", branch4, LocalDate.now(), LocalDateTime.now(), slot3, PaymentMethod.CASH, false);
        Vaccine vaccine15 = new Vaccine("c5@gmail.com", branch5, LocalDate.now(), LocalDateTime.now(), slot3, PaymentMethod.CASH, false);

        Vaccine vaccine16 = new Vaccine("d1@gmail.com", branch1, LocalDate.now(), LocalDateTime.now(), slot4, PaymentMethod.CASH, false);
        Vaccine vaccine17 = new Vaccine("d2@gmail.com", branch2, LocalDate.now(), LocalDateTime.now(), slot4, PaymentMethod.CASH, false);
        Vaccine vaccine18 = new Vaccine("d3@gmail.com", branch3, LocalDate.now(), LocalDateTime.now(), slot4, PaymentMethod.CASH, false);
        Vaccine vaccine19 = new Vaccine("d4@gmail.com", branch4, LocalDate.now(), LocalDateTime.now(), slot4, PaymentMethod.CASH, false);
        Vaccine vaccine20 = new Vaccine("d5@gmail.com", branch5, LocalDate.now(), LocalDateTime.now(), slot4, PaymentMethod.CASH, false);

        List<Vaccine> vaccineList = new ArrayList<>();
        vaccineList.add(vaccine1);
        vaccineList.add(vaccine2);
        vaccineList.add(vaccine3);
        vaccineList.add(vaccine4);
        vaccineList.add(vaccine5);
        vaccineList.add(vaccine6);
        vaccineList.add(vaccine7);
        vaccineList.add(vaccine8);
        vaccineList.add(vaccine9);
        vaccineList.add(vaccine10);
        vaccineList.add(vaccine11);
        vaccineList.add(vaccine12);
        vaccineList.add(vaccine13);
        vaccineList.add(vaccine14);
        vaccineList.add(vaccine15);
        vaccineList.add(vaccine16);
        vaccineList.add(vaccine17);
        vaccineList.add(vaccine18);
        vaccineList.add(vaccine19);
        vaccineList.add(vaccine20);

        vaccineRepository.saveAll(vaccineList);
    }
}
