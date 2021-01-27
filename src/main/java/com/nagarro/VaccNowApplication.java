package com.nagarro;

import com.nagarro.service.VaccineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaccNowApplication implements CommandLineRunner {

    @Autowired
    private VaccineServiceImpl vaccineService;

    public static void main(String[] args) {
        SpringApplication.run(VaccNowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
