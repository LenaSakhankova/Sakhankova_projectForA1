package com.unauthorizeddeliveries.services;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.unauthorizeddeliveries.dtos.LoginDTO;
import com.unauthorizeddeliveries.dtos.PostingDTO;
import jakarta.annotation.PostConstruct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ExelUploadService {

    public static List<LoginDTO> loginDTOS = new ArrayList<>();

    public static List<PostingDTO> postingDTOList = new ArrayList<>();

    @PostConstruct
    public void init() throws CsvValidationException, IOException {
        generateListOfLoginDTOsFromUploadFile();
        generateListOfPositionDTOsFromUploadFile();
    }

    public void generateListOfPositionDTOsFromUploadFile() throws IOException {

        String line;

        BufferedReader br = new BufferedReader(new FileReader("D:\\Projects_idea\\_unauthorizedDeliveries\\postings.csv"));

        while ((line = br.readLine()) != null) {
            // split by a comma separator
            String[] split = line.split(";");

            if (split.length > 1) {

                PostingDTO postingDTO = new PostingDTO();

                postingDTO.setMatDoc(split[0].trim());
                postingDTO.setItem(split[1].trim());
                postingDTO.setDocDate(split[2].trim());
                postingDTO.setPstngDate(split[3].trim());
                postingDTO.setMaterialDescription(split[4].trim());
                postingDTO.setQuantity(split[5].trim());
                postingDTO.setBun(split[6].trim());
                postingDTO.setAmountLc(split[7].replaceAll(",", ".").contains(".") ?
                        split[7].replaceAll(",", ".").trim() : split[7].replaceAll(",", ".").trim() + ".0");
                postingDTO.setCrcy(split[8].trim());

                String userName = split[9].trim();
                postingDTO.setUserName(userName);

                loginDTOS.forEach(value -> {

                    if(value.getAppAccountName().equals(userName)){

                        postingDTO.setAuthorizedDelivery(value.getIsActive().equals("True"));
                    }
                });

                postingDTOList.add(postingDTO);
            }
        }

        postingDTOList.remove(0);
    }

    public void generateListOfLoginDTOsFromUploadFile() throws IOException{
        loginDTOS = new CsvToBeanBuilder(new FileReader("D:\\Projects_idea\\_unauthorizedDeliveries\\logins.csv"))
                .withType(LoginDTO.class)
                .build()
                .parse();


        loginDTOS.forEach(value -> {
         value.setAppAccountName(value.getAppAccountName().trim());
         value.setIsActive(value.getIsActive().trim());
         value.setJobTitle(value.getJobTitle().trim());
         value.setDepartment(value.getDepartment().trim());
        });

    }

}
