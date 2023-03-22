package com.unauthorizeddeliveries.dtos;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {

    @CsvBindByName(column = "Application")
    private String application;

    @CsvBindByName(column = "AppAccountName")
    private String appAccountName;

    @CsvBindByName(column = "IsActive")
    private String isActive;

    @CsvBindByName(column = "JobTitle")
    private String jobTitle;

    @CsvBindByName(column = "Department")
    private String department;




}
