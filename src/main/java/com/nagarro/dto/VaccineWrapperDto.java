package com.nagarro.dto;

import lombok.Data;

import java.util.List;

@Data
public class VaccineWrapperDto {

    private List<VaccineDto> vaccineDtoList;
}
