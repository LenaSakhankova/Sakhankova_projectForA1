package com.unauthorizeddeliveries.mappers;

import com.unauthorizeddeliveries.dtos.LoginDTO;
import com.unauthorizeddeliveries.entities.LoginEntity;

import java.util.ArrayList;
import java.util.List;


public class LoginMapper {
    
    public static List<LoginEntity> mapLoginDTOsToLoginEntity(List<LoginDTO> loginDTOS){

        List<LoginEntity> listOfLoginEntities = new ArrayList<>();

        loginDTOS.forEach(loginDTO -> {
            LoginEntity loginEntity = new LoginEntity();

            loginEntity.setApplication(loginDTO.getApplication());
            loginEntity.setAppAccountName(loginDTO.getAppAccountName());
            loginEntity.setIsActive(loginDTO.equals("True"));
            loginEntity.setJobTitle(loginDTO.getJobTitle());
            loginEntity.setDepartment(loginDTO.getDepartment());

            listOfLoginEntities.add(loginEntity);
        });

        return listOfLoginEntities;
    }


}
