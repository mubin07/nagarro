package com.nagarro.service;

import com.nagarro.dto.VaccineDto;
import com.nagarro.entity.Branch;
import com.nagarro.entity.Vaccine;
import com.nagarro.repository.BranchRepository;
import com.nagarro.repository.VaccineRepository;
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

    @Scheduled(cron = "0 */15 9-21 * * *")
    @Transactional
    public void scheduleVaccinationJob() {
//        LocalDate localDate = LocalDate.now();
//        List<VaccineDto> vaccineDtoList = vaccineService.findUnAppliedVaccineByDate(localDate);
//        Map<Long, List<VaccineDto>> branchVaccineMap = vaccineDtoList.stream().collect(Collectors.groupingBy(v -> v.getBranch().getBranchId()));
//        for (Map.Entry<Long, List<VaccineDto>> entry : branchVaccineMap.entrySet()) {
//            Long branchId = entry.getKey();
//            List<VaccineDto> vaccineDtos = entry.getValue();
//            vaccineDtos.forEach(v -> v.setIsApplied(true));
//            List<Vaccine> vaccineList = mapperService.mapList(vaccineDtos, Vaccine.class);
//            vaccineRepository.saveAll(vaccineList);
//            Branch branch = branchRepository.findById(branchId).get();
//            branch.setAppliedVaccine(branch.getAppliedVaccine() + vaccineDtos.size());
//            branchRepository.save(branch);
//        }
    }
}
