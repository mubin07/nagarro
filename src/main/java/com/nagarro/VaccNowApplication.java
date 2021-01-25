package com.nagarro;

import com.nagarro.constants.PaymentMethod;
import com.nagarro.dto.VaccineDto;
import com.nagarro.entity.Branch;
import com.nagarro.entity.Vaccine;
import com.nagarro.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class VaccNowApplication implements CommandLineRunner {

    @Autowired
    private VaccineService vaccineService;

    public static void main(String[] args) {
        SpringApplication.run(VaccNowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        VaccineDto vaccineDto = new VaccineDto(1L, "abc@gmail.com", 1L, LocalDate.of(2021, 1, 25), LocalDateTime.now(), "M2", PaymentMethod.CASH);
        Vaccine vaccine = vaccineService.bookAppointment(vaccineDto);
        System.out.println(vaccine);
        System.exit(0);
    }
}
