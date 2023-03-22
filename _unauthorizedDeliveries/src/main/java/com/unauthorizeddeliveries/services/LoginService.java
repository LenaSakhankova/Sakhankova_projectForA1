package com.unauthorizeddeliveries.services;

import com.unauthorizeddeliveries.repositories.LoginRepository;
import com.unauthorizeddeliveries.mappers.LoginMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LoginService {
    private final LoginRepository loginRepository;


    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @Transactional
    public void putLoginsToDB(){
        loginRepository.saveAll(LoginMapper.mapLoginDTOsToLoginEntity(ExelUploadService.loginDTOS));
    }

}
