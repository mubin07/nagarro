package com.nagarro.repository;

import com.nagarro.entity.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine, Long> {

}
