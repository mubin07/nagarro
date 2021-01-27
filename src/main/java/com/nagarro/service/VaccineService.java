package com.nagarro.service;

import com.nagarro.dto.SlotDto;
import com.nagarro.dto.VaccineDto;
import com.nagarro.exception.AppointmentNotAvailableException;
import com.nagarro.exception.SlotNotAvailableException;
import com.nagarro.exception.VaccineNotAvailableException;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {

    VaccineDto bookAppointment(final VaccineDto vaccineDto) throws VaccineNotAvailableException, SlotNotAvailableException;

    List<SlotDto> findBookedTimeSlotForDatePerBranch(final Long branchId, final LocalDate date) throws SlotNotAvailableException;

    List<VaccineDto> findUnAppliedVaccineByDate(final LocalDate date) throws AppointmentNotAvailableException;
}
