package com.nagarro.repository;

import com.nagarro.entity.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    @Query("SELECT s from Schedule s where  s.scheduleId.branchId = :branchId and s.scheduleId.appointmentDate = :appointmentDate and s.scheduleId.slotId = :slotId")
    Schedule findBySchedule(@Param("branchId") Long branchId, @Param("appointmentDate") LocalDate appointmentDate, @Param("slotId") String slotId);
}
