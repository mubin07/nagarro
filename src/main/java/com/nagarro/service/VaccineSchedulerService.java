package com.nagarro.service;

import com.nagarro.dto.VaccineDto;
import com.nagarro.entity.Branch;
import com.nagarro.entity.Vaccine;
import com.nagarro.exception.AppointmentNotAvailableException;
import com.nagarro.repository.BranchRepository;
import com.nagarro.repository.VaccineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@EnableScheduling
@EnableAsync
public class VaccineSchedulerService {

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private MapperService mapperService;

    private final Logger LOGGER = LoggerFactory.getLogger(VaccineSchedulerService.class);

    @Scheduled(cron = "0 */2 9-21 * * *")
    @Transactional
    public void scheduleVaccinationJob() {
        LocalDate localDate = LocalDate.now();
        LOGGER.info("Getting un applied vaccine for today");
        try {
            List<VaccineDto> vaccineDtoList = vaccineService.findUnAppliedVaccineByDate(localDate);
            LOGGER.info("Total un applied vaccine for today " + vaccineDtoList.size());
            Map<Long, List<VaccineDto>> branchVaccineMap = vaccineDtoList.stream().collect(Collectors.groupingBy(v -> v.getBranch().getBranchId()));
            for (Map.Entry<Long, List<VaccineDto>> entry : branchVaccineMap.entrySet()) {
                Long branchId = entry.getKey();
                List<VaccineDto> vaccineDtos = entry.getValue();
                if (vaccineDtos.isEmpty()) {
                    LOGGER.info("No un applied vaccine for branch id " + branchId);
                } else {
                    applyVaccine(branchId, vaccineDtos);
                }
            }
        } catch (AppointmentNotAvailableException e) {
            LOGGER.info(e.getMessage());
        }
    }

    private void applyVaccine(Long branchId, List<VaccineDto> vaccineDtos) {
        LOGGER.info("Total un applied vaccine for branch id " + branchId + " is " + vaccineDtos.size());
        vaccineDtos.forEach(v -> v.setIsApplied(true));
        List<Vaccine> vaccineList = mapperService.mapList(vaccineDtos, Vaccine.class);
        vaccineRepository.saveAll(vaccineList);
        Branch branch = branchRepository.findById(branchId).get();
        branch.setAppliedVaccine(branch.getAppliedVaccine() + vaccineDtos.size());
        branchRepository.save(branch);
        LOGGER.info("Successfully applied vaccine for branch id " + branchId);
    }
}
